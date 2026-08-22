package leetcode.p1431

/**
 * # 1431. Kids With the Greatest Number of Candies
 *
 * There are `n` children, and `candies[i]` is the candy count of child `i`. For each child,
 * determine whether giving that child all `extraCandies` would make their total at least as large
 * as every other child's total. Return those results as a Boolean array of length `n`. More than
 * one child may tie for the greatest total.
 *
 * Examples:
 * - `candies = [2, 3, 5, 1, 3]`, `extraCandies = 3` returns
 *   `[true, true, true, false, true]`; the possible totals are `5, 6, 8, 4, 6` versus a current
 *   maximum of `5`.
 * - `candies = [4, 2, 1, 1, 2]`, `extraCandies = 1` returns
 *   `[true, false, false, false, false]`; only the first child can reach the greatest total.
 * - `candies = [12, 1, 12]`, `extraCandies = 10` returns `[true, false, true]`.
 *
 * Constraints:
 * - `n == candies.length`
 * - `2 <= n <= 100`
 * - `1 <= candies[i] <= 100`
 * - `1 <= extraCandies <= 50`
 *
 * [LeetCode 1431: Kids With the Greatest Number of Candies](https://leetcode.com/problems/kids-with-the-greatest-number-of-candies/)
 */
class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val largest = candies.max();
        return candies.map { it + extraCandies >= largest }
    }
}
