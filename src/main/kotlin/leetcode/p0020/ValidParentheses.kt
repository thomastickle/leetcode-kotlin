package leetcode.p0020

/**
 * # 20. Valid Parentheses
 *
 * Given a string `s` containing only the characters `(`, `)`, `{`, `}`, `[` and `]`, determine
 * whether the input string is valid.
 *
 * An input string is valid when all of the following rules hold:
 * 1. Every opening bracket is closed by a bracket of the same type.
 * 2. Opening brackets are closed in the correct order.
 * 3. Every closing bracket has a corresponding earlier opening bracket of the same type.
 *
 * Examples:
 * - Input: `s = "()"`, Output: `true`.
 * - Input: `s = "()[]{}"`, Output: `true`.
 * - Input: `s = "(]"`, Output: `false`.
 * - Input: `s = "([])"`, Output: `true`.
 * - Input: `s = "([)]"`, Output: `false`.
 *
 * Constraints:
 * - `1 <= s.length <= 10^4`
 * - `s` consists only of the parentheses characters `()[]{}`.
 *
 * The problem statement does not include a follow-up question.
 *
 * [LeetCode 20: Valid Parentheses](https://leetcode.com/problems/valid-parentheses/)
 */
class Solution {

    fun isValid(s: String): Boolean {
        val stack = java.util.ArrayDeque<Char>()

        for (symbol in s) {
            when (symbol) {
                '(' -> stack.addLast(')')
                '[' -> stack.addLast(']')
                '{' -> stack.addLast('}')
                else -> if (stack.pollLast() != symbol) return false
            }
        }

        return stack.isEmpty()
    }
}
