package leetcode.p0383

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class RansomNoteTest {
    private val solution = Solution()

    @Test
    fun `returns false when the magazine does not contain the required letter`() {
        assertFalse(solution.canConstruct("a", "b"))
    }

    @Test
    fun `returns false when the magazine has too few copies of a letter`() {
        assertFalse(solution.canConstruct("aa", "ab"))
    }

    @Test
    fun `returns true when the magazine contains all required letter copies`() {
        assertTrue(solution.canConstruct("aa", "aab"))
    }

    @Test
    fun `returns true when required letters are available in any order`() {
        assertTrue(solution.canConstruct("abc", "cbad"))
    }

    @Test
    fun `handles minimum length strings`() {
        assertTrue(solution.canConstruct("a", "a"))
    }

    @Test
    fun `handles maximum length strings`() {
        val ransomNote = "a".repeat(100_000)
        val magazine = "a".repeat(100_000)

        assertTrue(solution.canConstruct(ransomNote, magazine))
    }
}