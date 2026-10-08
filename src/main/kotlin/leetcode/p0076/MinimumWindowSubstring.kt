package leetcode.p0076

/**
 * # 76. Minimum Window Substring
 *
 * Given two strings `s` and `t` of lengths `m` and `n` respectively, return the **minimum window
 * substring** of `s` such that every character in `t` (**including duplicates**) is included in the
 * window. If there is no such substring, return the empty string `""`.
 *
 * The testcases will be generated such that the answer is **unique**.
 *
 * Examples:
 * - Input: `s = "ADOBECODEBANC"`, `t = "ABC"`. Output: `"BANC"`.
 *   Explanation: The minimum window substring `"BANC"` includes `'A'`, `'B'`, and `'C'` from string `t`.
 * - Input: `s = "a"`, `t = "a"`. Output: `"a"`.
 *   Explanation: The entire string `s` is the minimum window.
 * - Input: `s = "a"`, `t = "aa"`. Output: `""`.
 *   Explanation: Both `'a'`s from string `t` must be included in the window.
 *   Since the largest window of `s` only has one `'a'`, return empty string.
 *
 * Constraints:
 * - `m == s.length`
 * - `n == t.length`
 * - `1 <= m, n <= 10^5`
 * - `s` and `t` consist of uppercase and lowercase English letters.
 *
 * Follow up: Could you find an algorithm that runs in `O(m + n)` time?
 *
 * [LeetCode 76: Minimum Window Substring](https://leetcode.com/problems/minimum-window-substring/)
 */
class Solution {

    fun minWindow(s: String, t: String): String {
        if (s.length < t.length) return ""

        val counts = IntArray(128)
        t.forEach { counts[it.code]++ }

        var charsRemaining = t.length
        var left = 0

        var minStart = 0
        var minLength = Int.MAX_VALUE

        s.forEachIndexed { right, c ->
            val index = c.code

            if (counts[index] > 0) {
                charsRemaining--
            }
            counts[index]--

            while (charsRemaining == 0) {
                val windowLength = right - left + 1

                if (windowLength < minLength) {
                    minStart = left
                    minLength = windowLength
                }

                val leftIndex = s[left].code
                counts[leftIndex]++

                if (counts[leftIndex] > 0) {
                    charsRemaining++
                }

                left++
            }
        }

        return if (minLength == Int.MAX_VALUE) {
            ""
        } else {
            s.substring(minStart, minStart + minLength)
        }
    }
}
