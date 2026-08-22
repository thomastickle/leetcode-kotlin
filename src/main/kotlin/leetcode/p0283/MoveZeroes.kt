package leetcode.p0283

/**
 * # 283. Move Zeroes
 *
 * Given an integer array `nums`, move every zero to the end while preserving the relative order
 * of all non-zero values. Modify `nums` in place without copying the array.
 *
 * Examples:
 * - `nums = [0, 1, 0, 3, 12]` becomes `[1, 3, 12, 0, 0]`.
 * - `nums = [0]` remains `[0]`.
 *
 * Constraints:
 * - `1 <= nums.length <= 10^4`
 * - `-2^31 <= nums[i] <= 2^31 - 1`
 *
 * Follow-up: Minimize the total number of array operations.
 *
 * [LeetCode 283: Move Zeroes](https://leetcode.com/problems/move-zeroes/)
 */
class Solution {
    fun moveZeroes(nums: IntArray) {
        var i = 0
        var j = 0

        while (j < nums.size) {
            if (nums[j] != 0) {
                val temp = nums[i]
                nums[i] = nums[j]
                nums[j] = temp
                i++
            }

            j++
        }
    }
}
