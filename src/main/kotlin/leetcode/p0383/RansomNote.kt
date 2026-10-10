package leetcode.p0383

/**
 * # 383. Ransom Note
 *
 * Given strings `ransomNote` and `magazine`, return `true` if `ransomNote` can be constructed
 * using letters from `magazine`; otherwise, return `false`. Each letter in `magazine` can be
 * used only once.
 *
 * Examples:
 * - Input: `ransomNote = "a"`, `magazine = "b"`. Output: `false`.
 * - Input: `ransomNote = "aa"`, `magazine = "ab"`. Output: `false`.
 * - Input: `ransomNote = "aa"`, `magazine = "aab"`. Output: `true`.
 *
 * Constraints:
 * - `1 <= ransomNote.length, magazine.length <= 10^5`
 * - `ransomNote` and `magazine` consist of lowercase English letters.
 *
 * [LeetCode 383: Ransom Note](https://leetcode.com/problems/ransom-note/)
 */
class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        if (ransomNote.length > magazine.length) return false
        val frequencyMap = IntArray(128)
        for (char in magazine) {
            frequencyMap[char.code]++
        }

        for (char in ransomNote) {
            frequencyMap[char.code]--
            if (frequencyMap[char.code] < 0) {
               return false
            }
        }

        return true
    }
}
