package leetcode.p0841

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class KeysAndRoomsTest {
    private val solution = Solution()

    @Test
    fun `returns true when keys unlock every room in sequence`() {
        val rooms = listOf(listOf(1), listOf(2), listOf(3), emptyList())

        assertTrue(solution.canVisitAllRooms(rooms))
    }

    @Test
    fun `returns false when a room can only be unlocked by its own key`() {
        val rooms = listOf(listOf(1, 3), listOf(3, 0, 1), listOf(2), listOf(0))

        assertFalse(solution.canVisitAllRooms(rooms))
    }

    @Test
    fun `returns true for the smallest valid input when room one is unlocked`() {
        val rooms = listOf(listOf(1), emptyList())

        assertTrue(solution.canVisitAllRooms(rooms))
    }

    @Test
    fun `returns false when some rooms form an unreachable cycle`() {
        val rooms = listOf(listOf(1), listOf(2), listOf(1), listOf(4), listOf(3))

        assertFalse(solution.canVisitAllRooms(rooms))
    }

    @Test
    fun `returns true when all remaining room keys are found in room zero`() {
        val rooms = listOf(listOf(1, 2, 3), emptyList(), emptyList(), emptyList())

        assertTrue(solution.canVisitAllRooms(rooms))
    }

    @Test
    fun `returns false when room zero has no key to another room`() {
        val rooms = listOf(emptyList(), listOf(0))

        assertFalse(solution.canVisitAllRooms(rooms))
    }

    @Test
    fun `handles a longer chain of rooms`() {
        val rooms = listOf(
            listOf(1),
            listOf(2),
            listOf(3),
            listOf(4),
            emptyList(),
        )

        assertTrue(solution.canVisitAllRooms(rooms))
    }
}
