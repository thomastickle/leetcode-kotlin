package leetcode.p0747

/**
 * # 747. Largest Number At Least Twice of Others
 *
 * You are given an integer array `nums` in which the largest integer is unique. Determine whether
 * the largest element is at least twice as much as every other number in the array. If it is,
 * return the index of the largest element; otherwise, return `-1`.
 *
 * Examples:
 * - Input: `nums = [3, 6, 1, 0]`. Output: `1`. Explanation: The largest element is `6`, and
 *   `6` is at least twice every other number in the array. Its index is `1`.
 * - Input: `nums = [1, 2, 3, 4]`. Output: `-1`. Explanation: The largest element is `4`, but
 *   `4` is not at least twice the other values, including `3`.
 *
 * Constraints:
 * - `2 <= nums.length <= 50`.
 * - `0 <= nums[i] <= 100`.
 * - The largest element in `nums` is unique.
 *
 * Follow-up: Could you solve it without sorting the array?
 *
 * [LeetCode 747: Largest Number At Least Twice of Others](https://leetcode.com/problems/largest-number-at-least-twice-of-others/)
 */
class Solution {
    fun dominantIndex(nums: IntArray): Int {
        var largestIdx: Int
        var secondIdx: Int

        if (nums[0] > nums[1]) {
            largestIdx = 0
            secondIdx = 1
        } else {
            largestIdx = 1
            secondIdx = 0
        }

        for (i in 2 until nums.size) {
            if (nums[i] > nums[largestIdx]) {
                secondIdx = largestIdx
                largestIdx = i
            } else if (nums[i] > nums[secondIdx]) {
                secondIdx = i
            }
        }

        return if (nums[largestIdx] >= nums[secondIdx] * 2) largestIdx else -1
    }
}
