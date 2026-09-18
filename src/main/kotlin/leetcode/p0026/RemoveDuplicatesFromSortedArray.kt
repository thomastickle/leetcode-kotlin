package leetcode.p0026

/**
 * # 26. Remove Duplicates from Sorted Array
 *
 * Given an integer array `nums` sorted in non-decreasing order, remove the duplicates in place so
 * that each distinct element appears only once. Preserve the relative order of the unique
 * elements. Return `k`, the number of unique elements in `nums`.
 *
 * To be accepted, modify `nums` so that its first `k` elements contain the unique elements in
 * their original sorted order. The elements after the first `k` positions are not important.
 * The custom judge compares the returned `k` with the expected number and then compares the first
 * `k` elements of `nums` with the expected unique values.
 *
 * Examples:
 * - `nums = [1,1,2]` returns `k = 2`, with the first two elements of `nums` being `[1,2]`. Values
 *   after the first two positions are not important.
 * - `nums = [0,0,1,1,1,2,2,3,3,4]` returns `k = 5`, with the first five elements of `nums` being
 *   `[0,1,2,3,4]`. Values after the first five positions are not important.
 *
 * Constraints:
 * - `1 <= nums.length <= 3 * 10^4`
 * - `-100 <= nums[i] <= 100`
 * - `nums` is sorted in non-decreasing order.
 *
 * [LeetCode 26: Remove Duplicates from Sorted Array](https://leetcode.com/problems/remove-duplicates-from-sorted-array/)
 */
class Solution {
    fun removeDuplicates(nums: IntArray): Int {
        var lastUniqueIndex = 0

        for (readIndex in 1 until nums.size) {
            if (nums[lastUniqueIndex] != nums[readIndex]){
                lastUniqueIndex++
                nums[lastUniqueIndex] = nums[readIndex]
            }
        }

        return lastUniqueIndex + 1
    }
}
