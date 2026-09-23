package leetcode.p0058

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LengthOfLastWordTest {
    private val solution = Solution()

    @Test
    fun `calculates length of last word for example 1 (simple two words)`() {
        assertEquals(5, solution.lengthOfLastWord("Hello World"))
    }

    @Test
    fun `calculates length of last word for example 2 (leading, multiple intermediate, and trailing spaces)`() {
        assertEquals(4, solution.lengthOfLastWord("   fly me   to   the moon  "))
    }

    @Test
    fun `calculates length of last word for example 3 (multiple words)`() {
        assertEquals(6, solution.lengthOfLastWord("luffy is still joyboy"))
    }

    @Test
    fun `handles single character without spaces (minimum length)`() {
        assertEquals(1, solution.lengthOfLastWord("a"))
    }

    @Test
    fun `handles single character surrounded by spaces`() {
        assertEquals(1, solution.lengthOfLastWord("   z   "))
    }

    @Test
    fun `handles single word without any spaces`() {
        assertEquals(5, solution.lengthOfLastWord("hello"))
    }

    @Test
    fun `handles sentence ending with single character word and trailing spaces`() {
        assertEquals(1, solution.lengthOfLastWord("Today is a "))
    }

    @Test
    fun `handles long single word`() {
        assertEquals(34, solution.lengthOfLastWord("supercalifragilisticexpialidocious"))
    }
}
