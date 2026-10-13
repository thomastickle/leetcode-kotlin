package leetcode.p0219

import kotlin.math.abs

/**
 * # 219. Contains Duplicate II
 *
 * Given an integer array `nums` and an integer `k`, return `true` if there are two distinct indices
 * `i` and `j` in the array such that `nums[i] == nums[j]` and `abs(i - j) <= k`.
 * Otherwise, return `false`.
 *
 * Examples:
 * - Input: `nums = [1,2,3,1]`, `k = 3`. Output: `true`.
 * - Input: `nums = [1,0,1,1]`, `k = 1`. Output: `true`.
 * - Input: `nums = [1,2,3,1,2,3]`, `k = 2`. Output: `false`.
 *
 * Constraints:
 * - `1 <= nums.length <= 10^5`.
 * - `-10^9 <= nums[i] <= 10^9`.
 * - `0 <= k <= 10^5`.
 *
 * [LeetCode 219: Contains Duplicate II](https://leetcode.com/problems/contains-duplicate-ii/)
 */
class Solution {
    fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
        val lastSeenIndexByValue = HashMap<Int, Int>()

        for (index in nums.indices) {
            val value = nums[index]
            val previousIndex = lastSeenIndexByValue.put(value, index)

            if (previousIndex != null && index - previousIndex <= k) {
                return true
            }
        }

        return false
    }
}
