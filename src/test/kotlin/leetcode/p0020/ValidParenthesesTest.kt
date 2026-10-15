package leetcode.p0020

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidParenthesesTest {
    private val solution = Solution()

    @Test
    fun `returns true for a matching pair`() {
        assertTrue(solution.isValid("()"))
    }

    @Test
    fun `returns true for adjacent matching bracket pairs`() {
        assertTrue(solution.isValid("()[]{}"))
    }

    @Test
    fun `returns false for brackets of different types`() {
        assertFalse(solution.isValid("(]"))
    }

    @Test
    fun `returns true for nested brackets`() {
        assertTrue(solution.isValid("([])"))
    }

    @Test
    fun `returns false when nested brackets close in the wrong order`() {
        assertFalse(solution.isValid("([)]"))
    }

    @Test
    fun `returns false for a closing bracket without an opening bracket`() {
        assertFalse(solution.isValid(")"))
    }

    @Test
    fun `returns false for an unclosed opening bracket`() {
        assertFalse(solution.isValid("["))
    }

    @Test
    fun `returns true for the smallest valid input`() {
        assertTrue(solution.isValid("{}"))
    }
}
