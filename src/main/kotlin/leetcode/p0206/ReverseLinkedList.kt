package leetcode.p0206

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * # 206. Reverse Linked List
 *
 * Given the `head` of a singly linked list, reverse the list, and return the reversed list.
 *
 * Examples:
 * - Input: `head = [1,2,3,4,5]`. Output: `[5,4,3,2,1]`.
 * - Input: `head = [1,2]`. Output: `[2,1]`.
 * - Input: `head = []`. Output: `[]`.
 *
 * Constraints:
 * - The number of nodes in the list is the range `[0, 5000]`.
 * - `-5000 <= Node.val <= 5000`
 *
 * Follow-up: A linked list can be reversed either iteratively or recursively. Could you implement both?
 *
 * [LeetCode 206: Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)
 */
class Solution {
    fun reverseList(head: ListNode?): ListNode? {
        tailrec fun reverse(current: ListNode?, previous: ListNode?): ListNode? {
            if (current == null ) {
                return previous
            }

            val next = current.next
            current.next = previous

            return reverse(next, current)
        }

        return reverse(head, null)
    }
}
