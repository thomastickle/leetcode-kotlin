package leetcode.p0136

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SingleNumberTest {
    private val solution = Solution()

    @Test
    fun `returns the single value from the first example`() {
        assertEquals(1, solution.singleNumber(intArrayOf(2, 2, 1)))
    }

    @Test
    fun `returns the single value from the second example`() {
        assertEquals(4, solution.singleNumber(intArrayOf(4, 1, 2, 1, 2)))
    }

    @Test
    fun `returns the only value in a one-element array`() {
        assertEquals(1, solution.singleNumber(intArrayOf(1)))
    }

    @Test
    fun `handles negative values`() {
        assertEquals(-2, solution.singleNumber(intArrayOf(-1, -1, -2)))
    }

    @Test
    fun `handles values at the constraint boundaries`() {
        assertEquals(30000, solution.singleNumber(intArrayOf(-30000, -30000, 30000)))
    }
}
