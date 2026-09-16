package leetcode.p0338

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class CountingBitsTest {
    private val solution = Solution()

    @Test
    fun `returns the counts for the first example`() {
        assertArrayEquals(intArrayOf(0, 1, 1), solution.countBits(2))
    }

    @Test
    fun `returns the counts for the second example`() {
        assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2), solution.countBits(5))
    }

    @Test
    fun `returns zero for the only value in a zero-length range`() {
        assertArrayEquals(intArrayOf(0), solution.countBits(0))
    }

    @Test
    fun `counts bits through a power of two`() {
        assertArrayEquals(intArrayOf(0, 1, 1, 2, 1, 2, 2, 3, 1), solution.countBits(8))
    }

    @Test
    fun `returns one for the first nonzero value`() {
        assertArrayEquals(intArrayOf(0, 1), solution.countBits(1))
    }
}
