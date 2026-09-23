package leetcode.p0014

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonPrefixTest {
    private val solution = Solution()

    @Test
    fun `finds common prefix for example 1`() {
        assertEquals(
            "fl",
            solution.longestCommonPrefix(arrayOf("flower", "flow", "flight")),
        )
    }

    @Test
    fun `returns empty string when no common prefix exists in example 2`() {
        assertEquals(
            "",
            solution.longestCommonPrefix(arrayOf("dog", "racecar", "car")),
        )
    }

    @Test
    fun `returns entire string for single string input`() {
        assertEquals(
            "flower",
            solution.longestCommonPrefix(arrayOf("flower")),
        )
    }

    @Test
    fun `returns empty string for single empty string input`() {
        assertEquals(
            "",
            solution.longestCommonPrefix(arrayOf("")),
        )
    }

    @Test
    fun `returns empty string when array contains an empty string`() {
        assertEquals(
            "",
            solution.longestCommonPrefix(arrayOf("", "b")),
        )
    }

    @Test
    fun `returns entire string when all elements are identical`() {
        assertEquals(
            "interstellar",
            solution.longestCommonPrefix(arrayOf("interstellar", "interstellar", "interstellar")),
        )
    }

    @Test
    fun `handles shortest string being the common prefix`() {
        assertEquals(
            "inter",
            solution.longestCommonPrefix(arrayOf("interspecies", "interstellar", "inter")),
        )
    }

    @Test
    fun `returns empty string when first characters differ`() {
        assertEquals(
            "",
            solution.longestCommonPrefix(arrayOf("a", "b", "c")),
        )
    }

    @Test
    fun `finds single character common prefix`() {
        assertEquals(
            "c",
            solution.longestCommonPrefix(arrayOf("cir", "car")),
        )
    }
}
