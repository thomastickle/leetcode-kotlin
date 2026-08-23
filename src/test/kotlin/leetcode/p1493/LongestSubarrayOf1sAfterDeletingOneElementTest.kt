package leetcode.p1493

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestSubarrayOf1sAfterDeletingOneElementTest {
    private val solution = Solution()

    @Test
    fun `returns three for the first example`() {
        assertEquals(3, solution.longestSubarray(intArrayOf(1, 1, 0, 1)))
    }

    @Test
    fun `returns five for the second example`() {
        assertEquals(5, solution.longestSubarray(intArrayOf(0, 1, 1, 1, 0, 1, 1, 0, 1)))
    }

    @Test
    fun `returns array length minus one when array contains only ones`() {
        assertEquals(2, solution.longestSubarray(intArrayOf(1, 1, 1)))
    }

    @Test
    fun `returns zero for a single zero`() {
        assertEquals(0, solution.longestSubarray(intArrayOf(0)))
    }

    @Test
    fun `returns zero for a single one`() {
        assertEquals(0, solution.longestSubarray(intArrayOf(1)))
    }

    @Test
    fun `returns zero when array contains only zeros`() {
        assertEquals(0, solution.longestSubarray(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `returns one for a pair containing a single one`() {
        assertEquals(1, solution.longestSubarray(intArrayOf(1, 0)))
    }

    @Test
    fun `bridges adjacent runs separated by a single zero`() {
        assertEquals(7, solution.longestSubarray(intArrayOf(1, 1, 1, 0, 1, 1, 1, 1)))
    }

    @Test
    fun `does not bridge runs separated by multiple zeros`() {
        assertEquals(3, solution.longestSubarray(intArrayOf(1, 1, 0, 0, 1, 1, 1)))
    }
}
