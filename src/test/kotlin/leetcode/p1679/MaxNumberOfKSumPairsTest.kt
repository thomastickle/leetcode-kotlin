package leetcode.p1679

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaxNumberOfKSumPairsTest {
    private val solution = Solution()

    @Test
    fun `returns two operations for the first example`() {
        assertEquals(2, solution.maxOperations(intArrayOf(1, 2, 3, 4), 5))
    }

    @Test
    fun `returns one operation for the second example`() {
        assertEquals(1, solution.maxOperations(intArrayOf(3, 1, 3, 4, 3), 6))
    }

    @Test
    fun `returns zero for a single number`() {
        assertEquals(0, solution.maxOperations(intArrayOf(1), 1))
    }

    @Test
    fun `returns zero when no pair sums to k`() {
        assertEquals(0, solution.maxOperations(intArrayOf(1, 2, 3), 10))
    }

    @Test
    fun `pairs equal values without reusing an element`() {
        assertEquals(2, solution.maxOperations(intArrayOf(2, 2, 2, 2, 2), 4))
    }

    @Test
    fun `uses each duplicate in at most one operation`() {
        assertEquals(2, solution.maxOperations(intArrayOf(1, 1, 1, 4, 4), 5))
    }

    @Test
    fun `counts pairs formed from several distinct values`() {
        assertEquals(3, solution.maxOperations(intArrayOf(1, 2, 2, 3, 3, 4), 5))
    }

    @Test
    fun `supports values at the upper constraint`() {
        assertEquals(
            1,
            solution.maxOperations(intArrayOf(1, 999_999_999, 1_000_000_000), 1_000_000_000),
        )
    }
}
