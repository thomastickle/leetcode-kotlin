package leetcode.p0150

/**
 * # 150. Evaluate Reverse Polish Notation
 *
 * Evaluate the value of an arithmetic expression written in Reverse Polish Notation (RPN).
 *
 * Valid operators are `+`, `-`, `*`, and `/`. Each operand may be an integer or another
 * expression. Division between two integers must truncate toward zero.
 *
 * The input is guaranteed to represent a valid arithmetic expression. The division operation will
 * never divide by zero. The result and all intermediate calculations fit in a 32-bit signed integer.
 *
 * Examples:
 * - Input: `tokens = ["2", "1", "+", "3", "*"]`. Output: `9`.
 *   Explanation: `((2 + 1) * 3) = 9`.
 * - Input: `tokens = ["4", "13", "5", "/", "+"]`. Output: `6`.
 *   Explanation: `(4 + (13 / 5)) = 6`.
 * - Input: `tokens = ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]`. Output: `22`.
 *   Explanation: `((10 * (6 / ((9 + 3) * -11))) + 17) + 5 = 22`.
 *
 * Constraints:
 * - `1 <= tokens.length <= 10^4`.
 * - `tokens[i]` is either an operator (`+`, `-`, `*`, or `/`) or an integer in the range
 *   `[-200, 200]`.
 * - The input represents a valid arithmetic expression in Reverse Polish Notation.
 * - The division operation will never divide by zero.
 * - The result and all intermediate calculations fit in a 32-bit signed integer.
 *
 * [LeetCode 150: Evaluate Reverse Polish Notation](https://leetcode.com/problems/evaluate-reverse-polish-notation/)
 */
class Solution {
    fun evalRPN(tokens: Array<String>): Int {
        val stack = IntArray(tokens.size)
        var top = 0
        for (token in tokens) {
            when (token) {
                "+" -> {
                    stack[top -2] += stack[top-1]
                    top--
                }
                "-" -> {
                    stack[top-2] -= stack[top-1]
                    top--
                }
                "*" -> {
                    stack[top-2] *= stack[top-1]
                    top--
                }
                "/" -> {
                    stack[top-2] /= stack[top-1]
                    top--
                }
                else -> {
                    stack[top++] = token.toInt()
                }
            }
        }
        return stack[0]
    }
}
