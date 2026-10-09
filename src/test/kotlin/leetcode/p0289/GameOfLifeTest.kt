package leetcode.p0289

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GameOfLifeTest {
    private val solution = Solution()

    @Test
    fun `updates the board for example 1`() {
        val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
            intArrayOf(1, 1, 1),
            intArrayOf(0, 0, 0),
        )

        solution.gameOfLife(board)

        assertEquals(
            listOf(listOf(0, 0, 0), listOf(1, 0, 1), listOf(0, 1, 1), listOf(0, 1, 0)),
            board.map { it.toList() },
        )
    }

    @Test
    fun `updates the board for example 2`() {
        val board = arrayOf(
            intArrayOf(1, 1),
            intArrayOf(1, 0),
        )

        solution.gameOfLife(board)

        assertEquals(listOf(listOf(1, 1), listOf(1, 1)), board.map { it.toList() })
    }

    @Test
    fun `a lone live cell dies from under-population`() {
        val board = arrayOf(intArrayOf(1))

        solution.gameOfLife(board)

        assertEquals(listOf(listOf(0)), board.map { it.toList() })
    }

    @Test
    fun `an all-dead board remains unchanged`() {
        val board = arrayOf(
            intArrayOf(0, 0, 0),
            intArrayOf(0, 0, 0),
        )

        solution.gameOfLife(board)

        assertEquals(listOf(listOf(0, 0, 0), listOf(0, 0, 0)), board.map { it.toList() })
    }

    @Test
    fun `counts only neighbors inside the board boundary`() {
        val board = arrayOf(intArrayOf(1, 1, 1))

        solution.gameOfLife(board)

        assertEquals(listOf(listOf(0, 1, 0)), board.map { it.toList() })
    }

    @Test
    fun `updates a blinker simultaneously`() {
        val board = arrayOf(
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 1, 0),
        )

        solution.gameOfLife(board)

        assertEquals(
            listOf(listOf(0, 0, 0), listOf(1, 1, 1), listOf(0, 0, 0)),
            board.map { it.toList() },
        )
    }
}
