package leetcode.p0088

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MergeSortedArrayTest {
    private val solution = Solution()

    @Test
    fun `merges the first example`() {
        val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)

        solution.merge(nums1, 3, intArrayOf(2, 5, 6), 3)

        assertArrayEquals(intArrayOf(1, 2, 2, 3, 5, 6), nums1)
    }

    @Test
    fun `leaves nums1 unchanged when nums2 is empty`() {
        val nums1 = intArrayOf(1)

        solution.merge(nums1, 1, intArrayOf(), 0)

        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun `copies nums2 when nums1 has no initialized values`() {
        val nums1 = intArrayOf(0)

        solution.merge(nums1, 0, intArrayOf(1), 1)

        assertArrayEquals(intArrayOf(1), nums1)
    }

    @Test
    fun `merges duplicate values in non-decreasing order`() {
        val nums1 = intArrayOf(1, 1, 2, 0, 0, 0)

        solution.merge(nums1, 3, intArrayOf(1, 2, 2), 3)

        assertArrayEquals(intArrayOf(1, 1, 1, 2, 2, 2), nums1)
    }

    @Test
    fun `merges negative and positive values`() {
        val nums1 = intArrayOf(-5, -1, 4, 0, 0, 0)

        solution.merge(nums1, 3, intArrayOf(-3, 0, 8), 3)

        assertArrayEquals(intArrayOf(-5, -3, -1, 0, 4, 8), nums1)
    }
}
