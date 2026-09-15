package leetcode.p1143

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestCommonSubsequenceTest {
    private val solution = Solution()

    @Test
    fun `returns three for the first example`() {
        assertEquals(3, solution.longestCommonSubsequence("abcde", "ace"))
    }

    @Test
    fun `returns three for identical strings`() {
        assertEquals(3, solution.longestCommonSubsequence("abc", "abc"))
    }

    @Test
    fun `returns zero when the strings have no common characters`() {
        assertEquals(0, solution.longestCommonSubsequence("abc", "def"))
    }

    @Test
    fun `preserves character order when choosing a subsequence`() {
        assertEquals(2, solution.longestCommonSubsequence("abc", "bac"))
    }

    @Test
    fun `handles a single matching character`() {
        assertEquals(1, solution.longestCommonSubsequence("a", "a"))
    }

    @Test
    fun `counts a repeated character at most as often as it appears in both strings`() {
        assertEquals(3, solution.longestCommonSubsequence("aaaa", "aaa"))
    }
}
