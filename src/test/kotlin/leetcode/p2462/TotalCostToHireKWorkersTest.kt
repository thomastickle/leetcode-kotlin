package leetcode.p2462

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TotalCostToHireKWorkersTest {
    private val solution = Solution()

    @Test
    fun `returns the total cost for the first example`() {
        assertEquals(
            11L,
            solution.totalCost(intArrayOf(17, 12, 10, 2, 7, 2, 11, 20, 8), 3, 4)
        )
    }

    @Test
    fun `returns the total cost for the second example`() {
        assertEquals(
            4L,
            solution.totalCost(intArrayOf(1, 2, 4, 1), 3, 3)
        )
    }

    @Test
    fun `returns the only worker cost for a single-worker input`() {
        assertEquals(
            5L,
            solution.totalCost(intArrayOf(5), 1, 1)
        )
    }

    @Test
    fun `chooses the cheapest worker from both ends when candidates is one`() {
        assertEquals(
            14L,
            solution.totalCost(intArrayOf(10, 1, 2, 9, 3), 3, 1)
        )
    }

    @Test
    fun `uses the smallest index to break equal-cost choices`() {
        assertEquals(
            6L,
            solution.totalCost(intArrayOf(2, 2, 2, 2), 3, 1)
        )
    }

    @Test
    fun `considers all remaining workers when candidate windows overlap`() {
        assertEquals(
            10L,
            solution.totalCost(intArrayOf(5, 1, 4), 3, 2)
        )
    }

    @Test
    fun `returns the sum of all workers when k equals the array length`() {
        assertEquals(
            15L,
            solution.totalCost(intArrayOf(5, 1, 4, 2, 3), 5, 1)
        )
    }
}
