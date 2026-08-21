package leetcode.p0238

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
