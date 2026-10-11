package leetcode.p0290

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class WordPatternTest {
    private val solution = Solution()

    @Test
    fun `returns true for the first example`() {
        assertTrue(solution.wordPattern("abba", "dog cat cat dog"))
    }

    @Test
    fun `returns false for the second example when a letter maps to different words`() {
        assertFalse(solution.wordPattern("abba", "dog cat cat fish"))
    }

    @Test
    fun `returns false for the third example when different letters share a word`() {
        assertFalse(solution.wordPattern("aaaa", "dog cat cat dog"))
    }

    @Test
    fun `returns false when different letters would map to the same word`() {
        assertFalse(solution.wordPattern("ab", "cat cat"))
    }

    @Test
    fun `returns false when there are fewer words than pattern letters`() {
        assertFalse(solution.wordPattern("abba", "dog cat dog"))
    }

    @Test
    fun `returns false when there are more words than pattern letters`() {
        assertFalse(solution.wordPattern("ab", "dog cat bird"))
    }

    @Test
    fun `handles a pattern and sentence at their maximum lengths`() {
        val pattern = "a".repeat(300)
        val sentence = List(300) { "word" }.joinToString(" ")

        assertTrue(solution.wordPattern(pattern, sentence))
    }
}