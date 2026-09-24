package leetcode.p0006

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ZigzagConversionTest {
    private val solution = Solution()

    @Test
    fun `converts the example with three rows`() {
        assertEquals("PAHNAPLSIIGYIR", solution.convert("PAYPALISHIRING", 3))
    }

    @Test
    fun `converts the example with four rows`() {
        assertEquals("PINALSIGYAHRPI", solution.convert("PAYPALISHIRING", 4))
    }

    @Test
    fun `returns a single character unchanged for one row`() {
        assertEquals("A", solution.convert("A", 1))
    }

    @Test
    fun `returns the input unchanged when row count exceeds its length`() {
        assertEquals("AB", solution.convert("AB", 3))
    }

    @Test
    fun `converts correctly with two rows`() {
        assertEquals("ACEBD", solution.convert("ABCDE", 2))
    }

    @Test
    fun `converts multiple cycles with six rows`() {
        assertEquals("AKUBJLTVCIMSWDHNRXEGOQYFPZ", solution.convert("ABCDEFGHIJKLMNOPQRSTUVWXYZ", 6))
    }

    @Test
    fun `preserves punctuation while converting`() {
        assertEquals("A.,", solution.convert("A,.", 2))
    }
}
