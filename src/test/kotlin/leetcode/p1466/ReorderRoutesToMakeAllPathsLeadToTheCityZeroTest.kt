package leetcode.p1466

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ReorderRoutesToMakeAllPathsLeadToTheCityZeroTest {
    private val solution = Solution()

    @Test
    fun `counts reversals for the first example`() {
        val connections = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(1, 3),
            intArrayOf(2, 3),
            intArrayOf(4, 0),
            intArrayOf(4, 5),
        )

        assertEquals(3, solution.minReorder(6, connections))
    }

    @Test
    fun `counts reversals for the second example`() {
        val connections = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(1, 2),
            intArrayOf(3, 2),
            intArrayOf(3, 4),
        )

        assertEquals(2, solution.minReorder(5, connections))
    }

    @Test
    fun `returns zero for the third example when every city already reaches zero`() {
        val connections = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 0),
        )

        assertEquals(0, solution.minReorder(3, connections))
    }

    @Test
    fun `reverses the only road for the minimum input`() {
        assertEquals(1, solution.minReorder(2, arrayOf(intArrayOf(0, 1))))
    }

    @Test
    fun `returns zero for a chain directed toward city zero`() {
        val connections = arrayOf(
            intArrayOf(1, 0),
            intArrayOf(2, 1),
            intArrayOf(3, 2),
            intArrayOf(4, 3),
        )

        assertEquals(0, solution.minReorder(5, connections))
    }

    @Test
    fun `reverses every road when a star is directed away from city zero`() {
        val connections = arrayOf(
            intArrayOf(0, 1),
            intArrayOf(0, 2),
            intArrayOf(0, 3),
            intArrayOf(0, 4),
        )

        assertEquals(4, solution.minReorder(5, connections))
    }
}
