package leetcode.p0328

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Test

class OddEvenLinkedListTest {
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
    fun `reorders odd and even nodes for the first example`() {
        val head = listNodeOf(1, 2, 3, 4, 5)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(1, 3, 5, 2, 4), result.toList())
    }

    @Test
    fun `reorders odd and even nodes for the second example`() {
        val head = listNodeOf(2, 1, 3, 5, 6, 4, 7)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(2, 3, 6, 7, 1, 5, 4), result.toList())
    }

    @Test
    fun `returns null for an empty list`() {
        val result = solution.oddEvenList(null)
        assertNull(result)
    }

    @Test
    fun `returns single node unchanged`() {
        val head = listNodeOf(1)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(1), result.toList())
    }

    @Test
    fun `leaves two-node list in original order`() {
        val head = listNodeOf(1, 2)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(1, 2), result.toList())
    }

    @Test
    fun `reorders three-node list`() {
        val head = listNodeOf(1, 2, 3)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(1, 3, 2), result.toList())
    }

    @Test
    fun `reorders four-node list`() {
        val head = listNodeOf(1, 2, 3, 4)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(1, 3, 2, 4), result.toList())
    }

    @Test
    fun `handles duplicate values across odd and even positions`() {
        val head = listNodeOf(2, 2, 2, 2)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(2, 2, 2, 2), result.toList())
    }

    @Test
    fun `handles negative values and boundary numbers`() {
        val head = listNodeOf(-1_000_000, 1_000_000, 0)
        val result = solution.oddEvenList(head)
        assertEquals(listOf(-1_000_000, 0, 1_000_000), result.toList())
    }
}
