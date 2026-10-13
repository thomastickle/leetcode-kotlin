package leetcode.p0128

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestConsecutiveSequenceTest {
    private val solution = Solution()

    private fun assertBothImplementations(expected: Int, nums: IntArray) {
        assertEquals(expected, solution.longestConsecutive(nums.copyOf()))
        assertEquals(expected, solution.longestConsecutiveRadix(nums.copyOf()))
    }

    @Test
    fun `returns the length of the longest sequence from the first example`() {
        assertBothImplementations(4, intArrayOf(100, 4, 200, 1, 3, 2))
    }

    @Test
    fun `returns the length of the longest sequence from the second example`() {
        assertBothImplementations(9, intArrayOf(0, 3, 7, 2, 5, 8, 4, 6, 0, 1))
    }

    @Test
    fun `ignores duplicates when finding a sequence`() {
        assertBothImplementations(3, intArrayOf(1, 0, 1, 2))
    }

    @Test
    fun `returns zero for an empty array`() {
        assertBothImplementations(0, intArrayOf())
    }

    @Test
    fun `returns one for a single element`() {
        assertBothImplementations(1, intArrayOf(42))
    }

    @Test
    fun `finds sequences containing negative values regardless of input order`() {
        assertBothImplementations(3, intArrayOf(4, -1, -3, 5, -2, 10))
    }

    @Test
    fun `handles values at the numeric constraint boundaries`() {
        assertBothImplementations(2, intArrayOf(-1_000_000_000, 1_000_000_000, -999_999_999))
    }

    @Test
    fun `returns one when all values are duplicates`() {
        assertBothImplementations(1, intArrayOf(7, 7, 7))
    }
}
