package leetcode.p2095

class ListNode(var `val`: Int) {
    var next: ListNode? = null
}

/**
 * # 2095. Delete the Middle Node of a Linked List
 *
 * You are given the `head` of a linked list. Delete the **middle node**, and return the `head` of
 * the modified linked list.
 *
 * The **middle node** of a linked list of size `n` is the `⌊n / 2⌋`th node from the **start** using
 * 0-based indexing, where `⌊x⌋` denotes the largest integer less than or equal to `x`.
 *
 * - For `n = 1`, `2`, `3`, `4`, and `5`, the middle nodes are `0`, `1`, `1`, `2`, and `2`, respectively.
 *
 * Examples:
 * - Input: `head = [1,3,4,7,1,2,6]`. Output: `[1,3,4,1,2,6]`.
 *   Explanation:
 *   The indices of the nodes are 0-based. Since `n = 7`, node 3 with value `7` is the middle node.
 *   We return the new list after removing this node.
 * - Input: `head = [1,2,3,4]`. Output: `[1,2,4]`.
 *   Explanation:
 *   For `n = 4`, node 2 with value `3` is the middle node.
 * - Input: `head = [2,1]`. Output: `[2]`.
 *   Explanation:
 *   For `n = 2`, node 1 with value `1` is the middle node. Node 0 with value `2` is the only node
 *   remaining after removing node 1.
 *
 * Constraints:
 * - The number of nodes in the list is in the range `[1, 10^5]`.
 * - `1 <= Node.val <= 10^5`
 *
 * [LeetCode 2095: Delete the Middle Node of a Linked List](https://leetcode.com/problems/delete-the-middle-node-of-a-linked-list/)
 */
class Solution {
    fun deleteMiddle(head: ListNode?): ListNode? {
        if (head?.next == null) {
            return null
        }

        var fastPointer = head
        var slowPointer = head
        var previousSlowPointer: ListNode? = null

        while (fastPointer?.next != null) {
            previousSlowPointer = slowPointer
            slowPointer = slowPointer?.next
            fastPointer = fastPointer.next?.next
        }

        previousSlowPointer?.next = slowPointer?.next

        return head
    }
}
