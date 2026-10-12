package leetcode.p0049

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GroupAnagramsTest {
    private val solution = Solution()

    @Test
    fun `groups anagrams for the first example`() {
        assertGroups(
            listOf(listOf("ate", "eat", "tea"), listOf("bat"), listOf("nat", "tan")),
            solution.groupAnagrams(arrayOf("eat", "tea", "tan", "ate", "nat", "bat")),
        )
    }

    @Test
    fun `groups a single empty string for the second example`() {
        assertGroups(
            listOf(listOf("")),
            solution.groupAnagrams(arrayOf("")),
        )
    }

    @Test
    fun `groups a single letter for the third example`() {
        assertGroups(
            listOf(listOf("a")),
            solution.groupAnagrams(arrayOf("a")),
        )
    }

    @Test
    fun `keeps empty strings and repeated strings in their anagram group`() {
        assertGroups(
            listOf(listOf("", ""), listOf("ab", "ba"), listOf("c")),
            solution.groupAnagrams(arrayOf("", "ab", "", "ba", "c")),
        )
    }

    @Test
    fun `handles the maximum number and length of input strings`() {
        val word = "a".repeat(100)
        val input = Array(10_000) { word }

        assertGroups(
            listOf(List(10_000) { word }),
            solution.groupAnagrams(input),
        )
    }

    private fun assertGroups(expected: List<List<String>>, actual: List<List<String>>) {
        assertEquals(normalize(expected), normalize(actual))
    }

    private fun normalize(groups: List<List<String>>): List<List<String>> =
        groups.map { it.sorted() }.sortedBy { it.first() }
}
