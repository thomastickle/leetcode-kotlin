package leetcode.p0394

/**
 * # 394. Decode String
 *
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: `k[encoded_string]`, where the `encoded_string` inside the square
 * brackets is being repeated exactly `k` times. Note that `k` is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; there are no extra white spaces, square
 * brackets are well-formed, etc. Furthermore, you may assume that the original data does not
 * contain any digits and that digits are only for those repeat numbers, `k`. For example, there
 * will not be input like `3a` or `2[4]`.
 *
 * The test cases are generated so that the length of the output will never exceed `10^5`.
 *
 * Examples:
 * - Input: `s = "3[a]2[bc]"`. Output: `"aaabcbc"`.
 * - Input: `s = "3[a2[c]]"`. Output: `"accaccacc"`.
 * - Input: `s = "2[abc]3[cd]ef"`. Output: `"abcabccdcdcdef"`.
 *
 * Constraints:
 * - `1 <= s.length <= 30`
 * - `s` consists of lowercase English letters, digits, and square brackets `'['` and `']'`.
 * - `s` is guaranteed to be a **valid** input.
 * - All the integers in `s` are in the range `[1, 300]`.
 *
 * [LeetCode 394: Decode String](https://leetcode.com/problems/decode-string/)
 */
class Solution {
    private data class Frame(
        val parent: StringBuilder,
        val count: Int
    )

    fun decodeString(s: String): String {
        val stack = ArrayDeque<Frame>()

        var current = StringBuilder()
        var count = 0

        for (character in s) {
            if (character.isDigit()) {
                count = count * 10 + (character - '0')
            } else if (character == '[') {
                stack.addLast(Frame(current, count))
                current = StringBuilder()
                count = 0
            } else if (character == ']') {
                val nested = current
                val frame = stack.removeLast()

                current = frame.parent

                repeat(frame.count) {
                    current.append(nested)
                }
            } else {
                current.append(character)
            }
        }

        return current.toString()
    }

}