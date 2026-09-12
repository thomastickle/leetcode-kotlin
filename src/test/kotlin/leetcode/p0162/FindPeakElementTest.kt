package leetcode.p0162

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class FindPeakElementTest {
    private val solution = Solution()

    @Test
    fun `returns peak index for the first example`() {
        assertEquals(2, solution.findPeakElement(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun `returns a valid peak index for the second example`() {
        val peakIndex = solution.findPeakElement(intArrayOf(1, 2, 1, 3, 5, 6, 4))
        assertTrue(peakIndex == 1 || peakIndex == 5, "Expected peak index 1 or 5, but got $peakIndex")
    }

    @Test
    fun `returns index zero for a single element array`() {
        assertEquals(0, solution.findPeakElement(intArrayOf(1)))
    }

    @Test
    fun `returns larger element index for two increasing elements`() {
        assertEquals(1, solution.findPeakElement(intArrayOf(1, 2)))
    }

    @Test
    fun `returns larger element index for two decreasing elements`() {
        assertEquals(0, solution.findPeakElement(intArrayOf(2, 1)))
    }

    @Test
    fun `finds peak at first element in strictly decreasing array`() {
        assertEquals(0, solution.findPeakElement(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `finds peak at last element in strictly increasing array`() {
        assertEquals(4, solution.findPeakElement(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `finds peak in array with negative and minimum integer values`() {
        assertEquals(1, solution.findPeakElement(intArrayOf(Int.MIN_VALUE, 0, Int.MIN_VALUE)))
    }

    @Test
    fun `returns any valid peak when multiple peaks exist`() {
        val peakIndex = solution.findPeakElement(intArrayOf(3, 4, 3, 2, 5, 1))
        assertTrue(peakIndex == 1 || peakIndex == 4, "Expected peak index 1 or 4, but got $peakIndex")
    }
}
