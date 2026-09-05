package leetcode.p0199

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 199. Binary Tree Right Side View
 *
 * Given the `root` of a binary tree, imagine yourself standing on the right side of it.
 * Return the values of the nodes you can see ordered from top to bottom.
 *
 * Examples:
 * - Input: `root = [1,2,3,null,5,null,4]`. Output: `[1,3,4]`.
 * - Input: `root = [1,null,3]`. Output: `[1,3]`.
 * - Input: `root = []`. Output: `[]`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[0, 100]`.
 * - `-100 <= Node.val <= 100`.
 *
 * [LeetCode 199: Binary Tree Right Side View](https://leetcode.com/problems/binary-tree-right-side-view/)
 */
class Solution {
    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) return emptyList()

        val output = mutableListOf<Int>()
        val queue = ArrayDeque<TreeNode>()
        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size

            repeat(levelSize) { index ->
                val node = queue.removeFirst()

                if (index == levelSize - 1) {
                    output.add(node.`val`)
                }

                node.left?.let(queue::addLast)
                node.right?.let(queue::addLast)
            }
        }

        return output
    }
}
