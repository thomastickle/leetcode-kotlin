package leetcode.p0209

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumSizeSubarraySumTest {
    private val solution = Solution()

    @Test
    fun `returns minimal length for the first example`() {
        assertEquals(2, solution.minSubArrayLen(7, intArrayOf(2, 3, 1, 2, 4, 3)))
    }

    @Test
    fun `returns one for the second example`() {
        assertEquals(1, solution.minSubArrayLen(4, intArrayOf(1, 4, 4)))
    }

    @Test
    fun `returns zero when no subarray reaches the target`() {
        assertEquals(0, solution.minSubArrayLen(11, intArrayOf(1, 1, 1, 1, 1, 1, 1, 1)))
    }

    @Test
    fun `returns one when a single element reaches the target`() {
        assertEquals(1, solution.minSubArrayLen(5, intArrayOf(1, 2, 5, 2, 8)))
    }

    @Test
    fun `returns the full array length when only the whole array reaches the target`() {
        assertEquals(4, solution.minSubArrayLen(10, intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `handles a one-element array`() {
        assertEquals(1, solution.minSubArrayLen(1, intArrayOf(1)))
    }
}