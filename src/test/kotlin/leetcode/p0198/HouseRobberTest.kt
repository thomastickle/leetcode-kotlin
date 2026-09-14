package leetcode.p0198

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class HouseRobberTest {
    private val solution = Solution()

    @Test
    fun `returns four for the first example`() {
        assertEquals(4, solution.rob(intArrayOf(1, 2, 3, 1)))
    }

    @Test
    fun `returns twelve for the second example`() {
        assertEquals(12, solution.rob(intArrayOf(2, 7, 9, 3, 1)))
    }

    @Test
    fun `handles a single house`() {
        assertEquals(1, solution.rob(intArrayOf(1)))
    }

    @Test
    fun `returns zero when every house is empty`() {
        assertEquals(0, solution.rob(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `chooses the larger amount from two adjacent houses`() {
        assertEquals(2, solution.rob(intArrayOf(1, 2)))
    }

    @Test
    fun `keeps the best result from the first two houses`() {
        assertEquals(4, solution.rob(intArrayOf(2, 1, 1, 2)))
    }

    @Test
    fun `chooses nonadjacent houses over one larger adjacent house`() {
        assertEquals(16, solution.rob(intArrayOf(2, 8, 2, 8)))
    }

    @Test
    fun `handles the maximum house value across multiple houses`() {
        assertEquals(800, solution.rob(intArrayOf(400, 1, 400)))
    }
}
