package leetcode.p0933

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfRecentCallsTest {
    @Test
    fun `returns correct counts for the example sequence`() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1))
        assertEquals(2, counter.ping(100))
        assertEquals(3, counter.ping(3001))
        assertEquals(3, counter.ping(3002))
    }

    @Test
    fun `returns one for a single initial ping`() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1))
    }

    @Test
    fun `retains request made exactly 3000 milliseconds earlier`() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1))
        assertEquals(2, counter.ping(3001))
    }

    @Test
    fun `evicts request made more than 3000 milliseconds earlier`() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1))
        assertEquals(1, counter.ping(3002))
    }

    @Test
    fun `evicts all earlier requests when time jump exceeds 3000 milliseconds`() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1))
        assertEquals(2, counter.ping(2))
        assertEquals(3, counter.ping(3))
        assertEquals(1, counter.ping(10_000))
    }

    @Test
    fun `accumulates multiple requests within the sliding window`() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(10))
        assertEquals(2, counter.ping(20))
        assertEquals(3, counter.ping(30))
        assertEquals(4, counter.ping(40))
    }

    @Test
    fun `handles timestamp at upper constraint limit`() {
        val counter = RecentCounter()
        assertEquals(1, counter.ping(1_000_000_000))
    }

    @Test
    fun `distinct instances maintain independent request histories`() {
        val counter1 = RecentCounter()
        val counter2 = RecentCounter()
        assertEquals(1, counter1.ping(100))
        assertEquals(1, counter2.ping(100))
        assertEquals(2, counter1.ping(200))
        assertEquals(2, counter2.ping(300))
    }
}
