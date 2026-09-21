package leetcode.p0238

/**
 * # 238. Product of Array Except Self
 *
 * Given an integer array `nums`, return an array `answer` such that `answer[i]` is equal to the
 * product of all the elements of `nums` except `nums[i]`.
 *
 * The product of any prefix or suffix of `nums` is guaranteed to fit in a **32-bit** integer.
 *
 * You must write an algorithm that runs in `O(n)` time and without using the division operation.
 *
 * Examples:
 * - Input: `nums = [1,2,3,4]`. Output: `[24,12,8,6]`.
 * - Input: `nums = [-1,1,0,-3,3]`. Output: `[0,0,9,0,0]`.
 *
 * Constraints:
 * - `2 <= nums.length <= 10^5`
 * - `-30 <= nums[i] <= 30`
 * - The product of any prefix or suffix of `nums` is **guaranteed** to fit in a **32-bit** integer.
 *
 * Follow-up: Can you solve the problem in `O(1)` extra space complexity? (The output array **does not**
 * count as extra space for space complexity analysis.)
 *
 * [LeetCode 238: Product of Array Except Self](https://leetcode.com/problems/product-of-array-except-self/)
 */
class Solution {
    fun productExceptSelf(nums: IntArray): IntArray {
        val output = IntArray(nums.size)

        var product = 1
        for (i in nums.indices) {
            output[i] = product
            product *= nums[i]
        }

        product = 1
        for (i in nums.lastIndex downTo 0) {
            output[i] *= product
            product *= nums[i]
        }
        return  output
    }
}
