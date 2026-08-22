package leetcode.p0392

/**
 * # 392. Is Subsequence
 *
 * Given strings `s` and `t`, return `true` when `s` is a subsequence of `t`; otherwise, return
 * `false`.
 *
 * A subsequence is formed by deleting zero or more characters from a string without changing
 * the relative order of the characters that remain. For example, `"ace"` is a subsequence of
 * `"abcde"`, but `"aec"` is not.
 *
 * Examples:
 * - `s = "abc"`, `t = "ahbgdc"` returns `true`.
 * - `s = "axc"`, `t = "ahbgdc"` returns `false`.
 *
 * Constraints:
 * - `0 <= s.length <= 100`
 * - `0 <= t.length <= 10^4`
 * - Both strings contain only lowercase English letters.
 *
 * Follow-up: If a fixed `t` must be checked against at least `10^9` incoming strings
 * `s1, s2, ..., sk`, consider how the implementation should change to handle those repeated
 * subsequence queries efficiently.
 *
 * [LeetCode 392: Is Subsequence](https://leetcode.com/problems/is-subsequence/)
 */
class Solution {

    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        for (c in t) {
           if (i == s.length) break

           if (s[i] == c) {
              i++
           }
        }
        return i == s.length
    }
}
