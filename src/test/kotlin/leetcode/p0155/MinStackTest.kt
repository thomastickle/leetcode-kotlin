package leetcode.p0155

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MinStackTest {
    @Test
    fun `executes the operation sequence from the example`() {
        val minStack = MinStack()

        minStack.push(-2)
        minStack.push(0)
        minStack.push(-3)
        assertEquals(-3, minStack.getMin())

        minStack.pop()
        assertEquals(0, minStack.top())
        assertEquals(-2, minStack.getMin())
    }

    @Test
    fun `keeps the minimum when duplicate minimum values remain`() {
        val minStack = MinStack()

        minStack.push(2)
        minStack.push(0)
        minStack.push(0)
        minStack.push(3)
        minStack.pop()
        assertEquals(0, minStack.getMin())
        minStack.pop()
        assertEquals(0, minStack.getMin())
    }

    @Test
    fun `updates the minimum after removing the current minimum`() {
        val minStack = MinStack()

        minStack.push(3)
        minStack.push(1)
        minStack.push(2)
        assertEquals(1, minStack.getMin())

        minStack.pop()
        assertEquals(1, minStack.getMin())
        minStack.pop()
        assertEquals(3, minStack.getMin())
        assertEquals(3, minStack.top())
    }

    @Test
    fun `supports the integer value boundaries`() {
        val minStack = MinStack()

        minStack.push(Int.MAX_VALUE)
        minStack.push(Int.MIN_VALUE)
        assertEquals(Int.MIN_VALUE, minStack.getMin())
        assertEquals(Int.MIN_VALUE, minStack.top())

        minStack.pop()
        assertEquals(Int.MAX_VALUE, minStack.getMin())
        assertEquals(Int.MAX_VALUE, minStack.top())
    }
}
