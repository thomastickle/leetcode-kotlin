package leetcode.p1456

/**
 * # 1456. Maximum Number of Vowels in a Substring of Given Length
 *
 * Given a string `s` and an integer `k`, return the maximum number of vowel letters in any
 * substring of `s` with length `k`. The English vowel letters are `'a'`, `'e'`, `'i'`, `'o'`,
 * and `'u'`.
 *
 * Examples:
 * - Input: `s = "abciiidef"`, `k = 3`. Output: `3`. The substring `"iii"` contains three
 *   vowel letters.
 * - Input: `s = "aeiou"`, `k = 2`. Output: `2`. Every substring of length `2` contains two
 *   vowel letters.
 * - Input: `s = "leetcode"`, `k = 3`. Output: `2`. The substrings `"lee"`, `"eet"`, and
 *   `"ode"` each contain two vowel letters.
 *
 * Constraints:
 * - `1 <= s.length <= 10^5`
 * - `s` consists of lowercase English letters.
 * - `1 <= k <= s.length`
 *
 * [LeetCode 1456: Maximum Number of Vowels in a Substring of Given Length](https://leetcode.com/problems/maximum-number-of-vowels-in-a-substring-of-given-length/)
 */
class Solution {
    fun maxVowels(s: String, k: Int): Int {
        fun Char.isVowel() = when(this) {
            'a', 'e', 'i', 'o', 'u' -> true
            else -> false
        }

        var vowelCount = 0
        for (i in 0 until k) {
            if (s[i].isVowel()) {
                vowelCount++
            }
        }

        if (vowelCount == k) {
            return vowelCount
        }

        var maxVowelCount = vowelCount
        for (i in k until s.length) {
            if (s[i].isVowel()) {
                vowelCount++
            }
            if (s[i - k].isVowel()) {
                vowelCount--
            }
            maxVowelCount = maxOf(maxVowelCount, vowelCount)
            if (maxVowelCount == k) {
                return maxVowelCount
            }
        }

        return maxVowelCount
    }
}
