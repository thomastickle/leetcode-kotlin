package leetcode.p0345

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReverseVowelsOfAStringTest {
    private val solution = Solution()

    @Test
    fun `reverses vowels while preserving their case`() {
        assertEquals("AceCreIm", solution.reverseVowels("IceCreAm"))
    }

    @Test
    fun `reverses repeated lowercase vowels`() {
        assertEquals("leotcede", solution.reverseVowels("leetcode"))
    }
}
