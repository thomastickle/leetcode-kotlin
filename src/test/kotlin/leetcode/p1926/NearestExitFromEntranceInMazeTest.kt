package leetcode.p1926

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NearestExitFromEntranceInMazeTest {
    private val solution = Solution()

    private fun mazeOf(vararg rows: String): Array<CharArray> = rows.map(String::toCharArray).toTypedArray()

    @Test
    fun `finds the nearest exit for the first example`() {
        val maze = mazeOf(
            "++.+",
            "...+",
            "+++."
        )

        assertEquals(1, solution.nearestExit(maze, intArrayOf(1, 2)))
    }

    @Test
    fun `finds the nearest exit for the second example`() {
        val maze = mazeOf(
            "+++",
            "...",
            "+++"
        )

        assertEquals(2, solution.nearestExit(maze, intArrayOf(1, 0)))
    }

    @Test
    fun `finds the nearest exit for the third example`() {
        val maze = mazeOf(
            ".+++",
            "...+",
            "+++."
        )

        assertEquals(1, solution.nearestExit(maze, intArrayOf(1, 1)))
    }

    @Test
    fun `returns minus one when every path from the entrance is blocked`() {
        val maze = mazeOf(
            "+++",
            "+.+",
            "+++"
        )

        assertEquals(-1, solution.nearestExit(maze, intArrayOf(1, 1)))
    }

    @Test
    fun `does not treat the entrance itself as an exit`() {
        val maze = mazeOf(
            ".+",
            ".."
        )

        assertEquals(1, solution.nearestExit(maze, intArrayOf(0, 0)))
    }

    @Test
    fun `chooses the shortest path around a dead end`() {
        val maze = mazeOf(
            "+++++",
            "+...+",
            "+.+++",
            "+...+",
            "+++.+"
        )

        assertEquals(5, solution.nearestExit(maze, intArrayOf(1, 1)))
    }

    @Test
    fun `returns minus one for a single-cell maze`() {
        assertEquals(-1, solution.nearestExit(mazeOf("."), intArrayOf(0, 0)))
    }
}