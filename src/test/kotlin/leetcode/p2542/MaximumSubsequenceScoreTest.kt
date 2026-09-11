package leetcode.p2542

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumSubsequenceScoreTest {
    private val solution = Solution()

    @Test
    fun `returns the maximum score for the first example`() {
        assertEquals(
            12L,
            solution.maxScore(intArrayOf(1, 3, 3, 2), intArrayOf(2, 1, 3, 4), 3)
        )
    }

    @Test
    fun `returns the maximum score for the second example`() {
        assertEquals(
            30L,
            solution.maxScore(intArrayOf(4, 2, 3, 1, 1), intArrayOf(7, 5, 10, 9, 6), 1)
        )
    }

    @Test
    fun `chooses the best single index when k is one`() {
        assertEquals(
            40L,
            solution.maxScore(intArrayOf(10, 4, 8), intArrayOf(2, 10, 5), 1)
        )
    }

    @Test
    fun `uses every index when k equals the array length`() {
        assertEquals(
            12L,
            solution.maxScore(intArrayOf(1, 2, 3), intArrayOf(5, 4, 2), 3)
        )
    }

    @Test
    fun `returns zero when all possible scores contain a zero value`() {
        assertEquals(
            0L,
            solution.maxScore(intArrayOf(0, 0, 0), intArrayOf(1, 2, 3), 2)
        )
    }

    @Test
    fun `selects indices with the best combined sum and minimum`() {
        assertEquals(
            27L,
            solution.maxScore(intArrayOf(5, 1, 4, 3), intArrayOf(3, 2, 3, 1), 2)
        )
    }
}
