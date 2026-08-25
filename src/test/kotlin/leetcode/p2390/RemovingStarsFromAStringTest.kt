package leetcode.p2390

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemovingStarsFromAStringTest {
    private val solution = Solution()

    @Test
    fun `removes stars and their preceding characters for the first example`() {
        assertEquals("lecoe", solution.removeStars("leet**cod*e"))
    }

    @Test
    fun `returns empty string when all characters are removed for the second example`() {
        assertEquals("", solution.removeStars("erase*****"))
    }

    @Test
    fun `leaves single character string without stars unchanged`() {
        assertEquals("a", solution.removeStars("a"))
    }

    @Test
    fun `returns empty string for single character followed by single star`() {
        assertEquals("", solution.removeStars("a*"))
    }

    @Test
    fun `leaves string unchanged when it contains no stars`() {
        assertEquals("abcde", solution.removeStars("abcde"))
    }

    @Test
    fun `handles alternating characters and stars`() {
        assertEquals("", solution.removeStars("a*b*c*"))
    }

    @Test
    fun `removes character when star is at the very end`() {
        assertEquals("ab", solution.removeStars("abc*"))
    }

    @Test
    fun `handles consecutive stars clearing earlier characters before continuing`() {
        assertEquals("d", solution.removeStars("abc***d"))
    }

    @Test
    fun `handles interleaved multiple stars`() {
        assertEquals("ce", solution.removeStars("ab**cd*e"))
    }
}
