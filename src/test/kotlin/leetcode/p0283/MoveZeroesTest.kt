package leetcode.p0283

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class MoveZeroesTest {
    private val solution = Solution()

    @Test
    fun `moves zeroes to the end while preserving non-zero order`() {
        val nums = intArrayOf(0, 1, 0, 3, 12)

        solution.moveZeroes(nums)

        assertArrayEquals(intArrayOf(1, 3, 12, 0, 0), nums)
    }

    @Test
    fun `handles repeated negative values separated by zeroes`() {
        val nums = intArrayOf(0, -1, 0, -1, 2)

        solution.moveZeroes(nums)

        assertArrayEquals(intArrayOf(-1, -1, 2, 0, 0), nums)
    }

    @Test
    fun `leaves an array without zeroes unchanged`() {
        val nums = intArrayOf(1, 2, 3)

        solution.moveZeroes(nums)

        assertArrayEquals(intArrayOf(1, 2, 3), nums)
    }

    @Test
    fun `leaves an all-zero array unchanged`() {
        val nums = intArrayOf(0, 0, 0)

        solution.moveZeroes(nums)

        assertArrayEquals(intArrayOf(0, 0, 0), nums)
    }

    @Test
    fun `handles the minimum-size array`() {
        val nums = intArrayOf(0)

        solution.moveZeroes(nums)

        assertArrayEquals(intArrayOf(0), nums)
    }


}
