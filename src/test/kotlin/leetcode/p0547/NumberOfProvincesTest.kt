package leetcode.p0547

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NumberOfProvincesTest {
    private val solution = Solution()

    private fun matrixOf(vararg rows: IntArray): Array<IntArray> = arrayOf(*rows)

    @Test
    fun `counts provinces for the first example`() {
        val isConnected = matrixOf(
            intArrayOf(1, 1, 0),
            intArrayOf(1, 1, 0),
            intArrayOf(0, 0, 1),
        )

        assertEquals(2, solution.findCircleNum(isConnected))
    }

    @Test
    fun `counts isolated cities for the second example`() {
        val isConnected = matrixOf(
            intArrayOf(1, 0, 0),
            intArrayOf(0, 1, 0),
            intArrayOf(0, 0, 1),
        )

        assertEquals(3, solution.findCircleNum(isConnected))
    }

    @Test
    fun `returns one for the minimum input of a single city`() {
        assertEquals(1, solution.findCircleNum(matrixOf(intArrayOf(1))))
    }

    @Test
    fun `returns one when every city is directly connected`() {
        val isConnected = matrixOf(
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
            intArrayOf(1, 1, 1, 1),
        )

        assertEquals(1, solution.findCircleNum(isConnected))
    }

    @Test
    fun `counts indirect connections as one province`() {
        val isConnected = matrixOf(
            intArrayOf(1, 1, 0, 0),
            intArrayOf(1, 1, 1, 0),
            intArrayOf(0, 1, 1, 1),
            intArrayOf(0, 0, 1, 1),
        )

        assertEquals(1, solution.findCircleNum(isConnected))
    }

    @Test
    fun `counts multiple disconnected groups`() {
        val isConnected = matrixOf(
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(1, 1, 0, 0, 0),
            intArrayOf(0, 0, 1, 1, 0),
            intArrayOf(0, 0, 1, 1, 0),
            intArrayOf(0, 0, 0, 0, 1),
        )

        assertEquals(3, solution.findCircleNum(isConnected))
    }

    @Test
    fun `handles the maximum number of isolated cities`() {
        val isConnected = Array(200) { city ->
            IntArray(200) { otherCity -> if (city == otherCity) 1 else 0 }
        }

        assertEquals(200, solution.findCircleNum(isConnected))
    }
}