package leetcode.p1004

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxConsecutiveOnesIIITest {
    private val solution = Solution()

    @Test
    fun `returns six for the first example`() {
        assertEquals(6, solution.longestOnes(intArrayOf(1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0), 2))
    }

    @Test
    fun `returns three for the second example when no zero can be flipped`() {
        assertEquals(3, solution.longestOnes(intArrayOf(0, 0, 1, 1, 1, 0, 0), 0))
    }

    @Test
    fun `returns zero for a single zero with no flips`() {
        assertEquals(0, solution.longestOnes(intArrayOf(0), 0))
    }

    @Test
    fun `returns one when a single zero can be flipped`() {
        assertEquals(1, solution.longestOnes(intArrayOf(0), 1))
    }

    @Test
    fun `returns the full array when all zeros can be flipped`() {
        assertEquals(5, solution.longestOnes(intArrayOf(0, 0, 0, 0, 0), 5))
    }

    @Test
    fun `returns the full array when it already contains only ones`() {
        assertEquals(4, solution.longestOnes(intArrayOf(1, 1, 1, 1), 0))
    }

    @Test
    fun `chooses the longest window around at most k separated zeros`() {
        assertEquals(5, solution.longestOnes(intArrayOf(1, 0, 1, 1, 0, 1, 1), 1))
    }
}