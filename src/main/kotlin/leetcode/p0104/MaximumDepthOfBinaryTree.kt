package leetcode.p0104

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 104. Maximum Depth of Binary Tree
 *
 * Given the `root` of a binary tree, return *its maximum depth*.
 *
 * A binary tree's **maximum depth** is the number of nodes along the longest path from the root node
 * down to the farthest leaf node.
 *
 * Examples:
 * - Input: `root = [3,9,20,null,null,15,7]`. Output: `3`.
 * - Input: `root = [1,null,2]`. Output: `2`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[0, 10^4]`.
 * - `-100 <= Node.val <= 100`
 *
 * [LeetCode 104: Maximum Depth of Binary Tree](https://leetcode.com/problems/maximum-depth-of-binary-tree/)
 */
class Solution {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) {
            0
        } else {
            1 + maxOf(maxDepth(root.left), maxDepth(root.right))
        }
    }
}
