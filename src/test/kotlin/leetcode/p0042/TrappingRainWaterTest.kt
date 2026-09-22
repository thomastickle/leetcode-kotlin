package leetcode.p0042

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TrappingRainWaterTest {
    private val solution = Solution()

    @Test
    fun `calculates trapped water for example 1 (multi-basin complex terrain)`() {
        assertEquals(
            6,
            solution.trap(intArrayOf(0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1)),
        )
    }

    @Test
    fun `calculates trapped water for example 2 (single deep basin)`() {
        assertEquals(
            9,
            solution.trap(intArrayOf(4, 2, 0, 3, 2, 5)),
        )
    }

    @Test
    fun `returns zero for single element (minimum size)`() {
        assertEquals(
            0,
            solution.trap(intArrayOf(5)),
        )
    }

    @Test
    fun `returns zero for two elements (cannot trap water)`() {
        assertEquals(
            0,
            solution.trap(intArrayOf(3, 2)),
        )
    }

    @Test
    fun `returns zero for strictly increasing terrain`() {
        assertEquals(
            0,
            solution.trap(intArrayOf(1, 2, 3, 4, 5)),
        )
    }

    @Test
    fun `returns zero for strictly decreasing terrain`() {
        assertEquals(
            0,
            solution.trap(intArrayOf(5, 4, 3, 2, 1)),
        )
    }

    @Test
    fun `returns zero for flat terrain (all identical heights)`() {
        assertEquals(
            0,
            solution.trap(intArrayOf(3, 3, 3, 3)),
        )
    }

    @Test
    fun `handles simple V-shaped container`() {
        assertEquals(
            3,
            solution.trap(intArrayOf(3, 0, 3)),
        )
    }

    @Test
    fun `handles multiple equal peaks trapping water`() {
        assertEquals(
            4,
            solution.trap(intArrayOf(3, 1, 3, 1, 3)),
        )
    }
}
