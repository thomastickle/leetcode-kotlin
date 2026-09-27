package leetcode.p0125

/**
 * # 125. Valid Palindrome
 *
 * A phrase is a palindrome if, after converting all uppercase letters to lowercase and removing
 * all non-alphanumeric characters, it reads the same forward and backward. Alphanumeric
 * characters include letters and numbers.
 *
 * Given a string `s`, return `true` if it is a palindrome after applying those transformations, or
 * `false` otherwise.
 *
 * Examples:
 * - Input: `s = "A man, a plan, a canal: Panama"`. Output: `true`.
 *   Explanation: After converting to lowercase and removing non-alphanumeric characters, the
 *   string becomes `"amanaplanacanalpanama"`, which reads the same forward and backward.
 * - Input: `s = "race a car"`. Output: `false`.
 *   Explanation: After removing spaces and ignoring case, the string becomes `"raceacar"`, which
 *   is not a palindrome.
 * - Input: `s = " "`. Output: `true`.
 *   Explanation: Removing non-alphanumeric characters leaves an empty string. An empty string
 *   reads the same forward and backward, so it is a palindrome.
 *
 * Constraints:
 * - `1 <= s.length <= 2 * 10^5`
 * - `s` consists only of printable ASCII characters.
 *
 * [LeetCode 125: Valid Palindrome](https://leetcode.com/problems/valid-palindrome/)
 */
class Solution {
    fun isPalindrome(s: String): Boolean {
        var left = 0
        var right = s.length - 1

        while (left < right) {
            if (!s[left].isLetterOrDigit()) {
                left++
                continue
            }

            if (!s[right].isLetterOrDigit()) {
                right--
                continue
            }

            if (s[left].lowercaseChar() != s[right].lowercaseChar()) {
                return false
            }
            left++
            right--
        }

        return true
    }
}
