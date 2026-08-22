package leetcode.p0392

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IsSubsequenceTest {
    private val solution = Solution()

    @Test
    fun `returns true when characters appear in order with gaps`() {
        assertTrue(solution.isSubsequence("abc", "ahbgdc"))
    }

    @Test
    fun `returns false when characters do not appear in order`() {
        assertFalse(solution.isSubsequence("axc", "ahbgdc"))
    }

    @Test
    fun `returns true for an empty subsequence`() {
        assertTrue(solution.isSubsequence("", "ahbgdc"))
    }

    @Test
    fun `returns false for a non-empty subsequence and an empty source`() {
        assertFalse(solution.isSubsequence("a", ""))
    }

    @Test
    fun `returns true when both strings are identical`() {
        assertTrue(solution.isSubsequence("abc", "abc"))
    }

    @Test
    fun `does not reuse a character from the source`() {
        assertFalse(solution.isSubsequence("aaa", "aa"))
    }
}
