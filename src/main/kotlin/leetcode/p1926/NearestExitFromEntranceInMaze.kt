package leetcode.p1926

/**
 * # 1926. Nearest Exit from Entrance in Maze
 *
 * You are given an `m x n` maze represented by an array of strings. Each cell is either `'.'`,
 * which represents an empty cell, or `'+'`, which represents a wall. You are also given the
 * entrance position as a two-element array `[entrancerow, entrancecol]`.
 *
 * An exit is an empty cell on the boundary of the maze. The entrance itself is not considered an
 * exit. In one step, you may move up, down, left, or right to an adjacent empty cell. Return the
 * number of steps in the shortest path from the entrance to the nearest exit, or `-1` if no such
 * path exists.
 *
 * Examples:
 * - Input: `maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]]`,
 *   `entrance = [1,2]`. Output: `1`. The nearest exit is `[0,2]`, which is one step away.
 * - Input: `maze = [["+","+","+"],[".",".","."],["+","+","+"]]`,
 *   `entrance = [1,0]`. Output: `2`. The nearest exit is `[1,2]`, which is two steps away.
 * - Input: `maze = [[".","+","+","+"],[".",".",".","+"],["+","+","+","."]]`,
 *   `entrance = [1,1]`. Output: `1`. The nearest exit is `[1,0]`, which is one step away.
 *
 * Constraints:
 * - `1 <= m, n <= 100`.
 * - `maze[i].length == n` for every row `i`.
 * - `maze[i][j]` is either `'.'` or `'+'`.
 * - `entrance.length == 2`.
 * - `0 <= entrancerow < m`.
 * - `0 <= entrancecol < n`.
 * - `maze[entrancerow][entrancecol] == '.'`.
 *
 * [LeetCode 1926: Nearest Exit from Entrance in Maze](https://leetcode.com/problems/nearest-exit-from-entrance-in-maze/)
 */
class Solution {
    private enum class Direction(val rowOffset: Int, val colOffset: Int) {
        UP(-1, 0), DOWN(1, 0), LEFT(0, -1), RIGHT(0, 1)
    }

    data class Coordinate(val row: Int, val column: Int)

    fun nearestExit(maze: Array<CharArray>, entrance: IntArray): Int {
        val height = maze.size
        val width = maze[0].size
        val lastRow = height - 1
        val lastColumn = width - 1

        val (startRow, startColumn) = entrance
        val queue = ArrayDeque<Coordinate>()

        queue.addLast(Coordinate(startRow, startColumn))
        maze[startRow][startColumn] = 'X'

        var steps = 0

        while (queue.isNotEmpty()) {
            repeat(queue.size) {
                val (row, column) = queue.removeFirst()

                for (direction in Direction.entries) {
                    val nextRow = row + direction.rowOffset
                    val nextColumn = column + direction.colOffset

                    if (nextRow !in 0 until height || nextColumn !in 0 until width || maze[nextRow][nextColumn] != '.') {
                        continue
                    }

                    if (nextRow == 0 || nextRow == lastRow || nextColumn == 0 || nextColumn == lastColumn) {
                        return steps + 1
                    }

                    maze[nextRow][nextColumn] = 'X'
                    queue.addLast(Coordinate(nextRow, nextColumn))
                }
            }

            steps++
        }

        return -1
    }
}