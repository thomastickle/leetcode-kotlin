package leetcode.p0011

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ContainerWithMostWaterTest {
    private val solution = Solution()

    @Test
    fun `returns the maximum area from the first example`() {
        assertEquals(49, solution.maxArea(intArrayOf(1, 8, 6, 2, 5, 4, 8, 3, 7)))
    }

    @Test
    fun `returns one for two unit-height lines`() {
        assertEquals(1, solution.maxArea(intArrayOf(1, 1)))
    }

    @Test
    fun `returns zero when every line has zero height`() {
        assertEquals(0, solution.maxArea(intArrayOf(0, 0)))
    }

    @Test
    fun `accounts for both width and the shorter line`() {
        assertEquals(4, solution.maxArea(intArrayOf(1, 2, 4, 3)))
    }

    @Test
    fun `uses the full width between equal-height outer lines`() {
        assertEquals(10, solution.maxArea(intArrayOf(5, 5, 5)))
    }
}
