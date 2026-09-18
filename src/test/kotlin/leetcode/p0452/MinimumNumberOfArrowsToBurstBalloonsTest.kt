package leetcode.p0452

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumNumberOfArrowsToBurstBalloonsTest {
    private val solution = Solution()

    @Test
    fun `returns 2 arrows for example 1`() {
        val points = arrayOf(
            intArrayOf(10, 16),
            intArrayOf(2, 8),
            intArrayOf(1, 6),
            intArrayOf(7, 12)
        )
        assertEquals(2, solution.findMinArrowShots(points))
    }

    @Test
    fun `returns one arrow per balloon for example 2`() {
        val points = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
            intArrayOf(5, 6),
            intArrayOf(7, 8)
        )
        assertEquals(4, solution.findMinArrowShots(points))
    }

    @Test
    fun `uses shared endpoints for example 3`() {
        val points = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        assertEquals(2, solution.findMinArrowShots(points))
    }

    @Test
    fun `returns one arrow for a single balloon`() {
        val points = arrayOf(intArrayOf(1, 2))

        assertEquals(1, solution.findMinArrowShots(points))
    }

    @Test
    fun `handles overlapping balloons with negative coordinates`() {
        val points = arrayOf(
            intArrayOf(-10, -5),
            intArrayOf(-8, -3),
            intArrayOf(-4, 0)
        )

        assertEquals(2, solution.findMinArrowShots(points))
    }

    @Test
    fun `handles intervals at the integer coordinate limits`() {
        val points = arrayOf(
            intArrayOf(Int.MIN_VALUE, Int.MIN_VALUE + 1),
            intArrayOf(Int.MAX_VALUE - 1, Int.MAX_VALUE)
        )

        assertEquals(2, solution.findMinArrowShots(points))
    }
}
