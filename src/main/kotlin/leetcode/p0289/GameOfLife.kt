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
        TODO("Implement solution")
    }
}
