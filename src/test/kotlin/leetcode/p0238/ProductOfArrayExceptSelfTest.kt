package leetcode.p0238

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class ProductOfArrayExceptSelfTest {
    private val solution = Solution()

    @Test
    fun `returns the product of every other element`() {
        assertArrayEquals(
            intArrayOf(24, 12, 8, 6),
            solution.productExceptSelf(intArrayOf(1, 2, 3, 4)),
        )
    }

    @Test
    fun `handles negative numbers and zero`() {
        assertArrayEquals(
            intArrayOf(0, 0, 9, 0, 0),
            solution.productExceptSelf(intArrayOf(-1, 1, 0, -3, 3)),
        )
    }
}
