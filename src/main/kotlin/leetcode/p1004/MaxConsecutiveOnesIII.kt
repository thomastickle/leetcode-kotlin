package leetcode.p1004

/**
 * # 1004. Max Consecutive Ones III
 *
 * Given a binary array `nums` and an integer `k`, return the maximum number of consecutive `1`s
 * in the array if you can flip at most `k` `0`s.
 *
 * Examples:
 * - Input: `nums = [1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0]`, `k = 2`. Output: `6`. Flipping the
 *   `0`s at indices `5` and `10` produces the longest run of six consecutive `1`s.
 * - Input: `nums = [0, 0, 1, 1, 1, 0, 0]`, `k = 0`. Output: `3`. No `0`s may be flipped, so
 *   the longest existing run of consecutive `1`s has length three.
 *
 * Constraints:
 * - `1 <= nums.length <= 10^5`
 * - `nums[i]` is either `0` or `1`.
 * - `0 <= k <= nums.length`
 *
 * [LeetCode 1004: Max Consecutive Ones III](https://leetcode.com/problems/max-consecutive-ones-iii/)
 */
class Solution {
    fun longestOnes(nums: IntArray, k: Int): Int {
        var maxRun = 0
        var right = 0
        var left = 0
        var zeroCount = 0

        while (right < nums.size) {
            if (nums[right] == 0) {
                zeroCount++
            }

            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--
                }
                left++
            }

            maxRun = maxOf(maxRun, right - left + 1)

            right++
        }

        return maxRun
    }
}