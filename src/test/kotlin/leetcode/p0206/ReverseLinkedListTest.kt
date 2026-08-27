package leetcode.p0206

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class ReverseLinkedListTest {
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
    fun `reverses multi-node list for first example`() {
        val head = listNodeOf(1, 2, 3, 4, 5)
        val result = solution.reverseList(head)
        assertEquals(listOf(5, 4, 3, 2, 1), result.toList())
    }

    @Test
    fun `reverses two-node list for second example`() {
        val head = listNodeOf(1, 2)
        val result = solution.reverseList(head)
        assertEquals(listOf(2, 1), result.toList())
    }

    @Test
    fun `returns null for an empty list`() {
        val result = solution.reverseList(null)
        assertNull(result)
    }

    @Test
    fun `returns single node list unchanged`() {
        val head = listNodeOf(1)
        val result = solution.reverseList(head)
        assertEquals(listOf(1), result.toList())
    }

    @Test
    fun `reverses three-node list`() {
        val head = listNodeOf(1, 2, 3)
        val result = solution.reverseList(head)
        assertEquals(listOf(3, 2, 1), result.toList())
    }

    @Test
    fun `reverses list with duplicate values`() {
        val head = listNodeOf(1, 2, 2, 1)
        val result = solution.reverseList(head)
        assertEquals(listOf(1, 2, 2, 1), result.toList())
    }

    @Test
    fun `reverses list with all identical values`() {
        val head = listNodeOf(7, 7, 7, 7)
        val result = solution.reverseList(head)
        assertEquals(listOf(7, 7, 7, 7), result.toList())
    }

    @Test
    fun `handles nodes with values at constraint boundaries`() {
        val head = listNodeOf(-5000, 0, 5000)
        val result = solution.reverseList(head)
        assertEquals(listOf(5000, 0, -5000), result.toList())
    }
}
