package leetcode.p0747

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LargestNumberAtLeastTwiceOfOthersTest {
    private val solution = Solution()

    @Test
    fun `returns the largest index for the first example`() {
        assertEquals(1, solution.dominantIndex(intArrayOf(3, 6, 1, 0)))
    }

    @Test
    fun `returns negative one when the largest is not twice every other value`() {
        assertEquals(-1, solution.dominantIndex(intArrayOf(1, 2, 3, 4)))
    }

    @Test
    fun `accepts a largest value exactly twice the second largest`() {
        assertEquals(2, solution.dominantIndex(intArrayOf(0, 50, 100)))
    }

    @Test
    fun `rejects a largest value just below twice the second largest`() {
        assertEquals(-1, solution.dominantIndex(intArrayOf(0, 51, 100)))
    }

    @Test
    fun `returns the last index for a two-element boundary input`() {
        assertEquals(1, solution.dominantIndex(intArrayOf(0, 1)))
    }

    @Test
    fun `returns the first index for a two-element boundary input`() {
        assertEquals(0, solution.dominantIndex(intArrayOf(1, 0)))
    }

    @Test
    fun `allows duplicate non-largest values`() {
        assertEquals(2, solution.dominantIndex(intArrayOf(0, 0, 1)))
    }

    @Test
    fun `handles the maximum allowed values`() {
        assertEquals(1, solution.dominantIndex(intArrayOf(50, 100)))
    }
}
