package leetcode.p0128

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestConsecutiveSequenceTest {
    private val solution = Solution()

    @Test
    fun `returns the length of the longest sequence from the first example`() {
        assertEquals(4, solution.longestConsecutive(intArrayOf(100, 4, 200, 1, 3, 2)))
    }

    @Test
    fun `returns the length of the longest sequence from the second example`() {
        assertEquals(9, solution.longestConsecutive(intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1)))
    }

    @Test
    fun `ignores duplicates when finding a sequence`() {
        assertEquals(3, solution.longestConsecutive(intArrayOf(1, 0, 1, 2)))
    }

    @Test
    fun `returns zero for an empty array`() {
        assertEquals(0, solution.longestConsecutive(intArrayOf()))
    }

    @Test
    fun `returns one for a single element`() {
        assertEquals(1, solution.longestConsecutive(intArrayOf(42)))
    }

    @Test
    fun `finds sequences containing negative values regardless of input order`() {
        assertEquals(3, solution.longestConsecutive(intArrayOf(4, -1, -3, 5, -2, 10)))
    }

    @Test
    fun `handles values at the numeric constraint boundaries`() {
        assertEquals(2, solution.longestConsecutive(intArrayOf(-1_000_000_000, 1_000_000_000, -999_999_999)))
    }

    @Test
    fun `returns one when all values are duplicates`() {
        assertEquals(1, solution.longestConsecutive(intArrayOf(7, 7, 7)))
    }
}
