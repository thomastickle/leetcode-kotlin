# AGENTS.md

## Repository Purpose

This repository is primarily for programming practice and LeetCode-style
problems.

The human developer is responsible for designing and implementing the
solutions. Agent assistance should support the development process without
taking over the problem-solving exercise unless explicitly requested.

## Most Important Rule

When asked to create, update, generate, or configure tests:

**DO NOT IMPLEMENT OR MODIFY THE SOLUTION.**

A test-generation task is a test-only task.

It is acceptable and expected for newly created tests to fail when the
solution is incomplete or incorrect.

Do not make production/source-code changes merely to make generated tests
pass.

## Test Tasks

When the task is to add or improve tests, you may:

- Create test files.
- Modify existing test files.
- Add test fixtures or test data.
- Add imports required by the tests.
- Add or configure test dependencies when necessary.
- Make minimal test-build configuration changes required to execute tests.
- Run the appropriate test suite.
- Report compilation failures or failing tests.

When the task is to add or improve tests, you must NOT:

- Implement an unfinished solution.
- Fill in TODOs in solution code.
- Correct an algorithm.
- Optimize an algorithm.
- Refactor the solution.
- Change solution behavior to satisfy a test.
- Add hidden implementation logic to production code.
- Replace stubbed return values with working implementations.
- Add a second implementation of the algorithm to the tests simply to
  calculate expected answers.

If tests cannot compile because the solution is incomplete, report that fact
instead of modifying the solution.

If tests fail because the implementation is incorrect, leave the failure in
place and report it.

## Test Design

Prefer black-box tests against the public interface of the solution.

Use explicit expected results rather than reproducing the solution algorithm
inside the test suite.

For algorithm problems, consider:

- Examples from the problem statement.
- Minimum-size inputs.
- Maximum or boundary values where practical.
- Empty inputs when permitted by the problem.
- Single-element inputs when permitted.
- Duplicate values.
- Already sorted inputs.
- Reverse-sorted inputs.
- Negative values when permitted.
- Cases immediately surrounding important boundaries.
- Cases that distinguish superficially similar algorithms.

Test names should describe the behavior or scenario being tested.

Do not encode knowledge of the intended implementation into the tests unless
the task specifically concerns implementation details.

## Solution Tasks

Only implement or modify a problem solution when the user explicitly asks
for implementation work.

Examples of explicit implementation requests include:

- "Implement this solution."
- "Fix the implementation."
- "Make these tests pass."
- "Write the algorithm."
- "Refactor this solution."

Discussion, explanation, test generation, code review, and critique are NOT
implicit permission to implement the solution.

When the user asks for critique or hints, preserve the distinction between
explaining an idea and editing the implementation.

## Learning-Oriented Behavior

This repository is used for learning.

Do not prematurely provide or insert complete solutions when the current task
can be completed without doing so.

When asked for hints or analysis:

- Prefer identifying the next useful insight.
- Explain correctness issues in the developer's current approach.
- Do not replace their approach with a complete implementation unless asked.
- Preserve opportunities for the developer to work through the algorithm.

## Scope Discipline

Only modify files necessary for the requested task.

Do not perform unrelated cleanup, formatting, refactoring, dependency
upgrades, or architectural changes.

Do not modify an existing solution merely because you notice an improvement
while working on another task.

Preserve the repository's existing naming, package, formatting, and test
conventions unless explicitly asked to change them.

## Verification

After making changes, run the smallest relevant test command when practical.

For a test-generation task:

1. Generate or modify the tests.
2. Run the tests.
3. Report the result.
4. If they fail because of the solution, STOP.
5. Do not modify the solution to obtain a green test run.

A failing test suite can be the correct final result of a test-generation
task.

## Before Editing

Inspect nearby source and test files first to understand:

- Language and framework conventions.
- Package structure.
- Existing test framework.
- Naming conventions.
- Build commands.

Prefer following established repository patterns over introducing new ones.
