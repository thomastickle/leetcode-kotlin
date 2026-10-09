package leetcode.p0048

/**
 * # 48. Rotate Image
 *
 * You are given an `n x n` 2D matrix representing an image. Rotate the image by 90 degrees
 * clockwise. The rotation must be done in-place: modify the input 2D matrix directly and do not
 * allocate another 2D matrix for the rotation.
 *
 * Examples:
 * - Input: `matrix = [[1,2,3],[4,5,6],[7,8,9]]`. Output: `[[7,4,1],[8,5,2],[9,6,3]]`.
 * - Input: `matrix = [[5,1,9,11],[2,4,8,10],[13,3,6,7],[15,14,12,16]]`.
 *   Output: `[[15,13,2,5],[14,3,4,1],[12,6,8,9],[16,7,10,11]]`.
 *
 * Constraints:
 * - `n == matrix.length == matrix[i].length`
 * - `1 <= n <= 20`
 * - `-1000 <= matrix[i][j] <= 1000`
 *
 * [LeetCode 48: Rotate Image](https://leetcode.com/problems/rotate-image/)
 */
class Solution {
    fun rotate(matrix: Array<IntArray>) {
        val matrixSize = matrix.size
        val rowsToRotate = matrixSize / 2
        val columnsToRotate = (matrixSize + 1) / 2
        val last = matrixSize - 1
        for (row in 0 until rowsToRotate) {
            for (column in 0 until columnsToRotate) {
                val oppositeRow = last - row
                val oppositeColumn = last - column
                val temp = matrix[row][column]
                matrix[row][column] = matrix[oppositeColumn][row]
                matrix[oppositeColumn][row] = matrix[oppositeRow][oppositeColumn]
                matrix[oppositeRow][oppositeColumn] = matrix[column][oppositeRow]
                matrix[column][oppositeRow] = temp
            }
        }
    }
}
