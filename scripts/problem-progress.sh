#!/usr/bin/env bash

set -euo pipefail

script_dir="$(cd -- "$(dirname -- "${BASH_SOURCE[0]}")" && pwd)"
repository_root="$(cd -- "$script_dir/.." && pwd)"
source_root="$repository_root/src/main/kotlin/leetcode"
test_root="$repository_root/src/test/kotlin/leetcode"

declare -A completed_problem_ids=()
tracked_total=0
completed_total=0

while IFS= read -r problem_directory; do
    problem_package="${problem_directory##*/}"
    problem_id="${problem_package#p}"
    ((tracked_total += 1))

    source_file="$(find "$problem_directory" -maxdepth 1 -type f -name '*.kt' -print -quit)"
    test_file="$(find "$test_root/$problem_package" -maxdepth 1 -type f -name '*Test.kt' -print -quit 2>/dev/null || true)"

    if [[ -z "$source_file" || -z "$test_file" ]]; then
        continue
    fi

    if grep -R -F -q 'TODO("Implement solution")' "$problem_directory"; then
        continue
    fi

    completed_problem_ids["$problem_id"]=1
    ((completed_total += 1))
done < <(find "$source_root" -mindepth 1 -maxdepth 1 -type d -name 'p[0-9][0-9][0-9][0-9]' | sort)

count_study_plan() {
    local manifest="$1"
    local expected_total="$2"
    local line
    local problem_id
    local completed=0
    local total=0
    declare -A seen_problem_ids=()

    while IFS= read -r line || [[ -n "$line" ]]; do
        problem_id="${line%%#*}"
        problem_id="${problem_id//[[:space:]]/}"

        if [[ -z "$problem_id" ]]; then
            continue
        fi

        if [[ ! "$problem_id" =~ ^[0-9]{4}$ ]]; then
            echo "Invalid problem number '$problem_id' in $manifest" >&2
            return 1
        fi

        if [[ -n "${seen_problem_ids[$problem_id]+present}" ]]; then
            echo "Duplicate problem number '$problem_id' in $manifest" >&2
            return 1
        fi

        seen_problem_ids["$problem_id"]=1
        ((total += 1))

        if [[ -n "${completed_problem_ids[$problem_id]+present}" ]]; then
            ((completed += 1))
        fi
    done < "$manifest"

    if [[ "$total" -ne "$expected_total" ]]; then
        echo "Expected $expected_total problems in $manifest, found $total" >&2
        return 1
    fi

    printf '%s %s\n' "$completed" "$total"
}

read -r leetcode_75_completed leetcode_75_total < <(
    count_study_plan "$repository_root/.github/problem-sets/leetcode-75.txt" 75
)
read -r top_150_completed top_150_total < <(
    count_study_plan "$repository_root/.github/problem-sets/top-interview-150.txt" 150
)

summary="$(printf '%s\n\n%s\n%s\n%s\n%s\n%s\n\n%s' \
    '## LeetCode progress' \
    '| Collection | Completed |' \
    '| --- | ---: |' \
    "| All repository problems | $completed_total / $tracked_total |" \
    "| LeetCode 75 | $leetcode_75_completed / $leetcode_75_total |" \
    "| Top Interview 150 | $top_150_completed / $top_150_total |" \
    '_A problem counts as completed when it has solution and test files, contains no setup TODO, and the CI test suite passes._')"

printf '%s\n' "$summary"

if [[ -n "${GITHUB_STEP_SUMMARY:-}" ]]; then
    printf '%s\n' "$summary" >> "$GITHUB_STEP_SUMMARY"
fi
