package leetcode.p0236

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 236. Lowest Common Ancestor of a Binary Tree
 *
 * Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
 *
 * According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between
 * two nodes `p` and `q` as the lowest node in `T` that has both `p` and `q` as descendants (where
 * we allow a node to be a descendant of itself)."
 *
 * Examples:
 * - Input: `root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1`. Output: `3`.
 *   Explanation: The LCA of nodes 5 and 1 is node 3.
 * - Input: `root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4`. Output: `5`.
 *   Explanation: The LCA of nodes 5 and 4 is node 5, since a node can be a descendant of itself
 *   according to the LCA definition.
 * - Input: `root = [1,2], p = 1, q = 2`. Output: `1`.
 *   Explanation: The LCA of nodes 1 and 2 is node 1.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[2, 10^5]`.
 * - `-10^9 <= Node.val <= 10^9`.
 * - All `Node.val` are unique.
 * - `p != q`.
 * - `p` and `q` will exist in the tree.
 *
 * Follow-up: Can you find the LCA of `p` and `q` in one traversal?
 *
 * [LeetCode 236: Lowest Common Ancestor of a Binary Tree](https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/)
 */
class Solution {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (root == null || root === p || root === q) {
            return root
        }

        val left = lowestCommonAncestor(root.left, p, q)
        val right = lowestCommonAncestor(root.right, p, q)

        if (left != null && right != null) {
            return root
        }

        return left ?: right
    }
}
