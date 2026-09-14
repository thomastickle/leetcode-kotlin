package leetcode.p0790

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DominoAndTrominoTilingTest {
    private val solution = Solution()

    @Test
    fun `returns five for the first example`() {
        assertEquals(5, solution.numTilings(3))
    }

    @Test
    fun `returns one for the second example`() {
        assertEquals(1, solution.numTilings(1))
    }

    @Test
    fun `returns two for a board with two columns`() {
        assertEquals(2, solution.numTilings(2))
    }

    @Test
    fun `counts tilings that include tromino placements`() {
        assertEquals(11, solution.numTilings(4))
    }
}