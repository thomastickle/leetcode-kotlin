package leetcode.p0003

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubstringWithoutRepeatingCharactersTest {
    private val solution = Solution()

    @Test
    fun `returns three for the first example`() {
        assertEquals(3, solution.lengthOfLongestSubstring("abcabcbb"))
    }

    @Test
    fun `returns one for the second example`() {
        assertEquals(1, solution.lengthOfLongestSubstring("bbbbb"))
    }

    @Test
    fun `returns three for the third example`() {
        assertEquals(3, solution.lengthOfLongestSubstring("pwwkew"))
    }

    @Test
    fun `returns zero for an empty string`() {
        assertEquals(0, solution.lengthOfLongestSubstring(""))
    }

    @Test
    fun `returns one for a single character`() {
        assertEquals(1, solution.lengthOfLongestSubstring("a"))
    }

    @Test
    fun `returns one when two identical characters are repeated`() {
        assertEquals(1, solution.lengthOfLongestSubstring("aa"))
    }

    @Test
    fun `returns two for a repeated sequence with a middle pair`() {
        assertEquals(2, solution.lengthOfLongestSubstring("abba"))
    }

    @Test
    fun `counts spaces and symbols as characters`() {
        assertEquals(4, solution.lengthOfLongestSubstring("a b!a"))
    }

    @Test
    fun `finds the longest substring after a repeated character`() {
        assertEquals(3, solution.lengthOfLongestSubstring("dvdf"))
    }
}
