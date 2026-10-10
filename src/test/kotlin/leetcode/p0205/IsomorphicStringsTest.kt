package leetcode.p0205

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsomorphicStringsTest {
    private val solution = Solution()

    @Test
    fun `returns true for the first example`() {
        assertTrue(solution.isIsomorphic("egg", "add"))
    }

    @Test
    fun `returns false for the second example when one character maps inconsistently`() {
        assertFalse(solution.isIsomorphic("f11", "b23"))
    }

    @Test
    fun `returns true for the third example`() {
        assertTrue(solution.isIsomorphic("paper", "title"))
    }

    @Test
    fun `returns false when distinct characters would map to the same character`() {
        assertFalse(solution.isIsomorphic("ab", "cc"))
    }

    @Test
    fun `allows a character to map to itself`() {
        assertTrue(solution.isIsomorphic("a", "a"))
    }

    @Test
    fun `handles strings at the maximum length`() {
        val s = "a".repeat(50_000)
        val t = "b".repeat(50_000)

        assertTrue(solution.isIsomorphic(s, t))
    }
}