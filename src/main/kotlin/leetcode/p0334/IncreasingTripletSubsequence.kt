package leetcode.p0334

/**
 * # 334. Increasing Triplet Subsequence
 *
 * Given an integer array `nums`, return `true` when there are indices `i < j < k` such that
 * `nums[i] < nums[j] < nums[k]`. Return `false` when no such triplet exists.
 *
 * Examples:
 * - `nums = [1, 2, 3, 4, 5]` returns `true`; many increasing index triplets are valid.
 * - `nums = [5, 4, 3, 2, 1]` returns `false` because no increasing triplet exists.
 * - `nums = [2, 1, 5, 0, 4, 6]` returns `true`; indices `(1, 4, 5)` select `1 < 4 < 6`.
 *
 * Constraints:
 * - `1 <= nums.length <= 5 * 10^5`
 * - `-2^31 <= nums[i] <= 2^31 - 1`
 *
 * Follow-up: Implement the check in `O(n)` time with `O(1)` additional space.
 *
 * [LeetCode 334: Increasing Triplet Subsequence](https://leetcode.com/problems/increasing-triplet-subsequence/)
 */
class Solution {
  fun increasingTriplet(nums: IntArray): Boolean {
    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE

    for (num in nums) {
      if (num <= first) {
        first = num
      } else if (num <= second) {
        second = num
      } else {
        return true
      }
    }
    return false
  }
}
