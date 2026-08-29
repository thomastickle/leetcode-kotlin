package leetcode.p0104

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class MaximumDepthOfBinaryTreeTest {
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
    fun `calculates maximum depth for first example`() {
        val root = treeNodeOf(3, 9, 20, null, null, 15, 7)
        val result = solution.maxDepth(root)
        assertEquals(3, result)
    }

    @Test
    fun `calculates maximum depth for second example`() {
        val root = treeNodeOf(1, null, 2)
        val result = solution.maxDepth(root)
        assertEquals(2, result)
    }

    @Test
    fun `returns zero for empty tree`() {
        val result = solution.maxDepth(null)
        assertEquals(0, result)
    }

    @Test
    fun `returns one for single node tree`() {
        val root = treeNodeOf(0)
        val result = solution.maxDepth(root)
        assertEquals(1, result)
    }

    @Test
    fun `calculates depth for left-skewed tree`() {
        val root = treeNodeOf(1, 2, null, 3, null, 4)
        val result = solution.maxDepth(root)
        assertEquals(4, result)
    }

    @Test
    fun `calculates depth for right-skewed tree`() {
        val root = treeNodeOf(1, null, 2, null, 3, null, 4)
        val result = solution.maxDepth(root)
        assertEquals(4, result)
    }

    @Test
    fun `calculates depth for symmetric tree with unbalanced branch depths`() {
        val root = treeNodeOf(1, 2, 3, 4, null, null, 5)
        val result = solution.maxDepth(root)
        assertEquals(3, result)
    }

    @Test
    fun `handles nodes with boundary values`() {
        val root = treeNodeOf(-100, 100, 0)
        val result = solution.maxDepth(root)
        assertEquals(2, result)
    }
}
