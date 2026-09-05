package leetcode.p0700

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 700. Search in a Binary Search Tree
 *
 * You are given the `root` of a binary search tree (BST) and an integer `val`.
 *
 * Find the node in the BST that the node's value equals `val` and return the subtree rooted with that node.
 * If such a node does not exist, return `null`.
 *
 * Examples:
 * - Input: `root = [4,2,7,1,3], val = 2`. Output: `[2,1,3]`.
 * - Input: `root = [4,2,7,1,3], val = 5`. Output: `[]`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[1, 5000]`.
 * - `1 <= Node.val <= 10^7`
 * - `root` is a binary search tree.
 * - `1 <= val <= 10^7`
 *
 * [LeetCode 700: Search in a Binary Search Tree](https://leetcode.com/problems/search-in-a-binary-search-tree/)
 */
class Solution {
    fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
        var node = root

        while (node != null) {
            val nodeValue = node.`val`

            if (nodeValue == `val`) {
                return node
            }

            node = if (nodeValue > `val`) {
                node.left
            } else {
                node.right
            }
        }

        return null
    }
}
