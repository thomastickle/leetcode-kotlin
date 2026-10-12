package leetcode.p0049

/**
 * # 49. Group Anagrams
 *
 * Given an array of strings `strs`, group the anagrams together. An anagram is a word or phrase
 * formed by rearranging the letters of another word or phrase, typically using all the original
 * letters exactly once. The groups may be returned in any order.
 *
 * Examples:
 * - Input: `strs = ["eat", "tea", "tan", "ate", "nat", "bat"]`.
 *   Output: `[["bat"], ["nat", "tan"], ["ate", "eat", "tea"]]`.
 * - Input: `strs = [""]`. Output: `[[""]]`.
 * - Input: `strs = ["a"]`. Output: `[["a"]]`.
 *
 * Constraints:
 * - `1 <= strs.length <= 10^4`
 * - `0 <= strs[i].length <= 100`
 * - `strs[i]` consists of lowercase English letters.
 *
 * [LeetCode 49: Group Anagrams](https://leetcode.com/problems/group-anagrams/)
 */
class Solution {
    fun groupAnagrams(strs: Array<String>): List<List<String>> {
        val wordMap = HashMap<String, MutableList<String>>()
        for (word in strs) {
            val frequencies = CharArray(26)
            for (char in word) {
                frequencies[char - 'a']++
            }
            val key = String(frequencies)
            wordMap.getOrPut(key) {mutableListOf()}.add(word)
        }

        val output = ArrayList<List<String>>(wordMap.size)
        for ( value in wordMap.values) {
            output.add(value)
        }
        return output
    }
}
