package leetcode.p0238

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ProductOfArrayExceptSelfTest {
    private val solution = Solution()

    @Test
    fun `calculates product except self for example 1`() {
        assertArrayEquals(
            intArrayOf(24, 12, 8, 6),
            solution.productExceptSelf(intArrayOf(1, 2, 3, 4)),
        )
    }

    @Test
    fun `handles single zero element in example 2`() {
        assertArrayEquals(
            intArrayOf(0, 0, 9, 0, 0),
            solution.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)),
        )
    }

    @Test
    fun `calculates product for two elements (minimum size)`() {
        assertArrayEquals(
            intArrayOf(5, 2),
            solution.productExceptSelf(intArrayOf(2, 5)),
        )
    }

    @Test
    fun `calculates product for two elements with negative numbers`() {
        assertArrayEquals(
            intArrayOf(3, -2),
            solution.productExceptSelf(intArrayOf(-2, 3)),
        )
    }

    @Test
    fun `returns all zeroes when array contains multiple zeroes`() {
        assertArrayEquals(
            intArrayOf(0, 0, 0),
            solution.productExceptSelf(intArrayOf(0, 4, 0)),
        )
    }

    @Test
    fun `handles all identical ones`() {
        assertArrayEquals(
            intArrayOf(1, 1, 1, 1),
            solution.productExceptSelf(intArrayOf(1, 1, 1, 1)),
        )
    }

    @Test
    fun `handles all negative numbers with alternating signs`() {
        assertArrayEquals(
            intArrayOf(-24, -12, -8, -6),
            solution.productExceptSelf(intArrayOf(-1, -2, -3, -4)),
        )
    }
}
