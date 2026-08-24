package leetcode.p1657

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DetermineIfTwoStringsAreCloseTest {
    private val solution = Solution()

    @Test
    fun `returns true for the first example`() {
        assertTrue(solution.closeStrings("abc", "bca"))
    }

    @Test
    fun `returns false for strings of different lengths from the second example`() {
        assertFalse(solution.closeStrings("a", "aa"))
    }

    @Test
    fun `returns true for the third example with multiple operations`() {
        assertTrue(solution.closeStrings("cabbba", "abbccc"))
    }

    @Test
    fun `returns true for identical strings`() {
        assertTrue(solution.closeStrings("abcdef", "abcdef"))
    }

    @Test
    fun `returns true for single identical characters`() {
        assertTrue(solution.closeStrings("a", "a"))
    }

    @Test
    fun `returns false for single distinct characters`() {
        assertFalse(solution.closeStrings("a", "b"))
    }

    @Test
    fun `returns false when character sets differ even if frequency counts match`() {
        assertFalse(solution.closeStrings("aab", "bcc"))
    }

    @Test
    fun `returns false when character sets match but frequency distributions differ`() {
        assertFalse(solution.closeStrings("aabbccc", "abbbccc"))
    }

    @Test
    fun `returns true for frequency reassignments across three characters`() {
        assertTrue(solution.closeStrings("aaabbbbcc", "aabbbcccc"))
    }
}
