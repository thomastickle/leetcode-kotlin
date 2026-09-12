package leetcode.p0017

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LetterCombinationsOfAPhoneNumberTest {
    private val solution = Solution()

    @Test
    fun `returns all combinations for the first example`() {
        assertEquals(
            setOf("ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"),
            solution.letterCombinations("23").toSet(),
        )
    }

    @Test
    fun `returns the three letters for a single two digit`() {
        assertEquals(setOf("a", "b", "c"), solution.letterCombinations("2").toSet())
    }

    @Test
    fun `includes four letters for digits seven and nine`() {
        assertEquals(setOf("p", "q", "r", "s"), solution.letterCombinations("7").toSet())
        assertEquals(setOf("w", "x", "y", "z"), solution.letterCombinations("9").toSet())
    }

    @Test
    fun `supports the maximum four digit input length`() {
        assertEquals(81, solution.letterCombinations("2345").size)
    }
}
