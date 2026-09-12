package leetcode.p0017

/**
 * # 17. Letter Combinations of a Phone Number
 *
 * Given a string containing digits from `2` through `9` inclusive, return all possible letter
 * combinations that the number could represent. Return the combinations in any order.
 *
 * The digit-to-letter mapping is the same as on telephone buttons:
 *
 * - `2` maps to `abc`.
 * - `3` maps to `def`.
 * - `4` maps to `ghi`.
 * - `5` maps to `jkl`.
 * - `6` maps to `mno`.
 * - `7` maps to `pqrs`.
 * - `8` maps to `tuv`.
 * - `9` maps to `wxyz`.
 *
 * The digit `1` does not map to any letters.
 *
 * Examples:
 * - Input: `digits = "23"`; output: `["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"]`.
 * - Input: `digits = "2"`; output: `["a", "b", "c"]`.
 *
 * Constraints:
 * - `1 <= digits.length <= 4`.
 * - `digits[i]` is a digit in the range `['2', '9']`.
 *
 * [LeetCode 17: Letter Combinations of a Phone Number](https://leetcode.com/problems/letter-combinations-of-a-phone-number/)
 */
class Solution {
    fun letterCombinations(digits: String): List<String> {
        fun mapDigit(digit: Char): String {
            return when (digit) {
                '2' -> "abc"
                '3' -> "def"
                '4' -> "ghi"
                '5' -> "jkl"
                '6' -> "mno"
                '7' -> "pqrs"
                '8' -> "tuv"
                else -> "wxyz"
            }
        }

        val output = mutableListOf<String>()

        fun computeString(digits: String, currentString: StringBuilder) {
            val currentLength = currentString.length
            if (currentLength == digits.length) {
                output.add(currentString.toString())
                return
            }

            for (character in mapDigit(digits[currentLength])) {
                currentString.append(character)
                computeString(digits, currentString)
                currentString.delete(currentString.length - 1, currentString.length)
            }
        }

        computeString(digits, StringBuilder())

        return output
    }
}