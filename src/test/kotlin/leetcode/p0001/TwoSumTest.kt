package leetcode.p0001

import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class TwoSumTest {
    private val solution = Solution()

    @Test
    fun `returns indices for the first example`() {
        assertIndices(intArrayOf(0, 1), solution.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun `returns indices for the second example`() {
        assertIndices(intArrayOf(1, 2), solution.twoSum(intArrayOf(3, 2, 4), 6))
    }

    @Test
    fun `returns distinct indices for the third example with duplicate values`() {
        assertIndices(intArrayOf(0, 1), solution.twoSum(intArrayOf(3, 3), 6))
    }

    @Test
    fun `finds a pair with negative values`() {
        assertIndices(intArrayOf(0, 2), solution.twoSum(intArrayOf(-3, 4, 3, 90), 0))
    }

    @Test
    fun `handles values at the constraint boundaries`() {
        assertIndices(
            intArrayOf(0, 1),
            solution.twoSum(intArrayOf(-1_000_000_000, 1_000_000_000), 0),
        )
    }

    @Test
    fun `handles the maximum input length`() {
        val nums = IntArray(10_000) { it }

        assertIndices(intArrayOf(9_998, 9_999), solution.twoSum(nums, 19_997))
    }

    private fun assertIndices(expected: IntArray, actual: IntArray) {
        assertTrue(actual.contentEquals(expected) || actual.contentEquals(expected.reversedArray()))
    }
}
