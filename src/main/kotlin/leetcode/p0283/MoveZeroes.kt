package leetcode.p0283

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
