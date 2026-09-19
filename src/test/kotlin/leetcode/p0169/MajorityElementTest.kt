package leetcode.p0169

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MajorityElementTest {
    private val solution = Solution()

    @Test
    fun `returns the majority element from the first example`() {
        assertEquals(3, solution.majorityElement(intArrayOf(3, 2, 3)))
    }

    @Test
    fun `returns the majority element from the second example`() {
        assertEquals(2, solution.majorityElement(intArrayOf(2, 2, 1, 1, 1, 2, 2)))
    }

    @Test
    fun `returns the only value in a single-element array`() {
        assertEquals(7, solution.majorityElement(intArrayOf(7)))
    }

    @Test
    fun `supports a negative majority element`() {
        assertEquals(-4, solution.majorityElement(intArrayOf(-4, 2, -4, -4, 3)))
    }

    @Test
    fun `finds a majority that appears just over half the time`() {
        assertEquals(9, solution.majorityElement(intArrayOf(1, 9, 2, 9, 3, 9, 9)))
    }
}
