package leetcode.p1493

/**
 * # 1493. Longest Subarray of 1's After Deleting One Element
 *
 * Given a binary array `nums`, you should delete one element from it.
 *
 * Return the size of the longest non-empty subarray containing only `1`'s in the resulting array.
 * Return `0` if there is no such subarray.
 *
 * Examples:
 * - Input: `nums = [1, 1, 0, 1]`. Output: `3`. After deleting the number in position `2`, `[1, 1, 1]`
 *   contains `3` numbers with value of `1`'s.
 * - Input: `nums = [0, 1, 1, 1, 0, 1, 1, 0, 1]`. Output: `5`. After deleting the number in position `4`,
 *   `[0, 1, 1, 1, 1, 1, 0, 1]` results in optimal longest subarray of length `5` containing `1`'s.
 * - Input: `nums = [1, 1, 1]`. Output: `2`. You must delete one element.
 *
 * Constraints:
 * - `1 <= nums.length <= 10^5`
 * - `nums[i]` is either `0` or `1`.
 *
 * [LeetCode 1493: Longest Subarray of 1's After Deleting One Element](https://leetcode.com/problems/longest-subarray-of-1s-after-deleting-one-element/)
 */
class Solution {
    fun longestSubarray(nums: IntArray): Int {
        var longest = 0
        var left = 0
        var zeroCount = 0

        for (right in nums.indices) {
            if (nums[right] == 0) {
                zeroCount++
            }

            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--
                }
                left++
            }

            longest = maxOf(longest, right - left)
        }

        return longest
    }
}
