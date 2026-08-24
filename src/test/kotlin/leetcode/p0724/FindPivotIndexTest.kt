package leetcode.p0724

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindPivotIndexTest {
    private val solution = Solution()

    @Test
    fun `finds pivot index in the middle for first example`() {
        assertEquals(3, solution.pivotIndex(intArrayOf(1, 7, 3, 6, 5, 6)))
    }

    @Test
    fun `returns negative one when no pivot index exists`() {
        assertEquals(-1, solution.pivotIndex(intArrayOf(1, 2, 3)))
    }

    @Test
    fun `finds pivot index at the beginning for third example`() {
        assertEquals(0, solution.pivotIndex(intArrayOf(2, 1, -1)))
    }

    @Test
    fun `returns index zero for single-element array`() {
        assertEquals(0, solution.pivotIndex(intArrayOf(10)))
    }

    @Test
    fun `finds pivot index at the last position`() {
        assertEquals(2, solution.pivotIndex(intArrayOf(-1, 1, 2)))
    }

    @Test
    fun `returns the leftmost pivot index when multiple pivots exist`() {
        assertEquals(0, solution.pivotIndex(intArrayOf(0, 0, 0, 0)))
    }

    @Test
    fun `handles negative numbers and zeros when no pivot exists`() {
        assertEquals(-1, solution.pivotIndex(intArrayOf(-1, -1, 0, 1, 1)))
    }

    @Test
    fun `handles array with two elements where no pivot exists`() {
        assertEquals(-1, solution.pivotIndex(intArrayOf(1, 2)))
    }

    @Test
    fun `handles array with two elements where pivot exists at index zero`() {
        assertEquals(0, solution.pivotIndex(intArrayOf(1, 0)))
    }

    @Test
    fun `handles array with two elements where pivot exists at index one`() {
        assertEquals(1, solution.pivotIndex(intArrayOf(0, 1)))
    }
}
