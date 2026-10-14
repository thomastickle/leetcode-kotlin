package leetcode.p0057

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class InsertIntervalTest {
    private val solution = Solution()

    private fun assertIntervals(expected: Array<IntArray>, actual: Array<IntArray>) {
        assertEquals(expected.size, actual.size)
        expected.zip(actual).forEach { (expectedInterval, actualInterval) ->
            assertArrayEquals(expectedInterval, actualInterval)
        }
    }

    @Test
    fun `inserts and merges the new interval from the first example`() {
        assertIntervals(
            arrayOf(
                intArrayOf(1, 5),
                intArrayOf(6, 9),
            ),
            solution.insert(
                arrayOf(
                    intArrayOf(1, 3),
                    intArrayOf(6, 9),
                ),
                intArrayOf(2, 5),
            ),
        )
    }

    @Test
    fun `inserts and merges multiple intervals from the second example`() {
        assertIntervals(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(3, 10),
                intArrayOf(12, 16),
            ),
            solution.insert(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(3, 5),
                    intArrayOf(6, 7),
                    intArrayOf(8, 10),
                    intArrayOf(12, 16),
                ),
                intArrayOf(4, 8),
            ),
        )
    }

    @Test
    fun `inserts into an empty interval list`() {
        assertIntervals(
            arrayOf(intArrayOf(5, 7)),
            solution.insert(emptyArray(), intArrayOf(5, 7)),
        )
    }

    @Test
    fun `inserts before all existing intervals`() {
        assertIntervals(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(4, 5),
            ),
            solution.insert(
                arrayOf(intArrayOf(4, 5)),
                intArrayOf(1, 2),
            ),
        )
    }

    @Test
    fun `inserts after all existing intervals`() {
        assertIntervals(
            arrayOf(
                intArrayOf(1, 2),
                intArrayOf(4, 5),
            ),
            solution.insert(
                arrayOf(intArrayOf(1, 2)),
                intArrayOf(4, 5),
            ),
        )
    }

    @Test
    fun `keeps a new interval unchanged when it is contained by an existing interval`() {
        assertIntervals(
            arrayOf(intArrayOf(1, 10)),
            solution.insert(
                arrayOf(intArrayOf(1, 10)),
                intArrayOf(3, 6),
            ),
        )
    }

    @Test
    fun `merges intervals that touch at an endpoint`() {
        assertIntervals(
            arrayOf(intArrayOf(1, 6)),
            solution.insert(
                arrayOf(
                    intArrayOf(1, 2),
                    intArrayOf(5, 6),
                ),
                intArrayOf(2, 5),
            ),
        )
    }
}