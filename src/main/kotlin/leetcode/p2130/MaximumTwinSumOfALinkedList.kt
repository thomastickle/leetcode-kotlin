package leetcode.p2130

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * # 2130. Maximum Twin Sum of a Linked List
 *
 * In a linked list of size `n`, where `n` is **even**, the `i`th node (**0-indexed**) of the
 * linked list is known as the **twin** of the `(n - 1 - i)`th node, if `0 <= i <= (n / 2) - 1`.
 *
 * - For example, if `n = 4`, node `0` is the twin of node `3`, and node `1` is the twin of node `2`.
 *   These are the only nodes with twins for `n = 4`.
 *
 * The **twin sum** is defined as the sum of a node and its twin.
 *
 * Given the `head` of a linked list with even length, return *the **maximum twin sum** of the linked list*.
 *
 * Examples:
 * - Input: `head = [5,4,2,1]`. Output: `6`.
 *   Explanation:
 *   Nodes 0 and 1 are the twins of nodes 3 and 2, respectively. Both have twin sum = 6.
 *   There are no other nodes with twins in the linked list.
 *   Thus, the maximum twin sum of the linked list is 6.
 * - Input: `head = [4,2,2,3]`. Output: `7`.
 *   Explanation:
 *   The nodes with twins present in this linked list are:
 *   - Node 0 is the twin of node 3 having a twin sum of 4 + 3 = 7.
 *   - Node 1 is the twin of node 2 having a twin sum of 2 + 2 = 4.
 *   Thus, the maximum twin sum of the linked list is max(7, 4) = 7.
 * - Input: `head = [1,100000]`. Output: `100001`.
 *   Explanation:
 *   There is only one node with a twin in the linked list having twin sum of 1 + 100000 = 100001.
 *
 * Constraints:
 * - The number of nodes in the list is an even integer in the range `[2, 10^5]`.
 * - `1 <= Node.val <= 10^5`
 *
 * [LeetCode 2130: Maximum Twin Sum of a Linked List](https://leetcode.com/problems/maximum-twin-sum-of-a-linked-list/)
 */
class Solution {
    fun pairSum(head: ListNode?): Int {
        var slowPointer = head
        var fastPointer = head

        while (fastPointer?.next?.next != null) {
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
        }

        var reversedHalf = reverse(slowPointer?.next, null)

        var maxSum = Integer.MIN_VALUE
        var frontHalfPointer = head
        while (reversedHalf != null ) {
            val sum = reversedHalf.`val` + frontHalfPointer!!.`val`
            maxSum = maxOf(maxSum, sum)
            reversedHalf = reversedHalf.next
            frontHalfPointer = frontHalfPointer.next
        }

        return maxSum
    }

    private tailrec fun reverse(current: ListNode?, previous: ListNode?): ListNode? {
        if (current == null) {
            return previous
        }
        val next = current.next
        current.next = previous
        return reverse(next, current)
    }
}
