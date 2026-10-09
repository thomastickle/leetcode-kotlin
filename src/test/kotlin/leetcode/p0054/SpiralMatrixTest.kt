package leetcode.p0054

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SpiralMatrixTest {
    private val solution = Solution()

    @Test
    fun `returns elements in spiral order for example 1`() {
        assertEquals(
            listOf(1, 2, 3, 6, 9, 8, 7, 4, 5),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                    intArrayOf(7, 8, 9),
                ),
            ),
        )
    }

    @Test
    fun `returns elements in spiral order for example 2`() {
        assertEquals(
            listOf(1, 2, 3, 4, 8, 12, 11, 10, 9, 5, 6, 7),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3, 4),
                    intArrayOf(5, 6, 7, 8),
                    intArrayOf(9, 10, 11, 12),
                ),
            ),
        )
    }

    @Test
    fun `traverses a single row`() {
        assertEquals(
            listOf(1, 2, 3, 4),
            solution.spiralOrder(arrayOf(intArrayOf(1, 2, 3, 4))),
        )
    }

    @Test
    fun `traverses a single column`() {
        assertEquals(
            listOf(1, 2, 3, 4),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1),
                    intArrayOf(2),
                    intArrayOf(3),
                    intArrayOf(4),
                ),
            ),
        )
    }

    @Test
    fun `traverses a single cell`() {
        assertEquals(
            listOf(-100),
            solution.spiralOrder(arrayOf(intArrayOf(-100))),
        )
    }

    @Test
    fun `traverses a matrix with two rows`() {
        assertEquals(
            listOf(1, 2, 3, 6, 5, 4),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1, 2, 3),
                    intArrayOf(4, 5, 6),
                ),
            ),
        )
    }

    @Test
    fun `traverses a matrix with two columns`() {
        assertEquals(
            listOf(1, 2, 4, 6, 5, 3),
            solution.spiralOrder(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 4),
                    intArrayOf(5, 6),
                ),
            ),
        )
    }
}
