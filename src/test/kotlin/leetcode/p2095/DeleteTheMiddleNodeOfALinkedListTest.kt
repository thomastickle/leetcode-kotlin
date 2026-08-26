package leetcode.p2095

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class DeleteTheMiddleNodeOfALinkedListTest {
    private val solution = Solution()

    private fun listNodeOf(vararg values: Int): ListNode? {
        if (values.isEmpty()) return null
        val head = ListNode(values[0])
        var current = head
        for (i in 1 until values.size) {
            val next = ListNode(values[i])
            current.next = next
            current = next
        }
        return head
    }

    private fun ListNode?.toList(): List<Int> {
        val result = mutableListOf<Int>()
        var current = this
        while (current != null) {
            result.add(current.`val`)
            current = current.next
        }
        return result
    }

    @Test
    fun `deletes middle node from odd-length list for first example`() {
        val head = listNodeOf(1, 3, 4, 7, 1, 2, 6)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(1, 3, 4, 1, 2, 6), result.toList())
    }

    @Test
    fun `deletes middle node from even-length list for second example`() {
        val head = listNodeOf(1, 2, 3, 4)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(1, 2, 4), result.toList())
    }

    @Test
    fun `deletes second node from two-node list for third example`() {
        val head = listNodeOf(2, 1)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(2), result.toList())
    }

    @Test
    fun `returns null when deleting the only node from a single-node list`() {
        val head = listNodeOf(1)
        val result = solution.deleteMiddle(head)
        assertNull(result)
    }

    @Test
    fun `deletes middle node from three-node list`() {
        val head = listNodeOf(1, 2, 3)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(1, 3), result.toList())
    }

    @Test
    fun `deletes middle node from five-node list`() {
        val head = listNodeOf(1, 2, 3, 4, 5)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(1, 2, 4, 5), result.toList())
    }

    @Test
    fun `deletes middle node from six-node list`() {
        val head = listNodeOf(1, 2, 3, 4, 5, 6)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(1, 2, 3, 5, 6), result.toList())
    }

    @Test
    fun `handles lists with duplicate values`() {
        val head = listNodeOf(7, 7, 7, 7)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(7, 7, 7), result.toList())
    }

    @Test
    fun `handles nodes with values at constraint boundaries`() {
        val head = listNodeOf(100_000, 1)
        val result = solution.deleteMiddle(head)
        assertEquals(listOf(100_000), result.toList())
    }
}
