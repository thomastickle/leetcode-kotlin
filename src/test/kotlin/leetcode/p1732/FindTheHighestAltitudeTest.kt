package leetcode.p1732

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheHighestAltitudeTest {
    private val solution = Solution()

    @Test
    fun `returns the highest altitude from the first example`() {
        assertEquals(1, solution.largestAltitude(intArrayOf(-5, 1, 5, 0, -7)))
    }

    @Test
    fun `returns zero when all intermediate altitudes are negative`() {
        assertEquals(0, solution.largestAltitude(intArrayOf(-4, -3, -2, -1, 4, 3, 2)))
    }

    @Test
    fun `handles single gain element with positive net altitude`() {
        assertEquals(5, solution.largestAltitude(intArrayOf(5)))
    }

    @Test
    fun `handles single gain element with negative net altitude`() {
        assertEquals(0, solution.largestAltitude(intArrayOf(-5)))
    }

    @Test
    fun `handles strictly increasing gains`() {
        assertEquals(10, solution.largestAltitude(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `handles strictly decreasing gains`() {
        assertEquals(0, solution.largestAltitude(intArrayOf(-1, -2, -3)))
    }

    @Test
    fun `handles all zero gains`() {
        assertEquals(0, solution.largestAltitude(intArrayOf(0, 0, 0)))
    }

    @Test
    fun `handles boundary constraint values`() {
        assertEquals(100, solution.largestAltitude(intArrayOf(100, -100, 100)))
    }
}
