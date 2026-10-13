package leetcode.p0056

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MergeIntervalsTest {
    private val solution = Solution()

    private fun assertIntervals(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        expected.zip(actual).forEach { (expectedInterval, actualInterval) ->
            assertArrayEquals(expectedInterval, actualInterval)
        }
    }

    @Test
    fun `merges overlapping intervals from the first example`() {
        assertIntervals(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18),
            ),
            solution.merge(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 6),
                    intArrayOf(8, 10),
                    intArrayOf(15, 18),
                ),
            ),
        )
    }

    @Test
    fun `merges intervals that share an endpoint from the second example`() {
        assertIntervals(
            arrayOf(intArrayOf(1, 5)),
            solution.merge(
                arrayOf(
                    intArrayOf(1, 4),
                    intArrayOf(4, 5),
                ),
            ),
        )
    }

    @Test
    fun `merges a chain of overlapping intervals into one range`() {
        assertIntervals(
            arrayOf(intArrayOf(1, 8)),
            solution.merge(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(2, 5),
                    intArrayOf(4, 8),
                ),
            ),
        )
    }

    @Test
    fun `keeps nested intervals within their enclosing interval`() {
        assertIntervals(
            arrayOf(intArrayOf(1, 10)),
            solution.merge(
                arrayOf(
                    intArrayOf(1, 10),
                    intArrayOf(2, 3),
                    intArrayOf(4, 7),
                ),
            ),
        )
    }

    @Test
    fun `orders and merges an unsorted interval array`() {
        assertIntervals(
            arrayOf(
                intArrayOf(1, 6),
                intArrayOf(8, 10),
                intArrayOf(15, 18),
            ),
            solution.merge(
                arrayOf(
                    intArrayOf(8, 10),
                    intArrayOf(15, 18),
                    intArrayOf(2, 6),
                    intArrayOf(1, 3),
                ),
            ),
        )
    }

    @Test
    fun `keeps disjoint intervals separate`() {
        assertIntervals(
            arrayOf(
                intArrayOf(0, 1),
                intArrayOf(3, 4),
                intArrayOf(6, 8),
            ),
            solution.merge(
                arrayOf(
                    intArrayOf(3, 4),
                    intArrayOf(6, 8),
                    intArrayOf(0, 1),
                ),
            ),
        )
    }

    @Test
    fun `returns a single interval unchanged`() {
        assertIntervals(
            arrayOf(intArrayOf(7, 7)),
            solution.merge(arrayOf(intArrayOf(7, 7))),
        )
    }

    @Test
    fun `handles the endpoint values from the constraints`() {
        assertIntervals(
            arrayOf(
                intArrayOf(0, 0),
                intArrayOf(10_000, 10_000),
            ),
            solution.merge(
                arrayOf(
                    intArrayOf(10_000, 10_000),
                    intArrayOf(0, 0),
                ),
            ),
        )
    }
}
