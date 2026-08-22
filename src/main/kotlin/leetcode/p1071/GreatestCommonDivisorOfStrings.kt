package leetcode.p1071

/**
 * # 1071. Greatest Common Divisor of Strings
 *
 * A string `t` divides a string `s` when concatenating one or more copies of `t` produces `s`.
 * Given `str1` and `str2`, return the longest string `x` that divides both inputs.
 *
 * Examples:
 * - `str1 = "ABCABC"`, `str2 = "ABC"` returns `"ABC"`.
 * - `str1 = "ABABAB"`, `str2 = "ABAB"` returns `"AB"`.
 * - `str1 = "LEET"`, `str2 = "CODE"` returns `""`.
 * - `str1 = "AAAAAB"`, `str2 = "AAA"` returns `""`.
 *
 * Constraints:
 * - `1 <= str1.length, str2.length <= 1000`
 * - Both strings contain only uppercase English letters.
 *
 * [LeetCode 1071: Greatest Common Divisor of Strings](https://leetcode.com/problems/greatest-common-divisor-of-strings/)
 */
class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        tailrec fun gcd(a: Int, b: Int): Int {
            return if (b == 0) a else gcd(b, a % b)
        }

        if (str1 + str2 != str2 + str1) {
            return ""
        }

        val length = gcd(str1.length, str2.length)
        return str1.substring(0, length)
    }
}
