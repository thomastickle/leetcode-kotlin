package leetcode.p1161

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumLevelSumOfABinaryTreeTest {
    private val solution = Solution()

    private fun treeNodeOf(vararg values: Int?): TreeNode? {
        if (values.isEmpty() || values[0] == null) return null
        val root = TreeNode(values[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var index = 1
        while (index < values.size && queue.isNotEmpty()) {
            val current = queue.removeFirst()
            val leftVal = values[index++]
            if (leftVal != null) {
                val leftNode = TreeNode(leftVal)
                current.left = leftNode
                queue.add(leftNode)
            }
            if (index < values.size) {
                val rightVal = values[index++]
                if (rightVal != null) {
                    val rightNode = TreeNode(rightVal)
                    current.right = rightNode
                    queue.add(rightNode)
                }
            }
        }
        return root
    }

    @Test
    fun `returns the maximum level for the first example`() {
        val root = treeNodeOf(1, 7, 0, 7, -8, null, null)
        assertEquals(2, solution.maxLevelSum(root))
    }

    @Test
    fun `returns the maximum level for the second example`() {
        val root = treeNodeOf(989, null, 10250, 98693, -89388, null, null, null, -32127)
        assertEquals(2, solution.maxLevelSum(root))
    }

    @Test
    fun `returns the root level for a single-node tree`() {
        assertEquals(1, solution.maxLevelSum(treeNodeOf(42)))
    }

    @Test
    fun `returns the smallest level when maximum sums are tied`() {
        val root = treeNodeOf(5, 2, 3)
        assertEquals(1, solution.maxLevelSum(root))
    }

    @Test
    fun `handles negative values and selects the level with the least negative sum`() {
        val root = treeNodeOf(-100, -5, -6, -20, -1)
        assertEquals(2, solution.maxLevelSum(root))
    }

    @Test
    fun `finds a deeper level with the greatest sum`() {
        val root = treeNodeOf(1, 1, 1, 10, 10, 10, 10)
        assertEquals(3, solution.maxLevelSum(root))
    }
}
