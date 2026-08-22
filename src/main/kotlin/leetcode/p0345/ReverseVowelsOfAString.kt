package leetcode.p0345

/**
 * # 345. Reverse Vowels of a String
 *
 * Given a string `s`, reverse only its vowels and return the resulting string. Vowels are `a`,
 * `e`, `i`, `o`, and `u`; they may be uppercase or lowercase and may occur more than once.
 *
 * Examples:
 * - `s = "IceCreAm"` returns `"AceCreIm"` by reversing the vowel sequence `I, e, e, A`.
 * - `s = "leetcode"` returns `"leotcede"`.
 *
 * Constraints:
 * - `1 <= s.length <= 3 * 10^5`
 * - `s` contains printable ASCII characters.
 *
 * [LeetCode 345: Reverse Vowels of a String](https://leetcode.com/problems/reverse-vowels-of-a-string/)
 */
class Solution {
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()

        fun Char.isVowel(): Boolean = when (this) {
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U' -> true

            else -> false
        }

        var left = 0
        var right = chars.lastIndex

        while (left < right) {
            while (left < right && !chars[left].isVowel()) {
                left++
            }

            while (left < right && !chars[right].isVowel()) {
                right--
            }

            if (left < right) {
                val temp = chars[left]
                chars[left] = chars[right]
                chars[right] = temp

                left++
                right--
            }
        }

        return chars.concatToString()

    }
}
