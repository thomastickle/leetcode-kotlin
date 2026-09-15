package leetcode.p0714

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BestTimeToBuyAndSellStockWithTransactionFeeTest {
    private val solution = Solution()

    @Test
    fun `returns eight for the first example`() {
        assertEquals(8, solution.maxProfit(intArrayOf(1, 3, 2, 8, 4, 9), 2))
    }

    @Test
    fun `returns six for the second example`() {
        assertEquals(6, solution.maxProfit(intArrayOf(1, 3, 7, 5, 10, 3), 3))
    }

    @Test
    fun `returns zero when there is only one price`() {
        assertEquals(0, solution.maxProfit(intArrayOf(5), 2))
    }

    @Test
    fun `returns zero when prices never increase enough to cover the fee`() {
        assertEquals(0, solution.maxProfit(intArrayOf(1, 2, 3, 4), 3))
    }

    @Test
    fun `returns zero for declining prices`() {
        assertEquals(0, solution.maxProfit(intArrayOf(9, 7, 5, 3, 1), 0))
    }

    @Test
    fun `supports multiple profitable transactions with no fee`() {
        assertEquals(8, solution.maxProfit(intArrayOf(1, 5, 2, 6), 0))
    }
}
