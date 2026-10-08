package leetcode.p0036

/**
 * # 36. Valid Sudoku
 *
 * Determine whether a 9 x 9 Sudoku board is valid. Each row, each column, and each of the nine
 * 3 x 3 sub-boxes must contain the digits `1` through `9` without repetition. A partially filled
 * board may be valid even if it is not solvable; only the filled cells need to be checked.
 *
 * Examples:
 * - Input: `board = [["5","3",".",".","7",".",".",".","."], ["6",".",".","1","9","5",".",".","."], [".","9","8",".",".",".",".","6","."], ["8",".",".",".","6",".",".",".","3"], ["4",".",".","8",".","3",".",".","1"], ["7",".",".",".","2",".",".",".","6"], [".","6",".",".",".",".","2","8","."], [".",".",".","4","1","9",".",".","5"], [".",".",".",".","8",".",".","7","9"]]`. Output: `true`.
 * - Input: the same board as Example 1, except the top-left cell is changed from `"5"` to `"8"`. Output: `false`. The top-left 3 x 3 sub-box then contains two `8`s.
 *
 * Constraints:
 * - `board.length == 9`
 * - `board[i].length == 9`
 * - `board[i][j]` is a digit from `1` to `9` or `'.'`.
 *
 * [LeetCode 36: Valid Sudoku](https://leetcode.com/problems/valid-sudoku/)
 */
class Solution {
    fun isValidSudoku(board: Array<CharArray>): Boolean {
        TODO("Implement solution")
    }
}
