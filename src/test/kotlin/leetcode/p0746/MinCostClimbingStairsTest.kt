package leetcode.p0746

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinCostClimbingStairsTest {
    private val solution = Solution()

    @Test
    fun `returns fifteen for the first example`() {
        assertEquals(15, solution.minCostClimbingStairs(intArrayOf(10, 15, 20)))
    }

    @Test
    fun `returns six for the second example`() {
        assertEquals(
            6,
            solution.minCostClimbingStairs(intArrayOf(1, 100, 1, 1, 1, 100, 1, 1, 100, 1)),
        )
    }

    @Test
    fun `returns zero when every stair is free`() {
        assertEquals(0, solution.minCostClimbingStairs(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `chooses two inexpensive stairs over an expensive intermediate stair`() {
        assertEquals(2, solution.minCostClimbingStairs(intArrayOf(1, 100, 1)))
    }

    @Test
    fun `handles the minimum number of stairs`() {
        assertEquals(999, solution.minCostClimbingStairs(intArrayOf(999, 999)))
    }

    @Test
    fun `can start from the second stair`() {
        assertEquals(1, solution.minCostClimbingStairs(intArrayOf(100, 1, 100)))
    }
}
