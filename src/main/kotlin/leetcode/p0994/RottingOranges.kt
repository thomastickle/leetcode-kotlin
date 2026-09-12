package leetcode.p0994

/**
 * # 994. Rotting Oranges
 *
 * You are given an `m x n` grid where each cell can contain one of three values:
 *
 * - `0` represents an empty cell.
 * - `1` represents a fresh orange.
 * - `2` represents a rotten orange.
 *
 * Every minute, any fresh orange that is 4-directionally adjacent to a rotten orange becomes
 * rotten. Return the minimum number of minutes that must elapse until no cell contains a fresh
 * orange. If it is impossible for all fresh oranges to become rotten, return `-1`.
 *
 * Examples:
 * - Input: `grid = [[2,1,1],[1,1,0],[0,1,1]]`. Output: `4`. After four minutes, every fresh
 *   orange has become rotten.
 * - Input: `grid = [[2,1,1],[0,1,1],[1,0,1]]`. Output: `-1`. The orange in the bottom-left
 *   corner is never able to rot because it is not connected to any rotten orange.
 * - Input: `grid = [[0,2]]`. Output: `0`. There are already no fresh oranges at minute `0`.
 *
 * Constraints:
 * - `m == grid.length`.
 * - `n == grid[i].length`.
 * - `1 <= m, n <= 10`.
 * - `grid[i][j]` is `0`, `1`, or `2`.
 *
 * [LeetCode 994: Rotting Oranges](https://leetcode.com/problems/rotting-oranges/)
 */
class Solution {
    fun orangesRotting(grid: Array<IntArray>): Int {
        TODO("Implement solution")
    }
}
