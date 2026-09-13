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
    private data class Orange(val rowIndex: Int, val columnIndex: Int)
    private enum class DIRECTION(val rowOffset: Int, val columnOffset: Int) {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1)
    }


    fun orangesRotting(grid: Array<IntArray>): Int {
        var freshOrangeCount = 0
        var minutes = 0

        val currentMinute = ArrayDeque<Orange>()

        for ((rowIndex, row) in grid.withIndex()) {
            for ((columnIndex, gridSquare) in row.withIndex()) {
                if (gridSquare == 0) continue
                if (gridSquare == 1) {
                    freshOrangeCount++
                }
                if (gridSquare == 2) {
                    val rottenOrange = Orange(rowIndex, columnIndex)
                    currentMinute.add(rottenOrange)
                }
            }
        }

        while (currentMinute.isNotEmpty()) {
            repeat(currentMinute.size) {
                val rottedOrange = currentMinute.removeFirst()

                for (direction in DIRECTION.entries) {
                    val nextRowIndex = rottedOrange.rowIndex + direction.rowOffset
                    val nextColumnIndex = rottedOrange.columnIndex + direction.columnOffset

                    if (nextRowIndex !in grid.indices) continue
                    if (nextColumnIndex !in grid[nextRowIndex].indices) continue
                    if (grid[nextRowIndex][nextColumnIndex] != 1) continue

                    grid[nextRowIndex][nextColumnIndex] = 2
                    freshOrangeCount--

                    currentMinute.addLast(Orange(nextRowIndex, nextColumnIndex))
                }
            }

            if (currentMinute.isEmpty()) break

            minutes++
        }

        return if (freshOrangeCount == 0) minutes else -1

    }
}
