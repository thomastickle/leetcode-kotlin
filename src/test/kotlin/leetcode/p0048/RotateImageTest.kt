package leetcode.p0048

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RotateImageTest {
    private val solution = Solution()

    @Test
    fun `rotates matrix clockwise for example 1`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )

        solution.rotate(matrix)

        assertEquals(
            listOf(listOf(7, 4, 1), listOf(8, 5, 2), listOf(9, 6, 3)),
            matrix.map { it.toList() },
        )
    }

    @Test
    fun `rotates matrix clockwise for example 2`() {
        val matrix = arrayOf(
            intArrayOf(5, 1, 9, 11),
            intArrayOf(2, 4, 8, 10),
            intArrayOf(13, 3, 6, 7),
            intArrayOf(15, 14, 12, 16),
        )

        solution.rotate(matrix)

        assertEquals(
            listOf(
                listOf(15, 13, 2, 5),
                listOf(14, 3, 4, 1),
                listOf(12, 6, 8, 9),
                listOf(16, 7, 10, 11),
            ),
            matrix.map { it.toList() },
        )
    }

    @Test
    fun `leaves a single-cell matrix unchanged`() {
        val matrix = arrayOf(intArrayOf(-1000))

        solution.rotate(matrix)

        assertEquals(listOf(listOf(-1000)), matrix.map { it.toList() })
    }

    @Test
    fun `rotates a two-by-two matrix clockwise`() {
        val matrix = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
        )

        solution.rotate(matrix)

        assertEquals(listOf(listOf(3, 1), listOf(4, 2)), matrix.map { it.toList() })
    }
}
