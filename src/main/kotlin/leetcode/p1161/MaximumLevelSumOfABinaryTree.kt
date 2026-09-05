package leetcode.p1161

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 1161. Maximum Level Sum of a Binary Tree
 *
 * Given the `root` of a binary tree, the level of a node is the number of edges along the shortest
 * path between that node and the root. The root is at level 1, its children are at level 2, and so
 * on.
 *
 * Return the smallest level `x` such that the sum of all node values at level `x` is maximal among
 * all levels in the tree.
 *
 * Examples:
 * - Input: `root = [1,7,0,7,-8,null,null]`. Output: `2`.
 *   Explanation: The sum of values at level 1 is `1`, and the sum at level 2 is `7 + 0 = 7`.
 *   The sum at level 3 is `7 + (-8) = -1`, so level 2 has the maximum sum.
 * - Input: `root = [989,null,10250,98693,-89388,null,null,null,-32127]`. Output: `2`.
 *   Explanation: The sum of values at level 1 is `989`, the sum at level 2 is `10250`, and the
 *   sum at level 3 is `98693 + (-89388) = -695`. The remaining node is at level 4, so level 2
 *   has the maximum sum.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[1, 10^4]`.
 * - `-10^5 <= Node.val <= 10^5`.
 *
 * [LeetCode 1161: Maximum Level Sum of a Binary Tree](https://leetcode.com/problems/maximum-level-sum-of-a-binary-tree/)
 */
class Solution {
    fun maxLevelSum(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }

        val queue = ArrayDeque<TreeNode>()
        var level = 1
        var maxSum = Int.MIN_VALUE
        var maxSumLevel = 0

        queue.addLast(root)

        while (queue.isNotEmpty()) {
            val levelSize = queue.size
            var sum = 0
            repeat(levelSize) {
                val node = queue.removeFirst()
                sum += node.`val`

                node.left?.let(queue::addLast)
                node.right?.let(queue::addLast)
            }

            if (sum > maxSum) {
                maxSum = sum
                maxSumLevel = level
            }

            level++

        }

        return maxSumLevel
    }
}
