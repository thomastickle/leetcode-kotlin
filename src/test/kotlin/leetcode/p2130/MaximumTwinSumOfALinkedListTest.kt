package leetcode.p2130

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumTwinSumOfALinkedListTest {
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

    @Test
    fun `calculates maximum twin sum for first example`() {
        val head = listNodeOf(5, 4, 2, 1)
        val result = solution.pairSum(head)
        assertEquals(6, result)
    }

    @Test
    fun `calculates maximum twin sum for second example`() {
        val head = listNodeOf(4, 2, 2, 3)
        val result = solution.pairSum(head)
        assertEquals(7, result)
    }

    @Test
    fun `calculates maximum twin sum for two-node list in third example`() {
        val head = listNodeOf(1, 100000)
        val result = solution.pairSum(head)
        assertEquals(100001, result)
    }

    @Test
    fun `calculates maximum twin sum for minimal two-node list`() {
        val head = listNodeOf(1, 1)
        val result = solution.pairSum(head)
        assertEquals(2, result)
    }

    @Test
    fun `calculates maximum twin sum for boundary values`() {
        val head = listNodeOf(100_000, 100_000)
        val result = solution.pairSum(head)
        assertEquals(200_000, result)
    }

    @Test
    fun `calculates maximum twin sum when inner twins produce maximum`() {
        val head = listNodeOf(1, 10, 1, 1, 10, 1)
        val result = solution.pairSum(head)
        assertEquals(20, result)
    }

    @Test
    fun `calculates maximum twin sum when outer twins produce maximum`() {
        val head = listNodeOf(100, 1, 1, 1, 1, 100)
        val result = solution.pairSum(head)
        assertEquals(200, result)
    }

    @Test
    fun `calculates maximum twin sum for list with identical values`() {
        val head = listNodeOf(5, 5, 5, 5)
        val result = solution.pairSum(head)
        assertEquals(10, result)
    }
}
