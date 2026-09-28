package leetcode.p0003

/**
 * # 3. Longest Substring Without Repeating Characters
 *
 * Given a string `s`, find the length of the longest substring without repeating characters.
 *
 * A substring is a contiguous sequence of characters within a string.
 *
 * Examples:
 * - Input: `s = "abcabcbb"`. Output: `3`.
 *   Explanation: The answer is `"abc"`, with a length of 3. Other valid substrings include
 *   `"bca"` and `"cab"`.
 * - Input: `s = "bbbbb"`. Output: `1`.
 *   Explanation: The answer is `"b"`, with a length of 1.
 * - Input: `s = "pwwkew"`. Output: `3`.
 *   Explanation: The answer is `"wke"`, with a length of 3. Notice that `"pwke"` is a
 *   subsequence, not a substring.
 *
 * Constraints:
 * - `0 <= s.length <= 5 * 10^4`
 * - `s` consists of English letters, digits, symbols, and spaces.
 *
 * [LeetCode 3: Longest Substring Without Repeating Characters](https://leetcode.com/problems/longest-substring-without-repeating-characters/)
 */
class Solution {
    fun lengthOfLongestSubstring(s: String): Int {

        val lastSeen = mutableMapOf<Char, Int>()
        var left = 0
        var right = 0
        var longest = 0

        while (right < s.length) {
            val charFromString = s[right]
            val lastSeenLocation = lastSeen[charFromString]

            if (lastSeenLocation != null && lastSeenLocation >= left) {
                    left = lastSeenLocation + 1
            }

            lastSeen[charFromString] = right++
            longest = maxOf(longest, right - left)
        }


        return longest
    }
}
