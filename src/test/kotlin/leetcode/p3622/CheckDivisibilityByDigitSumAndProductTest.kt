package leetcode.p3622

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CheckDivisibilityByDigitSumAndProductTest {
    private val solution = Solution()

    @Test
    fun `returns true for ninety-nine from the first example`() {
        assertTrue(solution.checkDivisibility(99))
    }

    @Test
    fun `returns false for twenty-three from the second example`() {
        assertFalse(solution.checkDivisibility(23))
    }

    @Test
    fun `returns false for single-digit minimum constraint boundary`() {
        assertFalse(solution.checkDivisibility(1))
    }

    @Test
    fun `returns false for single-digit even number`() {
        assertFalse(solution.checkDivisibility(2))
    }

    @Test
    fun `returns true when a zero digit makes the product zero`() {
        assertTrue(solution.checkDivisibility(10))
    }

    @Test
    fun `returns true for nineteen where sum plus product equals the number`() {
        assertTrue(solution.checkDivisibility(19))
    }

    @Test
    fun `returns false for twelve where sum plus product does not divide evenly`() {
        assertFalse(solution.checkDivisibility(12))
    }

    @Test
    fun `returns true for maximum constraint upper bound`() {
        assertTrue(solution.checkDivisibility(1_000_000))
    }
}
