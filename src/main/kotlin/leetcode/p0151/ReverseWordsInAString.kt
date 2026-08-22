package leetcode.p0151

/**
 * # 151. Reverse Words in a String
 *
 * Given a string `s`, return its words in reverse order. A word is a sequence of non-space
 * characters, and the input separates words with one or more spaces. Join the reversed words
 * with exactly one space, with no leading or trailing spaces in the result.
 *
 * Examples:
 * - `s = "the sky is blue"` returns `"blue is sky the"`.
 * - `s = "  hello world  "` returns `"world hello"`; surrounding spaces are removed.
 * - `s = "a good   example"` returns `"example good a"`; repeated separators become one space.
 *
 * Constraints:
 * - `1 <= s.length <= 10^4`
 * - `s` contains uppercase and lowercase English letters, digits, and space characters.
 * - `s` contains at least one word.
 *
 * Follow-up: If strings are mutable in the chosen language, solve the problem in place with
 * `O(1)` additional space.
 *
 * [LeetCode 151: Reverse Words in a String](https://leetcode.com/problems/reverse-words-in-a-string/)
 */
class Solution {
//    fun reverseWords(s: String) =
//        s.split(" ").filter { it.isNotEmpty() }.asReversed().joinToString(" ")

    fun reverseWords(s: String): String {
        val output = StringBuilder()
        var i = s.length - 1  // We use this because leetcode makes the kotlin stdlib very costly
        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s[i] == ' ') {
                i--
            }

            if (i < 0) break

            val wordEnd = i

            // Find beginning of word
            while (i >= 0 && s[i] != ' ') {
                i--
            }

            if (output.isNotEmpty()) {
                output.append(' ')
            }

            output.append(s, i + 1, wordEnd + 1)
        }

        return output.toString()
    }


}
