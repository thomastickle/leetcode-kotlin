package leetcode.p1679

/**
 * # 1679. Max Number of K-Sum Pairs
 *
 * Given an integer array `nums` and an integer `k`, perform operations that each choose two
 * numbers whose sum is exactly `k` and remove both numbers from the array. Return the maximum
 * number of operations that can be performed.
 *
 * Examples:
 * - Input: `nums = [1, 2, 3, 4]`, `k = 5`. Output: `2`. Remove `1` and `4`, leaving
 *   `[2, 3]`; then remove `2` and `3`, leaving an empty array. No further pair sums to `5`.
 * - Input: `nums = [3, 1, 3, 4, 3]`, `k = 6`. Output: `1`. Remove two of the `3`s, leaving
 *   `[1, 4, 3]`. No remaining pair sums to `6`.
 *
 * Constraints:
 * - `1 <= nums.length <= 10^5`
 * - `1 <= nums[i] <= 10^9`
 * - `1 <= k <= 10^9`
 *
 * [LeetCode 1679: Max Number of K-Sum Pairs](https://leetcode.com/problems/max-number-of-k-sum-pairs/)
 */
class Solution {
    fun maxOperations(nums: IntArray, k: Int): Int {
        nums.sort()
        var low = 0
        var high = nums.lastIndex
        var count = 0
        while (low < high) {
            val sums = nums[low] + nums[high]
            if (sums == k) {
                count++
                low++
                high--
            } else if (sums > k) {
                high--
            } else {
                low++
            }
        }
        return count
    }
}
