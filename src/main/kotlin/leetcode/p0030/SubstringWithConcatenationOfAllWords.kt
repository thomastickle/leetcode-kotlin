package leetcode.p0030

/**
 * # 30. Substring with Concatenation of All Words
 *
 * You are given a string `s` and an array of strings `words`. All the strings in `words` have the
 * same length.
 *
 * A concatenated string is a string that exactly contains all the strings of any permutation of
 * `words` concatenated. For example, if `words = ["ab", "cd", "ef"]`, then
 * `"abcdef"`, `"abefcd"`, `"cdabef"`, `"cdefab"`, `"efabcd"`, and `"efcdab"` are concatenated
 * strings. `"acdbef"` is not a concatenated string because it is not the concatenation of any
 * permutation of `words`.
 *
 * Return an array of the starting indices of all the concatenated substrings in `s`. You can return
 * the answer in any order.
 *
 * Examples:
 * - Input: `s = "barfoothefoobarman"`, `words = ["foo", "bar"]`. Output: `[0, 9]`.
 *   Explanation: The substring starting at 0 is `"barfoo"`, a concatenation of `["bar", "foo"]`.
 *   The substring starting at 9 is `"foobar"`, a concatenation of `["foo", "bar"]`.
 * - Input: `s = "wordgoodgoodgoodbestword"`, `words = ["word", "good", "best", "word"]`.
 *   Output: `[]`. Explanation: There is no concatenated substring.
 * - Input: `s = "barfoofoobarthefoobarman"`, `words = ["bar", "foo", "the"]`.
 *   Output: `[6, 9, 12]`.
 *   Explanation: The substrings starting at 6, 9, and 12 are respectively `"foobarthe"`,
 *   `"barthefoo"`, and `"thefoobar"`, each a concatenation of all three words in a different
 *   order.
 *
 * Constraints:
 * - `1 <= s.length <= 10^4`.
 * - `1 <= words.length <= 5000`.
 * - `1 <= words[i].length <= 30`.
 * - `s` and `words[i]` consist of lowercase English letters.
 * - All strings in `words` have the same length.
 *
 * [LeetCode 30: Substring with Concatenation of All Words](https://leetcode.com/problems/substring-with-concatenation-of-all-words/)
 */
class Solution {
    fun findSubstring(s: String, words: Array<String>): List<Int> {
        TODO("Implement solution")
    }
}