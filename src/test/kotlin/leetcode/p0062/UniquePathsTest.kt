package leetcode.p0062

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class UniquePathsTest {
    private val solution = Solution()

    @Test
    fun `returns twenty eight for the first example`() {
        assertEquals(28, solution.uniquePaths(3, 7))
    }

    @Test
    fun `returns three for the second example`() {
        assertEquals(3, solution.uniquePaths(3, 2))
    }

    @Test
    fun `returns one for a single cell grid`() {
        assertEquals(1, solution.uniquePaths(1, 1))
    }

    @Test
    fun `returns one when the grid has only one row`() {
        assertEquals(1, solution.uniquePaths(1, 100))
    }

    @Test
    fun `returns a count near the maximum allowed answer`() {
        assertEquals(1984829850, solution.uniquePaths(8, 69))
    }
}