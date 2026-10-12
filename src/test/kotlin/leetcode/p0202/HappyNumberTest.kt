package leetcode.p0202

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class HappyNumberTest {
    private val solution = Solution()

    @Test
    fun `returns true for the first example`() {
        assertTrue(solution.isHappy(19))
    }

    @Test
    fun `returns false for the second example`() {
        assertFalse(solution.isHappy(2))
    }

    @Test
    fun `returns true for one`() {
        assertTrue(solution.isHappy(1))
    }

    @Test
    fun `returns true for another happy number`() {
        assertTrue(solution.isHappy(7))
    }

    @Test
    fun `returns false for a number in the non-happy cycle`() {
        assertFalse(solution.isHappy(4))
    }

    @Test
    fun `handles the maximum constrained integer`() {
        assertFalse(solution.isHappy(Int.MAX_VALUE))
    }
}
