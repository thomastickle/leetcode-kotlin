package leetcode.p0289

/**
 * # 289. Game of Life
 *
 * According to the rules of Conway's Game of Life, each cell in an `m x n` board is either live
 * (represented by `1`) or dead (represented by `0`). Each cell interacts with its eight neighbors
 * (horizontal, vertical, and diagonal). The next state of every cell is determined simultaneously
 * from the current state using these rules:
 * 1. A live cell with fewer than two live neighbors dies from under-population.
 * 2. A live cell with two or three live neighbors survives.
 * 3. A live cell with more than three live neighbors dies from over-population.
 * 4. A dead cell with exactly three live neighbors becomes live through reproduction.
 *
 * Given the current board, update it in-place to represent the next state. No value needs to be
 * returned. All cell transitions happen simultaneously; do not use an already-updated cell when
 * determining another cell's next state.
 *
 * Examples:
 * - Input: `board = [[0,1,0],[0,0,1],[1,1,1],[0,0,0]]`.
 *   Output: `[[0,0,0],[1,0,1],[0,1,1],[0,1,0]]`.
 * - Input: `board = [[1,1],[1,0]]`.
 *   Output: `[[1,1],[1,1]]`.
 *
 * Constraints:
 * - `m == board.length`
 * - `n == board[i].length`
 * - `1 <= m, n <= 25`
 * - `board[i][j]` is `0` or `1`.
 *
 * Follow-up: Could you solve it in-place while updating cells simultaneously? In principle, the
 * board is infinite, which raises the problem of how to handle its borders when live cells reach
 * them. How would you address that?
 *
 * [LeetCode 289: Game of Life](https://leetcode.com/problems/game-of-life/)
 */
class Solution {
    fun gameOfLife(board: Array<IntArray>) {
        val m = board.size
        val n = board[0].size

        fun getLiveNeighborCount(row: Int, column: Int): Int {
            var neighborCount = 0

            val startRow = maxOf(0, row - 1)
            val stopRow = minOf(m - 1, row + 1)
            val startColumn = maxOf(0, column - 1)
            val stopColumn = minOf(n - 1, column + 1)

            for (i in startRow..stopRow) {
                for (j in startColumn..stopColumn) {
                    if (i == row && j == column) continue

                    neighborCount += board[i][j] and 1
                }
            }

            return neighborCount
        }

        for (row in 0 until m) {
            for (column in 0 until n) {
                val liveNeighbors = getLiveNeighborCount(row, column)
                val alive = board[row][column] and 1 == 1

                val survives = if (alive) {
                    liveNeighbors in 2..3
                } else {
                    liveNeighbors == 3
                }

                if (survives) {
                    board[row][column] = board[row][column] or 2
                }
            }
        }

        for (row in 0 until m) {
            for (column in 0 until n) {
                board[row][column] = board[row][column] ushr 1
            }
        }
    }
}
