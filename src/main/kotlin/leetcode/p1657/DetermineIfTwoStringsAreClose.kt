package leetcode.p1657

/**
 * # 1657. Determine if Two Strings Are Close
 *
 * Two strings are considered close if you can attain one from the other using the following
 * operations:
 * - Operation 1: Swap any two existing characters.
 *   - For example, `abcde -> aebcd`
 * - Operation 2: Transform every occurrence of one existing character into another existing
 *   character, and do the same with the other character.
 *   - For example, `aacabb -> bbcbaa` (all `a`'s turn into `b`'s, and all `b`'s turn into `a`'s)
 *
 * You can use the operations on either string as many times as necessary.
 *
 * Given two strings, `word1` and `word2`, return `true` if `word1` and `word2` are close, and
 * `false` otherwise.
 *
 * Examples:
 * - Input: `word1 = "abc"`, `word2 = "bca"`. Output: `true`.
 *   Explanation: You can attain `word2` from `word1` in 2 operations:
 *   - Apply Operation 1: `"abc" -> "acb"`
 *   - Apply Operation 1: `"acb" -> "bca"`
 * - Input: `word1 = "a"`, `word2 = "aa"`. Output: `false`.
 *   Explanation: It is impossible to attain `word2` from `word1`, or vice versa, in any number of
 *   operations.
 * - Input: `word1 = "cabbba"`, `word2 = "abbccc"`. Output: `true`.
 *   Explanation: You can attain `word2` from `word1` in 3 operations:
 *   - Apply Operation 1: `"cabbba" -> "caabbb"`
 *   - Apply Operation 2: `"caabbb" -> "baaccc"`
 *   - Apply Operation 2: `"baaccc" -> "abbccc"`
 *
 * Constraints:
 * - `1 <= word1.length, word2.length <= 10^5`
 * - `word1` and `word2` contain only lowercase English letters.
 *
 * [LeetCode 1657: Determine if Two Strings Are Close](https://leetcode.com/problems/determine-if-two-strings-are-close/)
 */
class Solution {
    fun closeStrings(word1: String, word2: String): Boolean {
        fun getLetterFrequencies(word: String): IntArray {
            val letterFrequencies = IntArray(26)
            for (letter in word) {
                letterFrequencies[letter - 'a']++
            }
            return letterFrequencies
        }

        if (word1.length != word2.length) {
            return false
        }

        val word1Frequencies = getLetterFrequencies(word1)
        val word2Frequencies = getLetterFrequencies(word2)

        for (index in word1Frequencies.indices) {
            if ((word1Frequencies[index] == 0) != (word2Frequencies[index] == 0)) {
                return false
            }
        }

        word1Frequencies.sort()
        word2Frequencies.sort()

        return word1Frequencies.contentEquals(word2Frequencies)
    }
}
