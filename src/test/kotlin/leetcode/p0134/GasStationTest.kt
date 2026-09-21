package leetcode.p0134

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GasStationTest {
    private val solution = Solution()

    @Test
    fun `finds starting station for example 1`() {
        assertEquals(
            3,
            solution.canCompleteCircuit(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(3, 4, 5, 1, 2),
            ),
        )
    }

    @Test
    fun `returns minus one when circuit cannot be completed in example 2`() {
        assertEquals(
            -1,
            solution.canCompleteCircuit(
                intArrayOf(2, 3, 4),
                intArrayOf(3, 4, 3),
            ),
        )
    }

    @Test
    fun `returns index zero for single station with sufficient gas`() {
        assertEquals(
            0,
            solution.canCompleteCircuit(
                intArrayOf(5),
                intArrayOf(4),
            ),
        )
    }

    @Test
    fun `returns minus one for single station with insufficient gas`() {
        assertEquals(
            -1,
            solution.canCompleteCircuit(
                intArrayOf(2),
                intArrayOf(3),
            ),
        )
    }

    @Test
    fun `returns index zero when gas equals cost at all stations`() {
        assertEquals(
            0,
            solution.canCompleteCircuit(
                intArrayOf(1, 2, 3),
                intArrayOf(1, 2, 3),
            ),
        )
    }

    @Test
    fun `finds starting station when valid start is index zero`() {
        assertEquals(
            0,
            solution.canCompleteCircuit(
                intArrayOf(3, 1, 1),
                intArrayOf(1, 2, 2),
            ),
        )
    }

    @Test
    fun `finds starting station when valid start is the last index`() {
        assertEquals(
            2,
            solution.canCompleteCircuit(
                intArrayOf(1, 1, 3),
                intArrayOf(2, 2, 1),
            ),
        )
    }

    @Test
    fun `returns minus one when total gas is less than total cost`() {
        assertEquals(
            -1,
            solution.canCompleteCircuit(
                intArrayOf(1, 2, 3, 4, 5),
                intArrayOf(3, 4, 5, 1, 3),
            ),
        )
    }

    @Test
    fun `handles large fuel amounts and zero fuel stations`() {
        assertEquals(
            2,
            solution.canCompleteCircuit(
                intArrayOf(10000, 0, 10000),
                intArrayOf(5000, 10000, 5000),
            ),
        )
    }
}
