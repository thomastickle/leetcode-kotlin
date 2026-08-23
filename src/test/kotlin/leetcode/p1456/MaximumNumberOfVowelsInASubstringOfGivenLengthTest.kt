package leetcode.p1456

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumNumberOfVowelsInASubstringOfGivenLengthTest {
    private val solution = Solution()

    @Test
    fun `returns three for the first example`() {
        assertEquals(3, solution.maxVowels("abciiidef", 3))
    }

    @Test
    fun `returns two for the second example`() {
        assertEquals(2, solution.maxVowels("aeiou", 2))
    }

    @Test
    fun `returns two for the third example`() {
        assertEquals(2, solution.maxVowels("leetcode", 3))
    }

    @Test
    fun `returns zero when the string has no vowels`() {
        assertEquals(0, solution.maxVowels("rhythms", 3))
    }

    @Test
    fun `counts a single vowel when k is one`() {
        assertEquals(1, solution.maxVowels("abcde", 1))
    }

    @Test
    fun `considers the entire string when k equals its length`() {
        assertEquals(5, solution.maxVowels("education", 9))
    }

    @Test
    fun `finds a vowel after the initial window`() {
        assertEquals(1, solution.maxVowels("tryhard", 4))
    }

    @Test
    fun `returns the window length when every character is a vowel`() {
        assertEquals(5, solution.maxVowels("aeiou", 5))
    }
}
