package leetcode.p2215

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheDifferenceOfTwoArraysTest {
    private val solution = Solution()

    @Test
    fun `returns distinct elements present in each array from the first example`() {
        val result = solution.findDifference(intArrayOf(1, 2, 3), intArrayOf(2, 4, 6))

        assertEquals(listOf(setOf(1, 3), setOf(4, 6)), result.map { it.toSet() })
        assertEquals(listOf(2, 2), result.map { it.size })
    }

    @Test
    fun `returns distinct elements when one difference is empty from the second example`() {
        val result = solution.findDifference(intArrayOf(1, 2, 3, 3), intArrayOf(1, 1, 2, 2))

        assertEquals(listOf(setOf(3), emptySet()), result.map { it.toSet() })
        assertEquals(listOf(1, 0), result.map { it.size })
    }

    @Test
    fun `returns empty lists when arrays have identical elements`() {
        val result = solution.findDifference(intArrayOf(1, 2, 3), intArrayOf(1, 2, 3))

        assertEquals(listOf(emptySet<Int>(), emptySet<Int>()), result.map { it.toSet() })
        assertEquals(listOf(0, 0), result.map { it.size })
    }

    @Test
    fun `returns all distinct elements when arrays are completely disjoint`() {
        val result = solution.findDifference(intArrayOf(1, 2), intArrayOf(3, 4))

        assertEquals(listOf(setOf(1, 2), setOf(3, 4)), result.map { it.toSet() })
        assertEquals(listOf(2, 2), result.map { it.size })
    }

    @Test
    fun `handles single-element arrays with the same value`() {
        val result = solution.findDifference(intArrayOf(1), intArrayOf(1))

        assertEquals(listOf(emptySet<Int>(), emptySet<Int>()), result.map { it.toSet() })
        assertEquals(listOf(0, 0), result.map { it.size })
    }

    @Test
    fun `handles single-element arrays with different values`() {
        val result = solution.findDifference(intArrayOf(1), intArrayOf(2))

        assertEquals(listOf(setOf(1), setOf(2)), result.map { it.toSet() })
        assertEquals(listOf(1, 1), result.map { it.size })
    }

    @Test
    fun `handles arrays with negative numbers and zero`() {
        val result = solution.findDifference(
            intArrayOf(-1000, 0, 1000),
            intArrayOf(0, -500, 500),
        )

        assertEquals(listOf(setOf(-1000, 1000), setOf(-500, 500)), result.map { it.toSet() })
        assertEquals(listOf(2, 2), result.map { it.size })
    }

    @Test
    fun `handles arrays where all elements are duplicate copies of the same value`() {
        val result = solution.findDifference(intArrayOf(5, 5, 5), intArrayOf(5, 5))

        assertEquals(listOf(emptySet<Int>(), emptySet<Int>()), result.map { it.toSet() })
        assertEquals(listOf(0, 0), result.map { it.size })
    }
}
