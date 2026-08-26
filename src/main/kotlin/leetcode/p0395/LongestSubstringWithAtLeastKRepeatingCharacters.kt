package leetcode.p0395

/**
 * # 395. Longest Substring with At Least K Repeating Characters
 *
 * Given a string `s` and an integer `k`, return the length of the longest substring of `s`
 * such that the frequency of each character in this substring is greater than or equal to `k`.
 *
 * if no such substring exists, return `0`.
 *
 * Examples:
 * - Input: `s = "aaabb", k = 3`. Output: `3`.
 *   Explanation: The longest substring is `"aaa"`, as `'a'` is repeated 3 times.
 * - Input: `s = "ababbc", k = 2`. Output: `5`.
 *   Explanation: The longest substring is `"ababb"`, as `'a'` is repeated 2 times and `'b'` is repeated 3 times.
 *
 * Constraints:
 * - `1 <= s.length <= 10^4`
 * - `s` consists of only lowercase English letters.
 * - `1 <= k <= 10^5`
 *
 * [LeetCode 395: Longest Substring with At Least K Repeating Characters](https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/)
 */
class Solution {
    fun longestSubstring(s: String, k: Int): Int {
        val pivots = s.groupingBy { it }.eachCount().filterValues { it < k }.keys

        if (pivots.isEmpty()) {
            return s.length
        }

        val sections = s.split(*pivots.toCharArray()).filter {it.isNotEmpty()}

        return sections.maxOfOrNull { section -> longestSubstring(section, k) } ?: 0
    }
}
