package leetcode.p0027

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RemoveElementTest {
    private val solution = Solution()

    @Test
    fun `removes the value from the first example`() {
        val nums = intArrayOf(3, 2, 2, 3)

        val length = solution.removeElement(nums, 3)

        assertEquals(2, length)
        assertEquals(listOf(2, 2), nums.take(length).sorted())
    }

    @Test
    fun `removes repeated values from the second example`() {
        val nums = intArrayOf(0, 1, 2, 2, 3, 0, 4, 2)

        val length = solution.removeElement(nums, 2)

        assertEquals(5, length)
        assertEquals(listOf(0, 0, 1, 3, 4), nums.take(length).sorted())
    }

    @Test
    fun `returns zero when every element matches`() {
        val nums = intArrayOf(7, 7, 7)

        val length = solution.removeElement(nums, 7)

        assertEquals(0, length)
        assertEquals(emptyList<Int>(), nums.take(length))
    }

    @Test
    fun `keeps all elements when the value is absent`() {
        val nums = intArrayOf(1, 2, 3)

        val length = solution.removeElement(nums, 4)

        assertEquals(3, length)
        assertEquals(listOf(1, 2, 3), nums.take(length).sorted())
    }

    @Test
    fun `handles an empty input array`() {
        val nums = intArrayOf()

        val length = solution.removeElement(nums, 0)

        assertEquals(0, length)
    }
}
