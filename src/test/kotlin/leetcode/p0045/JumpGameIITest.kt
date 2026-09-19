package leetcode.p0045

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class JumpGameIITest {
    private val solution = Solution()

    @Test
    fun `finds minimum jumps in example 1`() {
        assertEquals(2, solution.jump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun `finds minimum jumps in example 2`() {
        assertEquals(2, solution.jump(intArrayOf(2, 3, 0, 1, 4)))
    }

    @Test
    fun `returns zero jumps for single-element array with zero`() {
        assertEquals(0, solution.jump(intArrayOf(0)))
    }

    @Test
    fun `returns zero jumps for single-element array with positive value`() {
        assertEquals(0, solution.jump(intArrayOf(5)))
    }

    @Test
    fun `reaches destination in a single jump when start covers entire array`() {
        assertEquals(1, solution.jump(intArrayOf(3, 1, 1)))
    }

    @Test
    fun `requires step-by-step jumps when each step is length one`() {
        assertEquals(3, solution.jump(intArrayOf(1, 1, 1, 1)))
    }

    @Test
    fun `picks optimal jump to minimize total jump count`() {
        assertEquals(2, solution.jump(intArrayOf(1, 3, 1, 1, 4)))
    }
}
