package leetcode.p0113

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 113. Path Sum II
 *
 * Given the `root` of a binary tree and an integer `targetSum`, return all root-to-leaf paths where
 * the sum of the node values along each path equals `targetSum`. A root-to-leaf path starts at the
 * root and ends at a leaf, and a leaf is a node with no children.
 *
 * Return the paths in any order.
 *
 * Examples:
 * - Input: `root = [5,4,8,11,null,13,4,7,2,null,null,5,1], targetSum = 22`. Output:
 *   `[[5,4,11,2],[5,8,4,5]]`.
 * - Input: `root = [1,2,3], targetSum = 5`. Output: `[]`.
 * - Input: `root = [1,2], targetSum = 0`. Output: `[]`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[0, 5000]`.
 * - `-1000 <= Node.val <= 1000`.
 * - `-1000 <= targetSum <= 1000`.
 *
 * [LeetCode 113: Path Sum II](https://leetcode.com/problems/path-sum-ii/)
 */
class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        val outputList: MutableList<List<Int>> = mutableListOf()

        fun dfs(node: TreeNode, currentSum: Int, nodeList: MutableList<Int>) {

            val newSum = node.`val` + currentSum
            nodeList.add(node.`val`)
            if (node.left == null && node.right == null && newSum == targetSum) {
                outputList.add(nodeList.toList())
            }

            if (node.left != null) {
              dfs(node.left!!, newSum, nodeList)
            }

            if (node.right != null) {
                dfs(node.right!!, newSum, nodeList)
            }

            nodeList.removeLast()
        }

        if (root != null) {
            dfs(root, 0, mutableListOf())
        }

        return outputList
    }
}