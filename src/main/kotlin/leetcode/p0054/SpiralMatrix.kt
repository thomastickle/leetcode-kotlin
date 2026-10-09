package leetcode.p0054

/**
 * # 54. Spiral Matrix
 *
 * Given an `m x n` matrix, return all elements of the matrix in spiral order, starting at the
 * top-left and proceeding clockwise around the matrix.
 *
 * Examples:
 * - Input: `matrix = [[1,2,3],[4,5,6],[7,8,9]]`. Output: `[1,2,3,6,9,8,7,4,5]`.
 * - Input: `matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]`.
 *   Output: `[1,2,3,4,8,12,11,10,9,5,6,7]`.
 *
 * Constraints:
 * - `m == matrix.length`
 * - `n == matrix[i].length`
 * - `1 <= m, n <= 10`
 * - `-100 <= matrix[i][j] <= 100`
 *
 * [LeetCode 54: Spiral Matrix](https://leetcode.com/problems/spiral-matrix/)
 */
class Solution {
    fun spiralOrder(matrix: Array<IntArray>): List<Int> {
        val output = ArrayList<Int>(matrix.size * matrix[0].size)

        var left = 0
        var right = matrix[0].lastIndex
        var top = 0
        var bottom = matrix.lastIndex

        while (left <= right && top <= bottom) {
            for (column in left..right) {
                output.add(matrix[top][column])
            }
            top++

            for (row in top..bottom) {
                output.add(matrix[row][right])
            }
            right--

            if (top <= bottom) {
                for (column in right downTo left) {
                    output.add(matrix[bottom][column])
                }
                bottom--
            }

            if (left <= right) {
                for (row in bottom downTo top) {
                    output.add(matrix[row][left])
                }
                left++
            }
        }

        return output
    }
}
