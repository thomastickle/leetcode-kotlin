package leetcode.p0274

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HIndexTest {
    private val solution = Solution()

    @Test
    fun `calculates h-index for example 1`() {
        assertEquals(3, solution.hIndex(intArrayOf(3, 0, 6, 1, 5)))
    }

    @Test
    fun `calculates h-index for example 2`() {
        assertEquals(1, solution.hIndex(intArrayOf(1, 3, 1)))
    }

    @Test
    fun `returns zero for a single paper with zero citations`() {
        assertEquals(0, solution.hIndex(intArrayOf(0)))
    }

    @Test
    fun `returns one for a single paper with high citations`() {
        assertEquals(1, solution.hIndex(intArrayOf(100)))
    }

    @Test
    fun `returns zero when all papers have zero citations`() {
        assertEquals(0, solution.hIndex(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `calculates h-index where h is constrained by the number of papers`() {
        assertEquals(4, solution.hIndex(intArrayOf(10, 8, 5, 4, 3)))
    }

    @Test
    fun `returns array length when all papers have citations greater than or equal to length`() {
        assertEquals(5, solution.hIndex(intArrayOf(5, 5, 5, 5, 5)))
    }

    @Test
    fun `calculates h-index with bimodal distribution of citations`() {
        assertEquals(2, solution.hIndex(intArrayOf(4, 4, 0, 0)))
    }
}
