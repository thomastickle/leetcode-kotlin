package leetcode.p0875

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KokoEatingBananasTest {
    private val solution = Solution()

    @Test
    fun `finds minimum speed for first example`() {
        assertEquals(4, solution.minEatingSpeed(intArrayOf(3, 6, 7, 11), 8))
    }

    @Test
    fun `finds minimum speed when hours equals number of piles`() {
        assertEquals(30, solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 5))
    }

    @Test
    fun `finds minimum speed for third example`() {
        assertEquals(23, solution.minEatingSpeed(intArrayOf(30, 11, 23, 4, 20), 6))
    }

    @Test
    fun `handles single pile divided across multiple hours`() {
        assertEquals(5, solution.minEatingSpeed(intArrayOf(10), 2))
        assertEquals(4, solution.minEatingSpeed(intArrayOf(10), 3))
    }

    @Test
    fun `returns minimum speed of one when generous time is provided`() {
        assertEquals(1, solution.minEatingSpeed(intArrayOf(1, 1, 1), 10))
    }

    @Test
    fun `handles large pile values at upper constraints`() {
        assertEquals(
            1_000_000_000,
            solution.minEatingSpeed(intArrayOf(1_000_000_000, 1_000_000_000), 2),
        )
    }

    @Test
    fun `handles single large pile with large hour limit`() {
        assertEquals(
            1,
            solution.minEatingSpeed(intArrayOf(1_000_000_000), 1_000_000_000),
        )
    }
}
