package leetcode.p2300

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class SuccessfulPairsOfSpellsAndPotionsTest {
    private val solution = Solution()

    @Test
    fun `counts successful pairs for the first example`() {
        assertArrayEquals(
            intArrayOf(4, 0, 3),
            solution.successfulPairs(
                spells = intArrayOf(5, 1, 3),
                potions = intArrayOf(1, 2, 3, 4, 5),
                success = 7,
            ),
        )
    }

    @Test
    fun `counts successful pairs for the second example`() {
        assertArrayEquals(
            intArrayOf(2, 0, 2),
            solution.successfulPairs(
                spells = intArrayOf(3, 1, 2),
                potions = intArrayOf(8, 5, 8),
                success = 16,
            ),
        )
    }

    @Test
    fun `returns all potions when every pair meets success threshold`() {
        assertArrayEquals(
            intArrayOf(3, 3),
            solution.successfulPairs(
                spells = intArrayOf(10, 20),
                potions = intArrayOf(5, 6, 7),
                success = 50,
            ),
        )
    }

    @Test
    fun `returns zero when no pair meets success threshold`() {
        assertArrayEquals(
            intArrayOf(0, 0),
            solution.successfulPairs(
                spells = intArrayOf(1, 2),
                potions = intArrayOf(1, 2),
                success = 100,
            ),
        )
    }

    @Test
    fun `handles single element arrays`() {
        assertArrayEquals(
            intArrayOf(1),
            solution.successfulPairs(
                spells = intArrayOf(5),
                potions = intArrayOf(2),
                success = 10,
            ),
        )
        assertArrayEquals(
            intArrayOf(0),
            solution.successfulPairs(
                spells = intArrayOf(5),
                potions = intArrayOf(1),
                success = 10,
            ),
        )
    }

    @Test
    fun `handles duplicate potion values correctly`() {
        assertArrayEquals(
            intArrayOf(5),
            solution.successfulPairs(
                spells = intArrayOf(2),
                potions = intArrayOf(3, 3, 3, 4, 4),
                success = 6,
            ),
        )
    }

    @Test
    fun `includes pairs where product equals success exactly`() {
        assertArrayEquals(
            intArrayOf(2, 2),
            solution.successfulPairs(
                spells = intArrayOf(2, 3),
                potions = intArrayOf(3, 4),
                success = 6,
            ),
        )
    }

    @Test
    fun `handles large values without 32-bit integer overflow`() {
        assertArrayEquals(
            intArrayOf(1),
            solution.successfulPairs(
                spells = intArrayOf(100_000),
                potions = intArrayOf(100_000),
                success = 10_000_000_000L,
            ),
        )
    }
}
