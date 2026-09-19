package leetcode.p0169

/**
 * # 169. Majority Element
 *
 * Given an integer array `nums` of size `n`, return the majority element.
 *
 * The majority element is the value that appears more than `floor(n / 2)` times. You may assume
 * that a majority element always exists in the array.
 *
 * Examples:
 * - Input: `nums = [3,2,3]`. Output: `3`.
 * - Input: `nums = [2,2,1,1,1,2,2]`. Output: `2`.
 *
 * Constraints:
 * - `n == nums.length`.
 * - `1 <= n <= 5 * 10^4`.
 * - `-10^9 <= nums[i] <= 10^9`.
 * - The input is generated so that a majority element exists in the array.
 *
 * Follow-up: Can you solve the problem in linear time and `O(1)` space?
 *
 * [LeetCode 169: Majority Element](https://leetcode.com/problems/majority-element/)
 */
class Solution {
    fun majorityElement(nums: IntArray): Int {
        var currentValue = 0
        var currentValueCount = 0

        for (num in nums) {
            if (currentValueCount == 0) {
                currentValue = num
            }
            if (currentValue == num) {
                currentValueCount += 1
            } else {
                currentValueCount -= 1
            }
        }
        return currentValue
    }
}
