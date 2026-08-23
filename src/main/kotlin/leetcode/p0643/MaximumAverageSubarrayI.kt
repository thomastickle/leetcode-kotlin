package leetcode.p0643

/**
 * # 643. Maximum Average Subarray I
 *
 * Given an integer array `nums` containing `n` elements and an integer `k`, find a contiguous
 * subarray whose length is exactly `k` and whose average value is as large as possible. Return
 * that maximum average. Any answer with a calculation error smaller than `10^-5` is accepted.
 *
 * Examples:
 * - Input: `nums = [1, 12, -5, -6, 50, 3]`, `k = 4`. Output: `12.75000`. The maximum average
 *   is `(12 - 5 - 6 + 50) / 4 = 51 / 4 = 12.75`.
 * - Input: `nums = [5]`, `k = 1`. Output: `5.00000`.
 *
 * Constraints:
 * - `n == nums.length`
 * - `1 <= k <= n <= 10^5`
 * - `-10^4 <= nums[i] <= 10^4`
 *
 * [LeetCode 643: Maximum Average Subarray I](https://leetcode.com/problems/maximum-average-subarray-i/)
 */
class Solution {
    fun findMaxAverage(nums: IntArray, k: Int): Double {
        var rollingSum = 0

        for (index in 0 until k) {
            rollingSum += nums[index]
        }

        var maxSum = rollingSum

        for (index in k until nums.size) {
            rollingSum += nums[index] - nums[index - k]
            maxSum = maxOf(maxSum, rollingSum)
        }

        return maxSum.toDouble() / k
    }
}
