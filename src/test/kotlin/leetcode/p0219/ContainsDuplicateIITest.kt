package leetcode.p0219

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ContainsDuplicateIITest {
    private val solution = Solution()

    @Test
    fun `returns true for the first example`() {
        assertTrue(solution.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1), 3))
    }

    @Test
    fun `returns true for the second example`() {
        assertTrue(solution.containsNearbyDuplicate(intArrayOf(1, 0, 1, 1), 1))
    }

    @Test
    fun `returns false for the third example`() {
        assertFalse(solution.containsNearbyDuplicate(intArrayOf(1, 2, 3, 1, 2, 3), 2))
    }

    @Test
    fun `returns true when equal values are exactly k positions apart`() {
        assertTrue(solution.containsNearbyDuplicate(intArrayOf(5, 6, 7, 5), 3))
    }

    @Test
    fun `returns false when equal values are one position beyond k`() {
        assertFalse(solution.containsNearbyDuplicate(intArrayOf(5, 6, 7, 5), 2))
    }

    @Test
    fun `returns false for duplicate values when k is zero`() {
        assertFalse(solution.containsNearbyDuplicate(intArrayOf(1, 1), 0))
    }

    @Test
    fun `handles a single element array`() {
        assertFalse(solution.containsNearbyDuplicate(intArrayOf(-1), 100))
    }

    @Test
    fun `detects duplicate negative values`() {
        assertTrue(solution.containsNearbyDuplicate(intArrayOf(-10, 4, -10), 2))
    }
}
