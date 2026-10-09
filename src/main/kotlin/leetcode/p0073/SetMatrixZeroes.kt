package leetcode.p0073

/**
 * # 73. Set Matrix Zeroes
 *
 * Given an `m x n` integer matrix, if an element is `0`, set its entire row and column to `0`s.
 * You must update the matrix in-place.
 *
 * Examples:
 * - Input: `matrix = [[1,1,1],[1,0,1],[1,1,1]]`.
 *   Output: `[[1,0,1],[0,0,0],[1,0,1]]`.
 * - Input: `matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]`.
 *   Output: `[[0,0,0,0],[0,4,5,0],[0,3,1,0]]`.
 *
 * Constraints:
 * - `m == matrix.length`
 * - `n == matrix[i].length`
 * - `1 <= m, n <= 200`
 * - `-2^31 <= matrix[i][j] <= 2^31 - 1`
 *
 * Follow up: Could you solve it using `O(1)` space?
 *
 * [LeetCode 73: Set Matrix Zeroes](https://leetcode.com/problems/set-matrix-zeroes/)
 */
class Solution {
    fun setZeroes(matrix: Array<IntArray>) {
        val rows = matrix.size
        val columns = matrix[0].size
        var firstColumnZero = false

        // Record all the rows and column that have a 0, taking care to preserve the first column, but noting
        // if the first column has a zero
        for (row in 0 until rows) {
            if (matrix[row][0] == 0) {
                firstColumnZero = true
            }

            for (column in 1 until columns) {
                if (matrix[row][column] == 0) {
                    matrix[row][0] = 0
                    matrix[0][column] = 0
                }
            }
        }

        for (row in rows -1 downTo 0) {
            for (column in columns - 1 downTo 1) {
                if (matrix[row][0] == 0 || matrix[0][column] == 0) {
                    matrix[row][column] = 0
                }
            }

            if (firstColumnZero) {
                matrix[row][0] = 0
            }
        }
    }
}
