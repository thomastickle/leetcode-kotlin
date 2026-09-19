package leetcode.p0055

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class JumpGameTest {
    private val solution = Solution()

    @Test
    fun `reaches the last index in example 1`() {
        assertTrue(solution.canJump(intArrayOf(2, 3, 1, 1, 4)))
    }

    @Test
    fun `cannot reach the last index due to zero in example 2`() {
        assertFalse(solution.canJump(intArrayOf(3, 2, 1, 0, 4)))
    }

    @Test
    fun `returns true for a single-element array with zero`() {
        assertTrue(solution.canJump(intArrayOf(0)))
    }

    @Test
    fun `returns true for a single-element array with positive jump`() {
        assertTrue(solution.canJump(intArrayOf(5)))
    }

    @Test
    fun `returns false when immediately stuck on the first element`() {
        assertFalse(solution.canJump(intArrayOf(0, 1)))
    }

    @Test
    fun `returns true when jumping exactly lands on the last index with trailing zero`() {
        assertTrue(solution.canJump(intArrayOf(2, 0, 0)))
    }

    @Test
    fun `returns true when jump extends past the last index`() {
        assertTrue(solution.canJump(intArrayOf(1, 0)))
    }
}
