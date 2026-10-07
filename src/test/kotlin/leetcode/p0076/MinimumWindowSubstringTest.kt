package leetcode.p0076

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumWindowSubstringTest {
    private val solution = Solution()

    @Test
    fun `finds minimum window for example 1`() {
        assertEquals(
            "BANC",
            solution.minWindow("ADOBECODEBANC", "ABC"),
        )
    }

    @Test
    fun `finds single character window for example 2`() {
        assertEquals(
            "a",
            solution.minWindow("a", "a"),
        )
    }

    @Test
    fun `returns empty string when character counts cannot be satisfied for example 3`() {
        assertEquals(
            "",
            solution.minWindow("a", "aa"),
        )
    }

    @Test
    fun `returns empty string when no characters match`() {
        assertEquals(
            "",
            solution.minWindow("a", "b"),
        )
    }

    @Test
    fun `returns empty string when s is shorter than t`() {
        assertEquals(
            "",
            solution.minWindow("ab", "abc"),
        )
    }

    @Test
    fun `returns exact matching substring when s equals t`() {
        assertEquals(
            "abc",
            solution.minWindow("abc", "abc"),
        )
    }

    @Test
    fun `handles multiple duplicate occurrences to find minimal window`() {
        assertEquals(
            "ba",
            solution.minWindow("bba", "ab"),
        )
    }

    @Test
    fun `finds window at start of string`() {
        assertEquals(
            "abc",
            solution.minWindow("abcdef", "cba"),
        )
    }

    @Test
    fun `finds window at end of string`() {
        assertEquals(
            "cba",
            solution.minWindow("defcba", "abc"),
        )
    }

    @Test
    fun `distinguishes uppercase and lowercase characters`() {
        assertEquals(
            "aA",
            solution.minWindow("baAbB", "Aa"),
        )
    }

    @Test
    fun `handles duplicate required characters in pattern`() {
        assertEquals(
            "aa",
            solution.minWindow("baa", "aa"),
        )
    }

    @Test
    fun `finds exact matching window with duplicate required characters`() {
        assertEquals(
            "aa",
            solution.minWindow("aa", "aa"),
        )
    }

    @Test
    fun `finds shortest window with repeated required character`() {
        assertEquals(
            "AAC",
            solution.minWindow("ABAAC", "AAC"),
        )
    }
}
