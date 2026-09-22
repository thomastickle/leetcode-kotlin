package leetcode.p0135

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CandyTest {
    private val solution = Solution()

    @Test
    fun `calculates candies for example 1 (valley)`() {
        assertEquals(
            5,
            solution.candy(intArrayOf(1, 0, 2)),
        )
    }

    @Test
    fun `calculates candies for example 2 (plateau)`() {
        assertEquals(
            4,
            solution.candy(intArrayOf(1, 2, 2)),
        )
    }

    @Test
    fun `handles single child (minimum size)`() {
        assertEquals(
            1,
            solution.candy(intArrayOf(0)),
        )
    }

    @Test
    fun `handles all identical ratings`() {
        assertEquals(
            4,
            solution.candy(intArrayOf(3, 3, 3, 3)),
        )
    }

    @Test
    fun `handles strictly increasing ratings`() {
        // [1, 2, 3, 4] -> candies: [1, 2, 3, 4] sum = 10
        assertEquals(
            10,
            solution.candy(intArrayOf(1, 2, 3, 4)),
        )
    }

    @Test
    fun `handles strictly decreasing ratings`() {
        // [4, 3, 2, 1] -> candies: [4, 3, 2, 1] sum = 10
        assertEquals(
            10,
            solution.candy(intArrayOf(4, 3, 2, 1)),
        )
    }

    @Test
    fun `handles peak with unequal slopes`() {
        // ratings: [1, 3, 2, 2, 1]
        // left-to-right:  [1, 2, 1, 1, 1]
        // right-to-left: [1, 2, 1, 2, 1] -> max: [1, 2, 1, 2, 1] sum = 7
        assertEquals(
            7,
            solution.candy(intArrayOf(1, 3, 2, 2, 1)),
        )
    }

    @Test
    fun `handles complex sequence of peaks and valleys`() {
        // ratings: [1, 2, 87, 87, 87, 2, 1]
        // candies: [1, 2,  3,  1,  3, 2, 1] sum = 13
        assertEquals(
            13,
            solution.candy(intArrayOf(1, 2, 87, 87, 87, 2, 1)),
        )
    }
}
