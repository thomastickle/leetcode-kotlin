package leetcode.p0028

/**
 * # 28. Find the Index of the First Occurrence in a String
 *
 * Given two strings `needle` and `haystack`, return the zero-based index of the first occurrence
 * of `needle` in `haystack`, or `-1` if `needle` is not part of `haystack`.
 *
 * Examples:
 * - Input: `haystack = "sadbutsad"`, `needle = "sad"`. Output: `0`.
 *   Explanation: `"sad"` occurs at indices 0 and 6; the first occurrence is at index 0.
 * - Input: `haystack = "leetcode"`, `needle = "leeto"`. Output: `-1`.
 *   Explanation: `"leeto"` does not occur in `"leetcode"`.
 *
 * Constraints:
 * - `1 <= haystack.length, needle.length <= 10^4`
 * - `haystack` and `needle` consist of only lowercase English characters.
 *
 * [LeetCode 28: Find the Index of the First Occurrence in a String](https://leetcode.com/problems/find-the-index-of-the-first-occurrence-in-a-string/)
 */
class Solution {
    fun strStr(haystack: String, needle: String): Int {
        /**
         * Construct the longest prefix suffix array needed by the KMP algorithm.
         */
        fun buildLPSArray(string: String): IntArray {
            val longestPrefixSuffix = IntArray(string.length)
            var prefixLength = 0
            for (prefixArrayIndex in 1 until string.length) {
                while (prefixLength > 0 && string[prefixArrayIndex] != string[prefixLength]) {
                    prefixLength = longestPrefixSuffix[prefixLength - 1]
                }
                if (string[prefixArrayIndex] == string[prefixLength]) {
                    prefixLength++
                }
                longestPrefixSuffix[prefixArrayIndex] = prefixLength
            }
            return longestPrefixSuffix
        }

        val lps = buildLPSArray(needle)
        var haystackIndex = 0
        var matchLength = 0
        while (haystackIndex < haystack.length) {
            while (matchLength > 0 && haystack[haystackIndex] != needle[matchLength]) {
                matchLength = lps[matchLength - 1]
            }
            if (haystack[haystackIndex] == needle[matchLength]) {
                matchLength++
            }
            if (matchLength == needle.length) {
                return haystackIndex - matchLength + 1
            }
            haystackIndex++
        }

        return -1
    }

    fun strStrBrute(haystack: String, needle: String): Int {
        val lastStartIndex = haystack.length - needle.length
        var i = 0
        while (i <= lastStartIndex) {
            var needleIndex = 0
            while (needleIndex < needle.length && haystack[i + needleIndex] == needle[needleIndex]) {
                needleIndex++
            }
            if (needleIndex == needle.length) return i

            i++
        }

        return -1
    }
}