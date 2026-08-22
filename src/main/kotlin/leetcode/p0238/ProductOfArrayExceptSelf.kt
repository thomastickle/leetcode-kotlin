package leetcode.p0238

/**
 * # 238. Product of Array Except Self
 *
 * Given an integer array `nums`, return an array `answer` where `answer[i]` is the product of
 * every value in `nums` except `nums[i]`. The algorithm must run in `O(n)` time without using
 * division. Every prefix product and suffix product is guaranteed to fit in a 32-bit integer.
 *
 * Examples:
 * - `nums = [1, 2, 3, 4]` returns `[24, 12, 8, 6]`.
 * - `nums = [-1, 1, 0, -3, 3]` returns `[0, 0, 9, 0, 0]`.
 *
 * Constraints:
 * - `2 <= nums.length <= 10^5`
 * - `-30 <= nums[i] <= 30`
 * - Every `answer[i]` fits in a 32-bit integer.
 *
 * Follow-up: Use `O(1)` additional space, excluding the returned output array from the space
 * calculation.
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
        for (i in nums.indices.reversed()) {
            output[i] *= product
            product *= nums[i]
        }
        return output
    }
}
