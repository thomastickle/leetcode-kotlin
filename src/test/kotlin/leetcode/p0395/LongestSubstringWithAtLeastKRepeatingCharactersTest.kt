package leetcode.p0395

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubstringWithAtLeastKRepeatingCharactersTest {
    private val solution = Solution()

    @Test
    fun `returns length for the first example`() {
        assertEquals(3, solution.longestSubstring("aaabb", 3))
    }

    @Test
    fun `returns length for the second example`() {
        assertEquals(5, solution.longestSubstring("ababbc", 2))
    }

    @Test
    fun `returns string length when single character satisfies k`() {
        assertEquals(1, solution.longestSubstring("a", 1))
    }

    @Test
    fun `returns zero when string length is less than k`() {
        assertEquals(0, solution.longestSubstring("ab", 3))
    }

    @Test
    fun `returns full length when all characters meet minimum frequency`() {
        assertEquals(6, solution.longestSubstring("aaabbb", 3))
    }

    @Test
    fun `returns zero when no character meets minimum frequency`() {
        assertEquals(0, solution.longestSubstring("abcdef", 2))
    }

    @Test
    fun `finds isolated valid substring separated by infrequent characters`() {
        assertEquals(3, solution.longestSubstring("bbaaacbd", 3))
    }

    @Test
    fun `returns zero when nested splits eliminate all candidates`() {
        assertEquals(0, solution.longestSubstring("ababacb", 3))
    }

    @Test
    fun `returns full length for uniform string with count exceeding k`() {
        assertEquals(5, solution.longestSubstring("aaaaa", 2))
    }
}
