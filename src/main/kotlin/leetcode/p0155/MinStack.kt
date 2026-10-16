package leetcode.p0155

/**
 * # 155. Min Stack
 *
 * Design a stack that supports pushing elements, removing the top element, reading the top
 * element, and retrieving the minimum element in constant time.
 *
 * Implement the `MinStack` class:
 * - `MinStack()` initializes the stack object.
 * - `void push(int val)` pushes the element `val` onto the stack.
 * - `void pop()` removes the element on the top of the stack.
 * - `int top()` gets the top element of the stack.
 * - `int getMin()` retrieves the minimum element in the stack.
 *
 * Each function must run in `O(1)` time.
 *
 * Example 1:
 * - Input: `operations = ["MinStack", "push", "push", "push", "getMin", "pop", "top", "getMin"]`.
 * - Arguments: `[[], [-2], [0], [-3], [], [], [], []]`.
 * - Output: `[null, null, null, null, -3, null, 0, -2]`.
 * - Explanation:
 *   ```
 *   MinStack minStack = new MinStack();
 *   minStack.push(-2);
 *   minStack.push(0);
 *   minStack.push(-3);
 *   minStack.getMin(); // returns -3
 *   minStack.pop();
 *   minStack.top();    // returns 0
 *   minStack.getMin(); // returns -2
 *   ```
 *
 * Constraints:
 * - `-2^31 <= val <= 2^31 - 1`.
 * - The methods `pop`, `top`, and `getMin` will always be called on non-empty stacks.
 * - At most `3 * 10^4` calls will be made to `push`, `pop`, `top`, and `getMin`.
 *
 * The problem statement does not include a follow-up question.
 *
 * [LeetCode 155: Min Stack](https://leetcode.com/problems/min-stack/)
 */
class MinStack {
    private class StackEntry(val value: Int, val lowestValue: Int)
    private val stack = ArrayList<StackEntry>()

    fun push(`val`: Int) {
        val lowest = if (stack.isEmpty()) `val` else minOf(`val`, stack.last().lowestValue)
        val stackEntry = StackEntry(`val`, lowest)
        stack.add(stackEntry)
    }

    fun pop() {
        stack.removeLast()
    }

    fun top(): Int {
        return stack.last().value
    }

    fun getMin(): Int {
        return stack.last().lowestValue
    }
}
