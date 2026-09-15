package leetcode.p0072

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EditDistanceTest {
    private val solution = Solution()

    @Test
    fun `returns three for the first example`() {
        assertEquals(3, solution.minDistance("horse", "ros"))
    }

    @Test
    fun `returns five for the second example`() {
        assertEquals(5, solution.minDistance("intention", "execution"))
    }

    @Test
    fun `returns zero for identical words`() {
        assertEquals(0, solution.minDistance("algorithm", "algorithm"))
    }

    @Test
    fun `inserts every character when the source is empty`() {
        assertEquals(4, solution.minDistance("", "test"))
    }

    @Test
    fun `deletes every character when the target is empty`() {
        assertEquals(3, solution.minDistance("cat", ""))
    }

    @Test
    fun `chooses replacement instead of multiple edits`() {
        assertEquals(1, solution.minDistance("a", "b"))
    }
}
