package leetcode.p1207

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class UniqueNumberOfOccurrencesTest {
    private val solution = Solution()

    @Test
    fun `returns true for the first example`() {
        assertTrue(solution.uniqueOccurrences(intArrayOf(1, 2, 2, 1, 1, 3)))
    }

    @Test
    fun `returns false for the second example`() {
        assertFalse(solution.uniqueOccurrences(intArrayOf(1, 2)))
    }

    @Test
    fun `returns true for the third example with negative numbers`() {
        assertTrue(solution.uniqueOccurrences(intArrayOf(-3, 0, 1, -3, 1, 1, 1, -3, 10, 0)))
    }

    @Test
    fun `returns true for a single element array`() {
        assertTrue(solution.uniqueOccurrences(intArrayOf(42)))
    }

    @Test
    fun `returns true when all elements are identical`() {
        assertTrue(solution.uniqueOccurrences(intArrayOf(7, 7, 7, 7)))
    }

    @Test
    fun `returns false when multiple elements have identical frequency`() {
        assertFalse(solution.uniqueOccurrences(intArrayOf(1, 1, 2, 2, 3, 3)))
    }

    @Test
    fun `returns true for values at constraint extremes`() {
        assertTrue(solution.uniqueOccurrences(intArrayOf(-1000, -1000, 0, 1000, 1000, 1000)))
    }

    @Test
    fun `returns false when some frequencies collide among several elements`() {
        assertFalse(solution.uniqueOccurrences(intArrayOf(1, 1, 1, 2, 2, 3, 3, 4)))
    }
}
