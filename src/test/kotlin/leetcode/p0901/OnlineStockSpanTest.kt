package leetcode.p0901

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class OnlineStockSpanTest {
    @Test
    fun `returns spans for the example sequence`() {
        val stockSpanner = StockSpanner()

        assertEquals(1, stockSpanner.next(100))
        assertEquals(1, stockSpanner.next(80))
        assertEquals(1, stockSpanner.next(60))
        assertEquals(2, stockSpanner.next(70))
        assertEquals(1, stockSpanner.next(60))
        assertEquals(4, stockSpanner.next(75))
        assertEquals(6, stockSpanner.next(85))
    }

    @Test
    fun `returns one for each day in a strictly decreasing sequence`() {
        val stockSpanner = StockSpanner()

        assertEquals(1, stockSpanner.next(100))
        assertEquals(1, stockSpanner.next(90))
        assertEquals(1, stockSpanner.next(80))
        assertEquals(1, stockSpanner.next(70))
    }

    @Test
    fun `returns the full history span for a nondecreasing sequence`() {
        val stockSpanner = StockSpanner()

        assertEquals(1, stockSpanner.next(10))
        assertEquals(2, stockSpanner.next(20))
        assertEquals(3, stockSpanner.next(20))
        assertEquals(4, stockSpanner.next(30))
    }

    @Test
    fun `includes consecutive prices equal to today's price`() {
        val stockSpanner = StockSpanner()

        assertEquals(1, stockSpanner.next(50))
        assertEquals(2, stockSpanner.next(50))
        assertEquals(3, stockSpanner.next(50))
        assertEquals(4, stockSpanner.next(60))
    }

    @Test
    fun `handles a single price at the upper constraint limit`() {
        val stockSpanner = StockSpanner()

        assertEquals(1, stockSpanner.next(100_000))
    }

    @Test
    fun `keeps histories independent across spanners`() {
        val first = StockSpanner()
        val second = StockSpanner()

        assertEquals(1, first.next(100))
        assertEquals(1, second.next(90))
        assertEquals(1, first.next(80))
        assertEquals(2, second.next(90))
    }
}
