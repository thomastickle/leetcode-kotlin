package leetcode.p2352

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EqualRowAndColumnPairsTest {
    private val solution = Solution()

    @Test
    fun `returns one pair for the first example`() {
        val grid = arrayOf(
            intArrayOf(3, 2, 1),
            intArrayOf(1, 7, 6),
            intArrayOf(2, 7, 7),
        )

        assertEquals(1, solution.equalPairs(grid))
    }

    @Test
    fun `returns three pairs for the second example`() {
        val grid = arrayOf(
            intArrayOf(3, 1, 2, 2),
            intArrayOf(1, 4, 4, 5),
            intArrayOf(2, 4, 2, 2),
            intArrayOf(2, 4, 2, 2),
        )

        assertEquals(3, solution.equalPairs(grid))
    }

    @Test
    fun `returns one pair for a 1x1 grid`() {
        val grid = arrayOf(
            intArrayOf(42),
        )

        assertEquals(1, solution.equalPairs(grid))
    }

    @Test
    fun `returns zero when no row equals any column`() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
        )

        assertEquals(0, solution.equalPairs(grid))
    }

    @Test
    fun `returns n squared when all matrix cells have the identical value`() {
        val grid = arrayOf(
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5),
            intArrayOf(5, 5, 5),
        )

        assertEquals(9, solution.equalPairs(grid))
    }

    @Test
    fun `handles symmetric matrix where every row equals its corresponding column`() {
        val grid = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(2, 4, 5),
            intArrayOf(3, 5, 6),
        )

        assertEquals(3, solution.equalPairs(grid))
    }

    @Test
    fun `handles multiple identical rows matching multiple identical columns`() {
        val grid = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
        )
        // Row 0: [1, 2], Row 1: [1, 2]
        // Col 0: [1, 1], Col 1: [2, 2]
        // Rows: [1, 2], [1, 2]; Cols: [1, 1], [2, 2]. No matches.
        assertEquals(0, solution.equalPairs(grid))
    }

    @Test
    fun `handles palindromic row matching its column`() {
        val grid = arrayOf(
            intArrayOf(1, 2, 1),
            intArrayOf(2, 3, 2),
            intArrayOf(1, 2, 1),
        )
        // Rows:
        // R0: [1, 2, 1]
        // R1: [2, 3, 2]
        // R2: [1, 2, 1]
        // Cols:
        // C0: [1, 2, 1]
        // C1: [2, 3, 2]
        // C2: [1, 2, 1]
        // R0 matches C0, C2 (2)
        // R1 matches C1 (1)
        // R2 matches C0, C2 (2)
        // Total = 2 + 1 + 2 = 5
        assertEquals(5, solution.equalPairs(grid))
    }
}
