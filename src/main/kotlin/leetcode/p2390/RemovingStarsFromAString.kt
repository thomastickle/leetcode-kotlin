package leetcode.p2390

/**
 * # 2390. Removing Stars From a String
 *
 * You are given a string `s`, which contains stars `*`.
 *
 * In one operation, you can:
 * - Choose a star in `s`.
 * - Remove the closest non-star character to its left, as well as the star itself.
 *
 * Return the string after **all** stars have been removed.
 *
 * **Note:**
 * - The input will be generated such that the operation is always possible.
 * - It can be shown that the resulting string will always be unique.
 *
 * Examples:
 * - Input: `s = "leet**cod*e"`. Output: `"lecoe"`.
 *   Explanation: Performing the removals from left to right:
 *   - The closest character to the 1st star is `'t'` in `"leet**cod*e"`. `s` becomes `"lee*cod*e"`.
 *   - The closest character to the 2nd star is `'e'` in `"lee*cod*e"`. `s` becomes `"lecod*e"`.
 *   - The closest character to the 3rd star is `'d'` in `"lecod*e"`. `s` becomes `"lecoe"`.
 *   There are no more stars, so we return `"lecoe"`.
 * - Input: `s = "erase*****"`. Output: `""`.
 *   Explanation: The entire string is removed, so we return `""`.
 *
 * Constraints:
 * - `1 <= s.length <= 10^5`
 * - `s` consists of lowercase English letters and stars `*`.
 * - The operation above can be performed on `s`.
 *
 * [LeetCode 2390: Removing Stars From a String](https://leetcode.com/problems/removing-stars-from-a-string/)
 */
class Solution {
    fun removeStars(s: String): String {
        val outputBuffer = StringBuilder()
        for (c in s) {
            if (c == '*') {
                outputBuffer.setLength(outputBuffer.length - 1)
            } else {
                outputBuffer.append(c)
            }
        }
        return outputBuffer.toString()
    }
}
