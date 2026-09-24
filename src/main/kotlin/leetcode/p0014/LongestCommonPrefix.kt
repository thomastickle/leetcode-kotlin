package leetcode.p0014

/**
 * # 14. Longest Common Prefix
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 *
 * If there is no common prefix, return an empty string `""`.
 *
 * Examples:
 * - Input: `strs = ["flower","flow","flight"]`. Output: `"fl"`.
 * - Input: `strs = ["dog","racecar","car"]`. Output: `""`.
 *   Explanation: There is no common prefix among the input strings.
 *
 * Constraints:
 * - `1 <= strs.length <= 200`
 * - `0 <= strs[i].length <= 200`
 * - `strs[i]` consists of only lowercase English letters.
 *
 * [LeetCode 14: Longest Common Prefix](https://leetcode.com/problems/longest-common-prefix/)
 */
class Solution {

    fun longestCommonPrefix(strs: Array<String>): String {
        var shortestLength = strs[0].length

        for (word in strs) {
            shortestLength = minOf(shortestLength, word.length)
        }

        val first = strs[0]

        for (i in 0..<shortestLength) {
            val current = first[i]

            for (j in 1..<strs.size) {
                if (strs[j][i] != current) {
                    return first.substring(0, i)
                }
            }
        }

        return first.substring(0, shortestLength)
    }
}
