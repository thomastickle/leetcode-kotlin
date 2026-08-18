package leetcode.p0605

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class CanPlaceFlowersTest {
    private val solution = Solution()

    @Test
    fun `plants one flower without placing flowers next to each other`() {
        assertTrue(solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 1))
    }

    @Test
    fun `cannot plant two flowers without placing flowers next to each other`() {
        assertFalse(solution.canPlaceFlowers(intArrayOf(1, 0, 0, 0, 1), 2))
    }
}
