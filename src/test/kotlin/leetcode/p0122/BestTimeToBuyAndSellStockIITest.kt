package leetcode.p0122

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockIITest {
    private val solution = Solution()

    @Test
    fun `finds max profit with multiple buy and sell transactions in example 1`() {
        assertEquals(7, solution.maxProfit(intArrayOf(7, 1, 5, 3, 6, 4)))
    }

    @Test
    fun `finds max profit when prices are strictly increasing in example 2`() {
        assertEquals(4, solution.maxProfit(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `returns zero when prices are strictly decreasing in example 3`() {
        assertEquals(0, solution.maxProfit(intArrayOf(7, 6, 4, 3, 1)))
    }

    @Test
    fun `returns zero for a single-day price array`() {
        assertEquals(0, solution.maxProfit(intArrayOf(10)))
    }

    @Test
    fun `returns zero when all prices are identical`() {
        assertEquals(0, solution.maxProfit(intArrayOf(3, 3, 3, 3)))
    }

    @Test
    fun `accumulates profit across multiple non-consecutive dips and peaks`() {
        assertEquals(13, solution.maxProfit(intArrayOf(1, 3, 2, 8, 4, 9)))
    }
}
