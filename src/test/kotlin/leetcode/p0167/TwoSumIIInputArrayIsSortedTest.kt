package leetcode.p0167

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class TwoSumIIInputArrayIsSortedTest {
    private val solution = Solution()

    @Test
    fun `returns indices for the first example`() {
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(2, 7, 11, 15), 9))
    }

    @Test
    fun `returns indices for the second example`() {
        assertArrayEquals(intArrayOf(1, 3), solution.twoSum(intArrayOf(2, 3, 4), 6))
    }

    @Test
    fun `returns indices for the third example with a negative target`() {
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(-1, 0), -1))
    }

    @Test
    fun `uses two distinct equal values when they form the target`() {
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(5, 5), 10))
    }

    @Test
    fun `handles a pair at the constraint value boundaries`() {
        assertArrayEquals(intArrayOf(1, 2), solution.twoSum(intArrayOf(-1000, 1000), 0))
    }
}