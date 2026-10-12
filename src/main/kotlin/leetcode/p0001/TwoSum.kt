package leetcode.p0001

/**
 * # 1. Two Sum
 *
 * Given an array of integers `nums` and an integer `target`, return the indices of the two numbers
 * whose sum is `target`. Each input has exactly one solution, and you may not use the same element
 * twice. Return the indices in any order.
 *
 * Examples:
 * - Input: `nums = [2, 7, 11, 15]`, `target = 9`. Output: `[0, 1]`.
 *   `nums[0] + nums[1]` equals `9`.
 * - Input: `nums = [3, 2, 4]`, `target = 6`. Output: `[1, 2]`.
 * - Input: `nums = [3, 3]`, `target = 6`. Output: `[0, 1]`.
 *
 * Constraints:
 * - `2 <= nums.length <= 10^4`.
 * - `-10^9 <= nums[i] <= 10^9`.
 * - `-10^9 <= target <= 10^9`.
 * - The input has exactly one valid answer.
 * - The same element may not be used twice.
 *
 * Follow-up: Can you come up with an algorithm that is less than `O(n^2)` time complexity?
 *
 * [LeetCode 1: Two Sum](https://leetcode.com/problems/two-sum/)
 */
class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {
        val compliments = HashMap<Int, Int>()
        for (index in 0 until nums.size) {
            val num = nums[index]
            val compliment = target - num
            val complimentIndex = compliments[num]
            if (complimentIndex != null) {
                return intArrayOf(complimentIndex, index)
            } else {
                compliments[compliment] = index
            }
        }
        return intArrayOf()
    }
}
