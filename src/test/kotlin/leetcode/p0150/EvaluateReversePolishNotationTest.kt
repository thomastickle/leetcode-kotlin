package leetcode.p0150

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EvaluateReversePolishNotationTest {
    private val solution = Solution()

    @Test
    fun `evaluates the first example`() {
        assertEquals(9, solution.evalRPN(arrayOf("2", "1", "+", "3", "*")))
    }

    @Test
    fun `evaluates the second example with integer division`() {
        assertEquals(6, solution.evalRPN(arrayOf("4", "13", "5", "/", "+")))
    }

    @Test
    fun `evaluates the third example with nested operations and negatives`() {
        assertEquals(
            22,
            solution.evalRPN(
                arrayOf("10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"),
            ),
        )
    }

    @Test
    fun `returns a single operand unchanged`() {
        assertEquals(7, solution.evalRPN(arrayOf("7")))
    }

    @Test
    fun `preserves operand order for subtraction and division`() {
        assertEquals(-3, solution.evalRPN(arrayOf("4", "7", "-")))
        assertEquals(2, solution.evalRPN(arrayOf("8", "4", "/")))
    }

    @Test
    fun `truncates negative division toward zero`() {
        assertEquals(-2, solution.evalRPN(arrayOf("7", "-3", "/")))
    }

    @Test
    fun `supports the integer result boundaries`() {
        val maxIntTokens = buildList {
            add("2")
            repeat(29) {
                add("2")
                add("*")
            }
            add("1")
            add("-")
            add("2")
            add("*")
            add("1")
            add("+")
        }.toTypedArray()
        val minIntTokens = buildList {
            add("-2")
            repeat(30) {
                add("2")
                add("*")
            }
        }.toTypedArray()

        assertEquals(Int.MAX_VALUE, solution.evalRPN(maxIntTokens))
        assertEquals(Int.MIN_VALUE, solution.evalRPN(minIntTokens))
    }
}
