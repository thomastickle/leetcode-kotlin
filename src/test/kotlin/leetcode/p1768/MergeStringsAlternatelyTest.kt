package leetcode.p1768

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeStringsAlternatelyTest {
    private val solution = Solution()

    @Test
    fun `merges words with equal lengths`() {
        assertEquals("apbqcr", solution.mergeAlternately("abc", "pqr"))
    }

    @Test
    fun `appends the remainder when the second word is longer`() {
        assertEquals("apbqrs", solution.mergeAlternately("ab", "pqrs"))
    }

    @Test
    fun `appends the remainder when the first word is longer`() {
        assertEquals("apbqcd", solution.mergeAlternately("abcd", "pq"))
    }
}
