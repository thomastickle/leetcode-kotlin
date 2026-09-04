package leetcode.p1372

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 1372. Longest ZigZag Path in a Binary Tree
 *
 * You are given the `root` of a binary tree.
 *
 * A ZigZag path for a binary tree is defined as follow:
 * - Choose any node in the binary tree and a direction (right or left).
 * - If the current direction is right, move to the right child of the current node; otherwise, move to the left child.
 * - Change the direction from right to left or from left to right.
 * - Repeat the second and third steps until you can't move in the tree.
 *
 * Zigzag length is defined as the number of nodes visited - 1. (A single node has a length of 0).
 *
 * Return the longest ZigZag path contained in that tree.
 *
 * Examples:
 * - Input: `root = [1,null,1,1,1,null,null,1,1,null,1,null,null,null,1]`. Output: `3`.
 *   Explanation: Longest ZigZag path in blue nodes (right -> left -> right).
 * - Input: `root = [1,1,1,null,1,null,null,1,1,null,1]`. Output: `4`.
 *   Explanation: Longest ZigZag path in blue nodes (left -> right -> left -> right).
 * - Input: `root = [1]`. Output: `0`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[1, 5 * 10^4]`.
 * - `1 <= Node.val <= 100`
 *
 * [LeetCode 1372: Longest ZigZag Path in a Binary Tree](https://leetcode.com/problems/longest-zigzag-path-in-a-binary-tree/)
 */
class Solution {

    fun longestZigZag(root: TreeNode?): Int {
        fun longZigZag(node: TreeNode?, length: Int, lastMoveWasLeft: Boolean): Int {
            if (node == null) {
                return length - 1
            }

            val leftLength = if (lastMoveWasLeft) 1 else length + 1
            val rightLength = if (lastMoveWasLeft) length + 1 else 1
            return maxOf(longZigZag(node.left, leftLength, true), longZigZag(node.right, rightLength, false))
        }

        if (root == null) {
            return 0
        }

        val leftPath = longZigZag(root.left, 1, true)
        val rightPath = longZigZag(root.right, 1, false)

        return maxOf(leftPath, rightPath)
    }
}
