package leetcode.p0189

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class RotateArrayTest {
    private val solution = Solution()

    @Test
    fun `rotates the first example three steps to the right`() {
        val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
        val numsV2 = nums.copyOf()

        solution.rotate(nums, 3)
        solution.rotateV2(numsV2, 3)

        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), nums)
        assertArrayEquals(intArrayOf(5, 6, 7, 1, 2, 3, 4), numsV2)
    }

    @Test
    fun `rotates the second example two steps to the right`() {
        val nums = intArrayOf(-1, -100, 3, 99)
        val numsV2 = nums.copyOf()

        solution.rotate(nums, 2)
        solution.rotateV2(numsV2, 2)

        assertArrayEquals(intArrayOf(3, 99, -1, -100), nums)
        assertArrayEquals(intArrayOf(3, 99, -1, -100), numsV2)
    }

    @Test
    fun `leaves the array unchanged when no steps are requested`() {
        val nums = intArrayOf(1, 2, 3)
        val numsV2 = nums.copyOf()

        solution.rotate(nums, 0)
        solution.rotateV2(numsV2, 0)

        assertArrayEquals(intArrayOf(1, 2, 3), nums)
        assertArrayEquals(intArrayOf(1, 2, 3), numsV2)
    }

    @Test
    fun `wraps around when the number of steps exceeds the array length`() {
        val nums = intArrayOf(1, 2, 3)
        val numsV2 = nums.copyOf()

        solution.rotate(nums, 4)
        solution.rotateV2(numsV2, 4)

        assertArrayEquals(intArrayOf(3, 1, 2), nums)
        assertArrayEquals(intArrayOf(3, 1, 2), numsV2)
    }

    @Test
    fun `handles a single-element array`() {
        val nums = intArrayOf(42)
        val numsV2 = nums.copyOf()

        solution.rotate(nums, 100)
        solution.rotateV2(numsV2, 100)

        assertArrayEquals(intArrayOf(42), nums)
        assertArrayEquals(intArrayOf(42), numsV2)
    }
}