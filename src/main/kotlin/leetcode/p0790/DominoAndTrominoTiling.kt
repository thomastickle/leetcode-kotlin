package leetcode.p0790

import kotlin.math.pow

/**
 * # 790. Domino and Tromino Tiling
 *
 * You have two types of tiles: a `2 x 1` domino and a tromino. Both shapes may be rotated. A
 * tromino covers three squares in an L shape.
 *
 * Given an integer `n`, return the number of ways to tile a `2 x n` board. Every square must be
 * covered by exactly one tile. Two tilings are different if and only if there are two
 * four-directionally adjacent cells on the board such that exactly one of the tilings has both
 * squares occupied by the same tile. Since the answer may be very large, return it modulo
 * `10^9 + 7`.
 *
 * Examples:
 * - Input: `n = 3`. Output: `5`. The five different tilings are shown in the problem statement.
 * - Input: `n = 1`. Output: `1`.
 *
 * Constraints:
 * - `1 <= n <= 1000`.
 *
 * [LeetCode 790: Domino and Tromino Tiling](https://leetcode.com/problems/domino-and-tromino-tiling/)
 */
class Solution {
    companion object {
        private const val MOD = 1_000_000_007L
    }

    fun numTilings(n: Int): Int {
        if (n < 3) return n

        val tracker = longArrayOf(1, 2, 5)
        repeat(n - 3) {
            val temp = tracker[0]
            tracker[0] = tracker[1]
            tracker[1] = tracker[2]
            tracker[2] = (tracker[2] * 2 + temp) % MOD
        }
        return tracker[2].toInt()
    }
}