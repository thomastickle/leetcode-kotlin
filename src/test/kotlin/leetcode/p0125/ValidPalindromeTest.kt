package leetcode.p0125

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidPalindromeTest {
    private val solution = Solution()

    @Test
    fun `returns true for a palindrome with spaces punctuation and mixed case`() {
        assertTrue(solution.isPalindrome("A man, a plan, a canal: Panama"))
    }

    @Test
    fun `returns false when normalized text is not a palindrome`() {
        assertFalse(solution.isPalindrome("race a car"))
    }

    @Test
    fun `returns true when all characters are removed`() {
        assertTrue(solution.isPalindrome(" "))
    }

    @Test
    fun `returns true for punctuation only input`() {
        assertTrue(solution.isPalindrome(".,!"))
    }

    @Test
    fun `returns true for a single alphanumeric character`() {
        assertTrue(solution.isPalindrome("Z"))
    }

    @Test
    fun `compares digits as alphanumeric characters`() {
        assertFalse(solution.isPalindrome("0P"))
    }
}