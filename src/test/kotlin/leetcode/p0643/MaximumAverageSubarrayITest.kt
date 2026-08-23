package leetcode.p0643

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumAverageSubarrayITest {
    private val solution = Solution()
    private val tolerance = 1e-5

    @Test
    fun `returns the maximum average from the first example`() {
        assertEquals(12.75, solution.findMaxAverage(intArrayOf(1, 12, -5, -6, 50, 3), 4), tolerance)
    }

    @Test
    fun `returns the only value from the second example`() {
        assertEquals(5.0, solution.findMaxAverage(intArrayOf(5), 1), tolerance)
    }

    @Test
    fun `selects the largest element when the window has length one`() {
        assertEquals(3.0, solution.findMaxAverage(intArrayOf(1, 3, -1, 2), 1), tolerance)
    }

    @Test
    fun `uses the whole array when k equals the array length`() {
        assertEquals(-2.0, solution.findMaxAverage(intArrayOf(-1, -2, -3), 3), tolerance)
    }

    @Test
    fun `finds the least negative window`() {
        assertEquals(-2.5, solution.findMaxAverage(intArrayOf(-5, -2, -3, -4), 2), tolerance)
    }

    @Test
    fun `chooses the best overlapping window`() {
        assertEquals(3.0, solution.findMaxAverage(intArrayOf(0, 1, 2, 3, 4), 3), tolerance)
    }

    @Test
    fun `supports values at both constraint extremes`() {
        assertEquals(0.0, solution.findMaxAverage(intArrayOf(10_000, -10_000), 2), tolerance)
    }
}
