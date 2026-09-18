package leetcode.p0027

/**
 * # 27. Remove Element
 *
 * Given an integer array `nums` and an integer `val`, remove every occurrence of `val` from
 * `nums` in place. The order of the remaining elements may be changed. Return `k`, the number of
 * elements in `nums` that are not equal to `val`.
 *
 * To be accepted, modify `nums` so that its first `k` elements contain exactly the elements that
 * are not equal to `val`. The elements after the first `k` positions, and the array's size, are
 * not important. The custom judge sorts the first `k` elements and compares them with the
 * expected values, so any order of the retained elements is valid.
 *
 * Examples:
 * - `nums = [3,2,2,3]`, `val = 3` returns `k = 2`, with the first two elements of `nums` being
 *   `[2,2]`. Values after the first two positions are not important.
 * - `nums = [0,1,2,2,3,0,4,2]`, `val = 2` returns `k = 5`, with the first five elements of `nums`
 *   containing `0`, `0`, `1`, `3`, and `4` in any order. Values after the first five positions
 *   are not important.
 *
 * Constraints:
 * - `0 <= nums.length <= 100`
 * - `0 <= nums[i] <= 50`
 * - `0 <= val <= 100`
 *
 * [LeetCode 27: Remove Element](https://leetcode.com/problems/remove-element/)
 */
class Solution {
    fun removeElement(nums: IntArray, `val`: Int): Int {
        var currentIndex = 0
        var endIndex = nums.lastIndex

        while (currentIndex <= endIndex) {
            if (nums[currentIndex] == `val`) {
                nums[currentIndex] = nums[endIndex--]
            } else {
                currentIndex++
            }
        }

        return currentIndex
    }
}
