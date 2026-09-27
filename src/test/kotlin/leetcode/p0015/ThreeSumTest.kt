package leetcode.p0015

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ThreeSumTest {
    private val solution = Solution()

    @Test
    fun `returns the distinct triplets for the first example`() {
        assertEquals(
            setOf(listOf(-1, -1, 2), listOf(-1, 0, 1)),
            solution.threeSum(intArrayOf(-1, 0, 1, 2, -1, -4)).map { it.toList() }.toSet(),
        )
    }

    @Test
    fun `returns no triplets for the second example`() {
        assertEquals(emptySet<List<Int>>(), solution.threeSum(intArrayOf(0, 1, 1)).toSet())
    }

    @Test
    fun `returns the single zero triplet for the third example`() {
        assertEquals(setOf(listOf(0, 0, 0)), solution.threeSum(intArrayOf(0, 0, 0)).map { it.toList() }.toSet())
    }

    @Test
    fun `handles the minimum three-element input`() {
        assertEquals(setOf(listOf(-1, 0, 1)), solution.threeSum(intArrayOf(-1, 0, 1)).map { it.toList() }.toSet())
    }

    @Test
    fun `does not return duplicate triplets from repeated values`() {
        assertEquals(
            setOf(listOf(-2, 0, 2)),
            solution.threeSum(intArrayOf(-2, 0, 0, 2, 2)).map { it.toList() }.toSet(),
        )
    }

    @Test
    fun `returns distinct triplets when repeated values form separate solutions`() {
        assertEquals(
            setOf(listOf(-2, 0, 2), listOf(-2, 1, 1)),
            solution.threeSum(intArrayOf(-2, 0, 1, 1, 2)).map { it.toList() }.toSet(),
        )
    }

    @Test
    fun `handles values at both constraint boundaries`() {
        assertEquals(
            setOf(listOf(-100000, 0, 100000)),
            solution.threeSum(intArrayOf(-100000, 0, 100000)).map { it.toList() }.toSet(),
        )
    }
}
