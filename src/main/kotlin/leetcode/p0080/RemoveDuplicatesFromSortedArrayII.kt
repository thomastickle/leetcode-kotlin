package leetcode.p0080

/**
 * # 80. Remove Duplicates from Sorted Array II
 *
 * Given an integer array `nums` sorted in non-decreasing order, remove some duplicates in place so
 * that each unique element appears at most twice. Preserve the relative order of the elements.
 *
 * Because the array length cannot be changed in some languages, place the result in the first part
 * of `nums`. If `k` elements remain after removing duplicates, the first `k` elements of `nums`
 * must contain the final result. Return `k` after placing the result in those first `k` positions.
 *
 * Do not allocate another array. Modify the input array in place using `O(1)` extra memory.
 * The custom judge checks that the returned `k` equals the expected result length and that each of
 * the first `k` elements of `nums` equals the corresponding expected value. Values beyond `k` are
 * not important.
 *
 * Examples:
 * - `nums = [1,1,1,2,2,3]` returns `k = 5`, with the first five elements of `nums` being
 *   `[1,1,2,2,3]`. The value after the first five positions is not important.
 * - `nums = [0,0,1,1,1,1,2,3,3]` returns `k = 7`, with the first seven elements of `nums` being
 *   `[0,0,1,1,2,3,3]`. The values after the first seven positions are not important.
 *
 * Constraints:
 * - `1 <= nums.length <= 3 * 10^4`
 * - `-10^4 <= nums[i] <= 10^4`
 * - `nums` is sorted in non-decreasing order.
 *
 * [LeetCode 80: Remove Duplicates from Sorted Array II](https://leetcode.com/problems/remove-duplicates-from-sorted-array-ii/)
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        if (nums.size < 3) return nums.size

        var writeIndex = 2

        for (readPointer in 2 until nums.size) {
            if (nums[readPointer] != nums[writeIndex - 2]) {
                nums[writeIndex++] = nums[readPointer]
            }
        }

        return writeIndex
    }
}
