package leetcode.p0435

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NonOverlappingIntervalsTest {
    private val solution = Solution()

    @Test
    fun `removes 1 interval for example 1`() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(1, 3)
        )
        assertEquals(1, solution.eraseOverlapIntervals(intervals))
    }

    @Test
    fun `removes duplicate intervals for example 2`() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(1, 2),
            intArrayOf(1, 2)
        )
        assertEquals(2, solution.eraseOverlapIntervals(intervals))
    }

    @Test
    fun `returns 0 for non-overlapping intervals in example 3`() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3)
        )
        assertEquals(0, solution.eraseOverlapIntervals(intervals))
    }

    @Test
    fun `returns 0 for a single interval`() {
        val intervals = arrayOf(
            intArrayOf(1, 2)
        )
        assertEquals(0, solution.eraseOverlapIntervals(intervals))
    }

    @Test
    fun `returns 0 for intervals that only touch at endpoints`() {
        val intervals = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(2, 3),
            intArrayOf(3, 5)
        )
        assertEquals(0, solution.eraseOverlapIntervals(intervals))
    }

    @Test
    fun `removes enclosing interval when nested with multiple smaller intervals`() {
        val intervals = arrayOf(
            intArrayOf(1, 10),
            intArrayOf(2, 3),
            intArrayOf(3, 4),
            intArrayOf(4, 5)
        )
        assertEquals(1, solution.eraseOverlapIntervals(intervals))
    }

    @Test
    fun `handles negative coordinate ranges`() {
        val intervals = arrayOf(
            intArrayOf(-50, -30),
            intArrayOf(-40, -20),
            intArrayOf(-25, -10),
            intArrayOf(-10, 0)
        )
        assertEquals(1, solution.eraseOverlapIntervals(intervals))
    }

    @Test
    fun `handles unsorted interval array`() {
        val intervals = arrayOf(
            intArrayOf(2, 3),
            intArrayOf(1, 3),
            intArrayOf(1, 2),
            intArrayOf(3, 4)
        )
        assertEquals(1, solution.eraseOverlapIntervals(intervals))
    }
}
