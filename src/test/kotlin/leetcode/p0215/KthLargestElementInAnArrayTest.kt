package leetcode.p0215

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class KthLargestElementInAnArrayTest {
    private val solution = Solution()

    @Test
    fun `finds the second largest element for the first example`() {
        assertEquals(5, solution.findKthLargest(intArrayOf(3, 2, 1, 5, 6, 4), 2))
    }

    @Test
    fun `finds the fourth largest element for the second example`() {
        assertEquals(4, solution.findKthLargest(intArrayOf(3, 2, 3, 1, 2, 4, 5, 5, 6), 4))
    }

    @Test
    fun `returns the single element when array size and k are one`() {
        assertEquals(1, solution.findKthLargest(intArrayOf(1), 1))
    }

    @Test
    fun `finds the largest element when k is one`() {
        assertEquals(20, solution.findKthLargest(intArrayOf(7, 10, 4, 3, 20, 15), 1))
    }

    @Test
    fun `finds the smallest element when k equals array size`() {
        assertEquals(3, solution.findKthLargest(intArrayOf(7, 10, 4, 3, 20, 15), 6))
    }

    @Test
    fun `handles arrays with duplicate values correctly`() {
        assertEquals(2, solution.findKthLargest(intArrayOf(2, 2, 2, 2), 2))
    }

    @Test
    fun `handles negative numbers and zero`() {
        assertEquals(-1, solution.findKthLargest(intArrayOf(-1, -2, 0, -5), 2))
    }
}
