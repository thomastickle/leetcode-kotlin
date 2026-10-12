package leetcode.p0290

/**
 * # 290. Word Pattern
 *
 * Given a pattern and a string `s`, determine whether `s` follows the pattern. A full match
 * requires a bijection between each letter in `pattern` and a non-empty word in `s`: each letter
 * maps to exactly one unique word, and each unique word maps to exactly one letter. Thus, no two
 * letters can map to the same word, and no two words can map to the same letter.
 *
 * Examples:
 * - Input: `pattern = "abba"`, `s = "dog cat cat dog"`. Output: `true`. The mapping is `'a'` to
 *   `"dog"` and `'b'` to `"cat"`.
 * - Input: `pattern = "abba"`, `s = "dog cat cat fish"`. Output: `false`.
 * - Input: `pattern = "aaaa"`, `s = "dog cat cat dog"`. Output: `false`.
 *
 * Constraints:
 * - `1 <= pattern.length <= 300`
 * - `pattern` contains only lowercase English letters.
 * - `1 <= s.length <= 3000`
 * - `s` contains only lowercase English letters and spaces `' '`.
 * - `s` has no leading or trailing spaces, and its words are separated by a single space.
 *
 * [LeetCode 290: Word Pattern](https://leetcode.com/problems/word-pattern/)
 */
class Solution {
    fun wordPattern(pattern: String, s: String): Boolean {
        val letterToWords = arrayOfNulls<String>(26)
        val wordToLetters = HashMap<String, Char>()

        var patternIndex = 0
        var wordStart = 0

        for (i in 0..s.length) {
            if (i == s.length || s[i] == ' ') {
                if (patternIndex >= pattern.length) {
                    return false
                }

                val word = s.substring(wordStart, i)
                val letter = pattern[patternIndex]
                val letterIndex = letter - 'a'

                val letterToWord = letterToWords[letterIndex]
                val wordToLetter = wordToLetters[word]

                if (letterToWord == null && wordToLetter == null) {
                    letterToWords[letterIndex] = word
                    wordToLetters[word] = letter
                } else if (letterToWord != word || wordToLetter != letter) {
                    return false
                }

                patternIndex++
                wordStart = i + 1
            }
        }

        return patternIndex == pattern.length
    }
}
