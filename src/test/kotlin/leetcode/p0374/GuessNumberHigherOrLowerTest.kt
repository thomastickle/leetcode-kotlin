package leetcode.p0374

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GuessNumberHigherOrLowerTest {
    @Test
    fun `returns the picked number from the first example`() {
        assertEquals(6, Solution(6).guessNumber(10))
    }

    @Test
    fun `returns the picked number when the range contains only one value`() {
        assertEquals(1, Solution(1).guessNumber(1))
    }

    @Test
    fun `returns the lower endpoint from the third example`() {
        assertEquals(1, Solution(1).guessNumber(2))
    }

    @Test
    fun `returns the upper endpoint for a two-value range`() {
        assertEquals(2, Solution(2).guessNumber(2))
    }

    @Test
    fun `supports the maximum allowed range endpoint`() {
        assertEquals(Int.MAX_VALUE, Solution(Int.MAX_VALUE).guessNumber(Int.MAX_VALUE))
    }

    @Test
    fun `guess reports whether the picked number is higher or lower`() {
        val solution = Solution(6)

        assertEquals(1, solution.guess(5))
        assertEquals(0, solution.guess(6))
        assertEquals(-1, solution.guess(7))
    }
}
