package leetcode.p0228

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SummaryRangesTest {
    private val solution = Solution()

    @Test
    fun `returns the summary from the first example`() {
        assertEquals(
            listOf("0->2", "4->5", "7"),
            solution.summaryRanges(intArrayOf(0, 1, 2, 4, 5, 7)),
        )
    }

    @Test
    fun `returns the summary from the second example`() {
        assertEquals(
            listOf("0", "2->4", "6", "8->9"),
            solution.summaryRanges(intArrayOf(0, 2, 3, 4, 6, 8, 9)),
        )
    }

    @Test
    fun `returns no ranges for an empty array`() {
        assertEquals(emptyList<String>(), solution.summaryRanges(intArrayOf()))
    }

    @Test
    fun `formats a single value as a single-value range`() {
        assertEquals(listOf("42"), solution.summaryRanges(intArrayOf(42)))
    }

    @Test
    fun `keeps negative consecutive values in one range`() {
        assertEquals(listOf("-3->-1", "1"), solution.summaryRanges(intArrayOf(-3, -2, -1, 1)))
    }

    @Test
    fun `handles the full integer boundaries without treating them as consecutive`() {
        assertEquals(
            listOf("-2147483648", "2147483647"),
            solution.summaryRanges(intArrayOf(Int.MIN_VALUE, Int.MAX_VALUE)),
        )
    }

    @Test
    fun `separates values with a gap of one missing integer`() {
        assertEquals(listOf("1->2", "4->5"), solution.summaryRanges(intArrayOf(1, 2, 4, 5)))
    }
}
