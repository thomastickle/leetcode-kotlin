package leetcode.p0450

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 450. Delete Node in a BST
 *
 * Given the root node of a binary search tree and an integer `key`, delete the node whose value
 * equals `key` from the tree. Return the root node of the resulting binary search tree, which may
 * be different from the original root.
 *
 * The binary search tree property must be preserved after deletion. If no node has value `key`,
 * return the tree unchanged.
 *
 * Examples:
 * - Input: `root = [5,3,6,2,4,null,7]`, `key = 3`. Output: `[5,4,6,2,null,null,7]`.
 *   Explanation: The node with value 3 is deleted and the resulting tree remains a valid BST.
 * - Input: `root = [5,3,6,2,4,null,7]`, `key = 0`. Output: `[5,3,6,2,4,null,7]`.
 *   Explanation: There is no node with value 0, so the tree is unchanged.
 * - Input: `root = []`, `key = 0`. Output: `[]`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[0, 10^4]`.
 * - `-10^5 <= Node.val <= 10^5`.
 * - All `Node.val` values are unique.
 * - `root` is a valid binary search tree.
 * - `-10^5 <= key <= 10^5`.
 *
 * [LeetCode 450: Delete Node in a BST](https://leetcode.com/problems/delete-node-in-a-bst/)
 */
class Solution {
    fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
        if (root == null) return null

        if (root.`val` < key) {
            root.right = deleteNode(root.right, key)
            return root
        }

        if (root.`val` > key) {
            root.left = deleteNode(root.left, key)
            return root
        }

        if (root.left == null) return root.right
        if (root.right == null) return root.left

        var successorParent = root
        var successor = root.right!!

        while (successor.left != null) {
            successorParent = successor
            successor = successor.left!!
        }

        if (successorParent !== root) {
            successorParent.left = successor.right
            successor.right = root.right
        }

        successor.left = root.left

        return successor
    }
}
