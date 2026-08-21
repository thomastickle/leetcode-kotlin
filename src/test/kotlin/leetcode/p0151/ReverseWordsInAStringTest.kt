package leetcode.p0151

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseWordsInAStringTest {
    private val solution = Solution()

    @Test
    fun `reverses the order of words`() {
        assertEquals("blue is sky the", solution.reverseWords("the sky is blue"))
    }

    @Test
    fun `removes leading and trailing spaces`() {
        assertEquals("world hello", solution.reverseWords("  hello world  "))
    }

    @Test
    fun `reduces multiple spaces between words to one`() {
        assertEquals("example good a", solution.reverseWords("a good   example"))
    }
}
