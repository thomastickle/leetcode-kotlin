package leetcode.p0746
/**
 * # 746. Min Cost Climbing Stairs
 *
 * You are given an integer array `cost`, where `cost[i]` is the cost of stepping on the ith
 * stair of a staircase. After paying the cost for a stair, you may climb either one or two
 * steps. You may begin on the stair with index `0` or the stair with index `1`. Return the
 * minimum cost required to reach the top of the staircase.
 *
 * Examples:
 * - Input: `cost = [10, 15, 20]`. Output: `15`. Explanation: Start at index `1`, pay `15`, and
 *   climb two steps to reach the top. The total cost is `15`.
 * - Input: `cost = [1, 100, 1, 1, 1, 100, 1, 1, 100, 1]`. Output: `6`. Explanation: Start at
 *   index `0` and pay `1`, then climb two steps at a time until reaching the top. The total cost
 *   is `6`.
 *
 * Constraints:
 * - `2 <= cost.length <= 1000`.
 * - `0 <= cost[i] <= 999`.
 *
 * Follow-up: Can you solve the problem in `O(n)` time and `O(1)` extra space?
 *
 * [LeetCode 746: Min Cost Climbing Stairs](https://leetcode.com/problems/min-cost-climbing-stairs/)
 */
class Solution {
    fun minCostClimbingStairs(cost: IntArray): Int {
        tailrec fun minClimbCost(index: Int, oneBack: Int, twoBack: Int): Int {
            if (index == cost.size) {
                return minOf(oneBack, twoBack)
            }
            val next = minOf(oneBack, twoBack)
            return minClimbCost(index+1, cost[index] + next, oneBack)
        }
        return minClimbCost(2, cost[1], cost[0])

//        var oneBack = cost[1]
//        var twoBack = cost[0]
//        for (i in 2 until cost.size) {
//            val next = cost[i] + minOf(oneBack, twoBack)
//            twoBack = oneBack
//            oneBack = next
//        }
//        return minOf(oneBack, twoBack)
    }
}
