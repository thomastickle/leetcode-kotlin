package leetcode.p0872

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 872. Leaf-Similar Trees
 *
 * Consider all the leaves of a binary tree, from left to right order, the values of those leaves
 * form a **leaf value sequence**.
 *
 * For example, in the given tree `[3,5,1,6,2,9,8,null,null,7,4]`, the leaf value sequence is `(6, 7, 4, 9, 8)`.
 *
 * Two binary trees are considered *leaf-similar* if their leaf value sequence is the same.
 *
 * Return `true` if and only if the two given trees with head nodes `root1` and `root2` are leaf-similar.
 *
 * Examples:
 * - Input: `root1 = [3,5,1,6,2,9,8,null,null,7,4], root2 = [3,5,1,6,7,4,2,null,null,null,null,null,null,9,8]`. Output: `true`.
 * - Input: `root1 = [1,2,3], root2 = [1,3,2]`. Output: `false`.
 *
 * Constraints:
 * - The number of nodes in each tree will be in the range `[1, 200]`.
 * - Both of the given trees will have values in the range `[0, 200]`.
 *
 * [LeetCode 872: Leaf-Similar Trees](https://leetcode.com/problems/leaf-similar-trees/)
 */
class Solution {
    fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
        fun findLeaves(node: TreeNode?, leaves: MutableList<Int>) {
            if (node == null) {
                return
            }

            if (node.left == null && node.right == null) {
                leaves.add(node.`val`)
                return
            }

            findLeaves(node.left, leaves)
            findLeaves(node.right, leaves)
        }

        val firstLeaves = mutableListOf<Int>()
        val secondLeaves = mutableListOf<Int>()

        findLeaves(root1, firstLeaves)
        findLeaves(root2, secondLeaves)

        return firstLeaves == secondLeaves
    }
}