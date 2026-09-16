package leetcode.p1318

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinimumFlipsToMakeAOrBEqualToCTest {
    private val solution = Solution()

    @Test
    fun `returns three for the first example`() {
        assertEquals(3, solution.minFlips(2, 6, 5))
    }

    @Test
    fun `returns one for the second example`() {
        assertEquals(1, solution.minFlips(4, 2, 7))
    }

    @Test
    fun `returns zero for the third example`() {
        assertEquals(0, solution.minFlips(1, 2, 3))
    }

    @Test
    fun `returns zero when the bitwise or already equals the target`() {
        assertEquals(0, solution.minFlips(1_000_000_000, 1_000_000_000, 1_000_000_000))
    }

    @Test
    fun `flips both set bits and sets the target bit when necessary`() {
        assertEquals(3, solution.minFlips(1, 1, 2))
    }

    @Test
    fun `handles a high bit within the input boundary`() {
        assertEquals(3, solution.minFlips(536_870_912, 536_870_912, 1))
    }
}
