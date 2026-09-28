package leetcode.p0209

/**
 * # 209. Minimum Size Subarray Sum
 *
 * Given an array of positive integers `nums` and a positive integer `target`, return the minimal
 * length of a subarray whose sum is greater than or equal to `target`. If there is no such subarray,
 * return `0` instead.
 *
 * A subarray is a contiguous non-empty sequence of elements within an array.
 *
 * Examples:
 * - Input: `target = 7`, `nums = [2, 3, 1, 2, 4, 3]`. Output: `2`.
 *   Explanation: The subarray `[4, 3]` has the minimal length while its sum is 7.
 * - Input: `target = 4`, `nums = [1, 4, 4]`. Output: `1`.
 *   Explanation: The subarray `[4]` has the minimal length while its sum is 4.
 * - Input: `target = 11`, `nums = [1, 1, 1, 1, 1, 1, 1, 1]`. Output: `0`.
 *   Explanation: No subarray has a sum greater than or equal to 11.
 *
 * Constraints:
 * - `1 <= target <= 10^9`.
 * - `1 <= nums.length <= 10^5`.
 * - `1 <= nums[i] <= 10^4`.
 *
 * Follow-up: If you have figured out the `O(n)` solution, try coding another solution of which the
 * time complexity is `O(n log(n))`.
 *
 * [LeetCode 209: Minimum Size Subarray Sum](https://leetcode.com/problems/minimum-size-subarray-sum/)
 */
class Solution {
    fun minSubArrayLen(target: Int, nums: IntArray): Int {
        var left = 0
        var right = 0
        var currentSum = 0
        var smallest = Int.MAX_VALUE

        while (right < nums.size) {
            currentSum += nums[right++]

            while (currentSum >= target) {
                smallest = minOf(smallest, right - left)
                currentSum -= nums[left++]
            }
        }

        return if (smallest == Int.MAX_VALUE) 0 else smallest
    }
}
