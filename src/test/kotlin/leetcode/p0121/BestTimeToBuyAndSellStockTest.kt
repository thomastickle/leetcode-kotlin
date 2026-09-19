package leetcode.p0121

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockTest {
    private val solution = Solution()

    @Test
    fun `finds max profit in the first example`() {
        assertEquals(5, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    @Test
    fun `returns zero when prices strictly decrease`() {
        assertEquals(0, solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    @Test
    fun `returns zero for a single-day price array`() {
        assertEquals(0, solution.maxProfit(intArrayOf(10)))
    }

    @Test
    fun `finds profit when optimal buy is not the global minimum if it occurs after sell`() {
        assertEquals(4, solution.maxProfit(intArrayOf(3, 7, 1, 2)))
    }

    @Test
    fun `finds max profit when prices strictly increase`() {
        assertEquals(4, solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `returns zero when all prices are identical`() {
        assertEquals(0, solution.maxProfit(intArrayOf(3, 3, 3, 3)))
    }
}
