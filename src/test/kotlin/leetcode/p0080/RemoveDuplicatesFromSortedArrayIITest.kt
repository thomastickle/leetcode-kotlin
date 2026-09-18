package leetcode.p0080

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayIITest {
    private val solution = Solution()

    @Test
    fun `keeps at most two copies in the first example`() {
        val nums = intArrayOf(1, 1, 1, 2, 2, 3)

        val length = solution.removeDuplicates(nums)

        assertEquals(5, length)
        assertEquals(listOf(1, 1, 2, 2, 3), nums.take(length))
    }

    @Test
    fun `keeps at most two copies in the second example`() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 1, 2, 3, 3)

        val length = solution.removeDuplicates(nums)

        assertEquals(7, length)
        assertEquals(listOf(0, 0, 1, 1, 2, 3, 3), nums.take(length))
    }

    @Test
    fun `keeps an already valid sorted array unchanged`() {
        val nums = intArrayOf(-2, -2, 0, 1, 1)

        val length = solution.removeDuplicates(nums)

        assertEquals(5, length)
        assertEquals(listOf(-2, -2, 0, 1, 1), nums.take(length))
    }

    @Test
    fun `keeps a single element`() {
        val nums = intArrayOf(7)

        val length = solution.removeDuplicates(nums)

        assertEquals(1, length)
        assertEquals(listOf(7), nums.take(length))
    }

    @Test
    fun `collapses a run of repeated values to two copies`() {
        val nums = intArrayOf(5, 5, 5, 5, 5)

        val length = solution.removeDuplicates(nums)

        assertEquals(2, length)
        assertEquals(listOf(5, 5), nums.take(length))
    }
}
