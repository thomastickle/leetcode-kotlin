package leetcode.p0334

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class IncreasingTripletSubsequenceTest {
    private val solution = Solution()

    @Test
    fun `finds a triplet in an increasing array`() {
        assertTrue(solution.increasingTriplet(intArrayOf(1, 2, 3, 4, 5)))
    }

    @Test
    fun `does not find a triplet in a decreasing array`() {
        assertFalse(solution.increasingTriplet(intArrayOf(5, 4, 3, 2, 1)))
    }

    @Test
    fun `finds a triplet whose values are not adjacent`() {
        assertTrue(solution.increasingTriplet(intArrayOf(2, 1, 5, 0, 4, 6)))
    }
}
