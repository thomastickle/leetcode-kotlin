package leetcode.p0026

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveDuplicatesFromSortedArrayTest {
    private val solution = Solution()

    @Test
    fun `removes duplicates from the first example`() {
        val nums = intArrayOf(1, 1, 2)

        val length = solution.removeDuplicates(nums)

        assertEquals(2, length)
        assertEquals(listOf(1, 2), nums.take(length))
    }

    @Test
    fun `removes repeated values from the second example`() {
        val nums = intArrayOf(0, 0, 1, 1, 1, 2, 2, 3, 3, 4)

        val length = solution.removeDuplicates(nums)

        assertEquals(5, length)
        assertEquals(listOf(0, 1, 2, 3, 4), nums.take(length))
    }

    @Test
    fun `keeps an already unique sorted array unchanged`() {
        val nums = intArrayOf(-2, 0, 4)

        val length = solution.removeDuplicates(nums)

        assertEquals(3, length)
        assertEquals(listOf(-2, 0, 4), nums.take(length))
    }

    @Test
    fun `keeps a single element`() {
        val nums = intArrayOf(7)

        val length = solution.removeDuplicates(nums)

        assertEquals(1, length)
        assertEquals(listOf(7), nums.take(length))
    }

    @Test
    fun `collapses an array containing one repeated value`() {
        val nums = intArrayOf(5, 5, 5, 5)

        val length = solution.removeDuplicates(nums)

        assertEquals(1, length)
        assertEquals(listOf(5), nums.take(length))
    }
}
