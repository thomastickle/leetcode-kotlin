package leetcode.p0328

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * # 328. Odd Even Linked List
 *
 * Given the `head` of a singly linked list, group all the nodes with odd indices together
 * followed by the nodes with even indices, and return the reordered list.
 *
 * The **first** node is considered **odd**, and the **second** node is **even**, and so on.
 *
 * Note that the relative order inside both the even and odd groups should remain as it was in
 * the input.
 *
 * You must solve the problem in `O(1)` extra space complexity and `O(n)` time complexity.
 *
 * Examples:
 * - Input: `head = [1,2,3,4,5]`. Output: `[1,3,5,2,4]`.
 * - Input: `head = [2,1,3,5,6,4,7]`. Output: `[2,3,6,7,1,5,4]`.
 *   Explanation:
 *   Odd nodes are nodes 1, 3, 5, 7 with values `[2, 3, 6, 7]`.
 *   Even nodes are nodes 2, 4, 6 with values `[1, 5, 4]`.
 *   Reordered list: `[2, 3, 6, 7, 1, 5, 4]`.
 *
 * Constraints:
 * - The number of nodes in the linked list is in the range `[0, 10^4]`.
 * - `-10^6 <= Node.val <= 10^6`
 *
 * [LeetCode 328: Odd Even Linked List](https://leetcode.com/problems/odd-even-linked-list/)
 */
class Solution {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return head
        }

        var odd = head
        var even = head.next
        val evenHead = even

        while (even?.next != null) {
            odd!!.next = even.next
            odd = odd.next

            even.next = odd!!.next
            even = even.next
        }

        odd.next = evenHead

        return head
    }
}
