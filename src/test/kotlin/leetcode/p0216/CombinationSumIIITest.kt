package leetcode.p0216

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CombinationSumIIITest {
    private val solution = Solution()

    @Test
    fun `returns the only combination for the first example`() {
        assertEquals(
            setOf(listOf(1, 2, 4)),
            solution.combinationSum3(3, 7).toSet(),
        )
    }

    @Test
    fun `returns all combinations for the second example`() {
        assertEquals(
            setOf(listOf(1, 2, 6), listOf(1, 3, 5), listOf(2, 3, 4)),
            solution.combinationSum3(3, 9).toSet(),
        )
    }

    @Test
    fun `returns no combinations when the target is below the minimum sum`() {
        assertEquals(emptySet<List<Int>>(), solution.combinationSum3(4, 1).toSet())
    }

    @Test
    fun `handles the smallest number of selected values`() {
        assertEquals(setOf(listOf(1, 2)), solution.combinationSum3(2, 3).toSet())
    }

    @Test
    fun `handles selecting every available number`() {
        assertEquals(
            setOf(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9)),
            solution.combinationSum3(9, 45).toSet(),
        )
    }
}
