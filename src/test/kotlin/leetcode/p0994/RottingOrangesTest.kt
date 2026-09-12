package leetcode.p0994

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RottingOrangesTest {
    private val solution = Solution()

    @Test
    fun `returns four minutes for the first example`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 1, 1),
        )

        assertEquals(4, solution.orangesRotting(grid))
    }

    @Test
    fun `returns minus one when a fresh orange cannot be reached`() {
        val grid = arrayOf(
            intArrayOf(2, 1, 1),
            intArrayOf(0, 1, 1),
            intArrayOf(1, 0, 1),
        )

        assertEquals(-1, solution.orangesRotting(grid))
    }

    @Test
    fun `returns zero when there are no fresh oranges`() {
        assertEquals(
            0,
            solution.orangesRotting(
                arrayOf(
                    intArrayOf(0, 2),
                ),
            ),
        )
    }

    @Test
    fun `returns zero for a single rotten orange`() {
        assertEquals(0, solution.orangesRotting(arrayOf(intArrayOf(2))))
    }

    @Test
    fun `returns minus one when the grid contains only fresh oranges`() {
        assertEquals(
            -1,
            solution.orangesRotting(
                arrayOf(
                    intArrayOf(1, 1),
                    intArrayOf(1, 1),
                ),
            ),
        )
    }

    @Test
    fun `counts minutes across multiple simultaneous layers`() {
        val grid = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 2, 1),
            intArrayOf(1, 1, 1),
        )

        assertEquals(2, solution.orangesRotting(grid))
    }
}
