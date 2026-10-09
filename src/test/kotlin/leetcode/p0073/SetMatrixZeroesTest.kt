package leetcode.p0073

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SetMatrixZeroesTest {
    private val solution = Solution()

    @Test
    fun `sets rows and columns containing zero for example 1`() {
        val matrix = arrayOf(
            intArrayOf(1, 1, 1),
            intArrayOf(1, 0, 1),
            intArrayOf(1, 1, 1),
        )

        solution.setZeroes(matrix)

        assertEquals(
            listOf(listOf(1, 0, 1), listOf(0, 0, 0), listOf(1, 0, 1)),
            matrix.map { it.toList() },
        )
    }

    @Test
    fun `sets rows and columns containing zero for example 2`() {
        val matrix = arrayOf(
            intArrayOf(0, 1, 2, 0),
            intArrayOf(3, 4, 5, 2),
            intArrayOf(1, 3, 1, 5),
        )

        solution.setZeroes(matrix)

        assertEquals(
            listOf(listOf(0, 0, 0, 0), listOf(0, 4, 5, 0), listOf(0, 3, 1, 0)),
            matrix.map { it.toList() },
        )
    }

    @Test
    fun `leaves a matrix unchanged when it contains no zero`() {
        val matrix = arrayOf(
            intArrayOf(1, 2),
            intArrayOf(3, 4),
        )

        solution.setZeroes(matrix)

        assertEquals(listOf(listOf(1, 2), listOf(3, 4)), matrix.map { it.toList() })
    }

    @Test
    fun `zeros the first row and matching columns`() {
        val matrix = arrayOf(
            intArrayOf(1, 0, 3),
            intArrayOf(4, 5, 6),
            intArrayOf(7, 8, 9),
        )

        solution.setZeroes(matrix)

        assertEquals(
            listOf(listOf(0, 0, 0), listOf(4, 0, 6), listOf(7, 0, 9)),
            matrix.map { it.toList() },
        )
    }

    @Test
    fun `zeros the first column and matching rows`() {
        val matrix = arrayOf(
            intArrayOf(1, 2, 3),
            intArrayOf(0, 5, 6),
            intArrayOf(7, 8, 9),
        )

        solution.setZeroes(matrix)

        assertEquals(
            listOf(listOf(0, 2, 3), listOf(0, 0, 0), listOf(0, 8, 9)),
            matrix.map { it.toList() },
        )
    }

    @Test
    fun `handles a single cell containing zero`() {
        val matrix = arrayOf(intArrayOf(0))

        solution.setZeroes(matrix)

        assertEquals(listOf(listOf(0)), matrix.map { it.toList() })
    }

    @Test
    fun `preserves a single nonzero cell`() {
        val matrix = arrayOf(intArrayOf(42))

        solution.setZeroes(matrix)

        assertEquals(listOf(listOf(42)), matrix.map { it.toList() })
    }

    @Test
    fun `handles minimum and maximum integer values without treating them as zero`() {
        val matrix = arrayOf(
            intArrayOf(Int.MIN_VALUE, 0),
            intArrayOf(Int.MAX_VALUE, Int.MIN_VALUE),
        )

        solution.setZeroes(matrix)

        assertEquals(
            listOf(listOf(0, 0), listOf(Int.MAX_VALUE, 0)),
            matrix.map { it.toList() },
        )
    }
}