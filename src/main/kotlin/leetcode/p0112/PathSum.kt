package leetcode.p0112

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 112. Path Sum
 *
 * Given the `root` of a binary tree and an integer `targetSum`, return `true` if the tree has a
 * root-to-leaf path such that adding all the values along the path equals `targetSum`.
 *
 * A **leaf** is a node with no children.
 *
 * Examples:
 * - Input: `root = [5,4,8,11,null,13,4,7,2,null,null,null,1]`, `targetSum = 22`. Output: `true`.
 *   The path `5 -> 4 -> 11 -> 2` has sum `22`.
 * - Input: `root = [1,2,3]`, `targetSum = 5`. Output: `false`.
 *   There is no root-to-leaf path whose sum is `5`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[0, 5000]`.
 * - `-1000 <= Node.val <= 1000`
 * - `-1000 <= targetSum <= 1000`
 *
 * [LeetCode 112: Path Sum](https://leetcode.com/problems/path-sum/)
 */
class Solution {
    fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
        fun dfs(node: TreeNode?, currentSum: Int): Boolean {
            if (node == null) {
                return false
            }

            val newSum = currentSum + node.`val`

            if (node.left == null && node.right == null) {
                return newSum == targetSum
            }

            return dfs(node.left, newSum) || dfs(node.right, newSum)
        }

        return root != null && dfs(root, 0)
    }
}
