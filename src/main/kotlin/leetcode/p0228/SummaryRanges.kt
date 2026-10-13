package leetcode.p0228

/**
 * # 228. Summary Ranges
 *
 * You are given a sorted integer array `nums` with no duplicate values. A range `[a,b]` is the
 * set of all integers from `a` through `b`, inclusive.
 *
 * Return the smallest sorted list of ranges that covers every number in `nums` exactly. Every
 * value in `nums` must be included in exactly one range, and no integer may be included in a range
 * unless it is present in `nums`.
 *
 * Format each range `[a,b]` as follows:
 * - If `a != b`, output `"a->b"`.
 * - If `a == b`, output `"a"`.
 *
 * Examples:
 * - Input: `nums = [0,1,2,4,5,7]`. Output: `["0->2","4->5","7"]`.
 *   Explanation: `0,1,2` form one consecutive range, `4,5` form another, and `7` is alone.
 * - Input: `nums = [0,2,3,4,6,8,9]`. Output: `["0","2->4","6","8->9"]`.
 *   Explanation: `0` is alone, `2,3,4` form one consecutive range, `6` is alone, and `8,9`
 *   form another consecutive range.
 *
 * Constraints:
 * - `0 <= nums.length <= 20`.
 * - `-2^31 <= nums[i] <= 2^31 - 1`.
 * - All values in `nums` are unique.
 * - `nums` is sorted in ascending order.
 *
 * [LeetCode 228: Summary Ranges](https://leetcode.com/problems/summary-ranges/)
 */
class Solution {
    fun summaryRanges(nums: IntArray): List<String> {
        TODO("Implement solution")
    }
}
