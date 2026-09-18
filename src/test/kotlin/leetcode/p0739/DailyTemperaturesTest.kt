package leetcode.p0739

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class DailyTemperaturesTest {
    private val solution = Solution()

    @Test
    fun `returns waiting days for example 1`() {
        assertArrayEquals(
            intArrayOf(1, 1, 4, 2, 1, 1, 0, 0),
            solution.dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73)),
        )
    }

    @Test
    fun `returns waiting days for increasing example 2`() {
        assertArrayEquals(
            intArrayOf(1, 1, 1, 0),
            solution.dailyTemperatures(intArrayOf(30, 40, 50, 60)),
        )
    }

    @Test
    fun `returns waiting days for example 3`() {
        assertArrayEquals(
            intArrayOf(1, 1, 0),
            solution.dailyTemperatures(intArrayOf(30, 60, 90)),
        )
    }

    @Test
    fun `returns zero when no warmer day follows`() {
        assertArrayEquals(
            intArrayOf(0, 0, 0, 0),
            solution.dailyTemperatures(intArrayOf(90, 80, 70, 60)),
        )
    }

    @Test
    fun `does not treat equal temperatures as warmer`() {
        assertArrayEquals(
            intArrayOf(0, 0, 0),
            solution.dailyTemperatures(intArrayOf(50, 50, 50)),
        )
    }

    @Test
    fun `handles a single temperature`() {
        assertArrayEquals(intArrayOf(0), solution.dailyTemperatures(intArrayOf(30)))
    }

    @Test
    fun `handles temperatures at both constraint limits`() {
        assertArrayEquals(
            intArrayOf(1, 0),
            solution.dailyTemperatures(intArrayOf(30, 100)),
        )
    }
}
