package leetcode.p1431

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KidsWithTheGreatestNumberOfCandiesTest {
    private val solution = Solution()

    @Test
    fun `identifies every kid who can reach the greatest amount`() {
        assertEquals(
            listOf(true, true, true, false, true),
            solution.kidsWithCandies(intArrayOf(2, 3, 5, 1, 3), 3),
        )
    }

    @Test
    fun `identifies when only one kid can have the greatest amount`() {
        assertEquals(
            listOf(true, false, false, false, false),
            solution.kidsWithCandies(intArrayOf(4, 2, 1, 1, 2), 1),
        )
    }

    @Test
    fun `allows multiple kids to tie for the greatest amount`() {
        assertEquals(
            listOf(true, false, true),
            solution.kidsWithCandies(intArrayOf(12, 1, 12), 10),
        )
    }
}
