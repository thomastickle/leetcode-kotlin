package leetcode.p0437

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

/**
 * # 437. Path Sum III
 *
 * Given the `root` of a binary tree and an integer `targetSum`, return the number of paths where
 * the sum of the values along the path equals `targetSum`.
 *
 * The path does not need to start at the root or end at a leaf, but it must travel downwards,
 * meaning that each next node on the path is a child of the previous node.
 *
 * Examples:
 * - Input: `root = [10,5,-3,3,2,null,11,3,-2,null,1]`, `targetSum = 8`. Output: `3`.
 *   The three paths are `5 -> 3`, `5 -> 2 -> 1`, and `-3 -> 11`.
 * - Input: `root = [5,4,8,11,null,13,4,7,2,null,null,5,1]`, `targetSum = 22`. Output: `3`.
 *
 * Constraints:
 * - The number of nodes in the tree is in the range `[0, 1000]`.
 * - `-10^9 <= Node.val <= 10^9`
 * - `-10^9 <= targetSum <= 10^9`
 *
 * [LeetCode 437: Path Sum III](https://leetcode.com/problems/path-sum-iii/)
 */
class Solution {
    fun pathSum(root: TreeNode?, targetSum: Int): Int {
        val prefixMap = mutableMapOf<Long, Int>()
        fun computePathCount(node: TreeNode?, currentSum: Long): Int {
            if (node == null) {
                return 0
            }

            val newSum = currentSum + node.`val`
            val currentPathCount = prefixMap.getOrDefault(newSum - targetSum, 0)

            val incrementedPrefixCount = prefixMap.getOrDefault(newSum, 0) + 1
            prefixMap.put(newSum, incrementedPrefixCount)

            val leftCount = computePathCount(node.left, newSum)
            val rightCount = computePathCount(node.right, newSum)

            if (incrementedPrefixCount == 1) {
                prefixMap.remove(newSum)
            } else {
                prefixMap.put(newSum, incrementedPrefixCount - 1)
            }

            return currentPathCount + leftCount + rightCount
        }

        prefixMap.put(0, 1)
        return computePathCount(root, 0)
    }
}
