package leetcode.p0088

/**
 * # 88. Merge Sorted Array
 *
 * Given two integer arrays `nums1` and `nums2`, both sorted in non-decreasing order, merge
 * `nums2` into `nums1` as one sorted array in non-decreasing order.
 *
 * The number of elements initialized in `nums1` and `nums2` is `m` and `n`, respectively. The
 * first `m` elements of `nums1` are the values that should be merged, and `nums1` has a length of
 * `m + n` so it has enough space to hold the result. The extra elements at the end of `nums1` are
 * represented by zeroes and should not be considered part of its values. `nums2` has exactly `n`
 * elements.
 *
 * Merge the arrays by modifying `nums1` in place. Do not return the merged array.
 *
 * Examples:
 * - `nums1 = [1,2,3,0,0,0]`, `m = 3`, `nums2 = [2,5,6]`, `n = 3` becomes
 *   `[1,2,2,3,5,6]`. The arrays being merged are `[1,2,3]` and `[2,5,6]`.
 * - `nums1 = [1]`, `m = 1`, `nums2 = []`, `n = 0` remains `[1]`.
 * - `nums1 = [0]`, `m = 0`, `nums2 = [1]`, `n = 1` becomes `[1]`.
 *
 * Constraints:
 * - `nums1.length == m + n`
 * - `nums2.length == n`
 * - `0 <= m, n <= 200`
 * - `1 <= m + n <= 200`
 * - `-10^9 <= nums1[i], nums2[j] <= 10^9`
 * - `nums1` and `nums2` are sorted in non-decreasing order.
 *
 * Follow-up: Can you devise an algorithm that runs in `O(m + n)` time?
 *
 * [LeetCode 88: Merge Sorted Array](https://leetcode.com/problems/merge-sorted-array/)
 */
class Solution {
    fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
        var nums1Index = m - 1
        var nums2Index = n - 1
        var writeIndex = nums1.size - 1

        while (nums2Index >= 0) {
            if (nums1Index >= 0 && nums1[nums1Index] > nums2[nums2Index]) {
                nums1[writeIndex--] = nums1[nums1Index--]
            } else {
                nums1[writeIndex--] = nums2[nums2Index--]
            }
        }
    }
}
