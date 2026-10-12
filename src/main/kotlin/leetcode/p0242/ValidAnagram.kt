package leetcode.p0242

/**
 * # 242. Valid Anagram
 *
 * Given two strings `s` and `t`, return `true` if `t` is an anagram of `s`, and `false` otherwise.
 * An anagram is formed by rearranging the letters of another string, using the same letters with
 * the same frequencies.
 *
 * Examples:
 * - Input: `s = "anagram"`, `t = "nagaram"`. Output: `true`.
 * - Input: `s = "rat"`, `t = "car"`. Output: `false`.
 *
 * Constraints:
 * - `1 <= s.length, t.length <= 5 * 10^4`
 * - `s` and `t` consist of lowercase English letters.
 *
 * Follow-up: What if the inputs contain Unicode characters? How would you adapt your solution to
 * such a case?
 *
 * [LeetCode 242: Valid Anagram](https://leetcode.com/problems/valid-anagram/)
 */
class Solution {
    fun isAnagram(s: String, t: String): Boolean {
        if ( s.length != t.length) return false

        val frequencyCounter = IntArray(26)
        for (char in s) {
            frequencyCounter[char - 'a']++
        }

        for (char in t) {
            if (--frequencyCounter[char - 'a'] < 0) {
                return false
            }
        }
        return true
    }
}
