package leetcode.p1448

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class CountGoodNodesInBinaryTreeTest {
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
    fun `counts good nodes for first example`() {
        val root = treeNodeOf(3, 1, 4, 3, null, 1, 5)
        val result = solution.goodNodes(root)
        assertEquals(4, result)
    }

    @Test
    fun `counts good nodes for second example`() {
        val root = treeNodeOf(3, 3, null, 4, 2)
        val result = solution.goodNodes(root)
        assertEquals(3, result)
    }

    @Test
    fun `counts good nodes for single-node tree in third example`() {
        val root = treeNodeOf(1)
        val result = solution.goodNodes(root)
        assertEquals(1, result)
    }

    @Test
    fun `counts all nodes when values are strictly increasing along path`() {
        val root = treeNodeOf(1, 2, 3, 4, 5, 6, 7)
        val result = solution.goodNodes(root)
        assertEquals(7, result)
    }

    @Test
    fun `counts only root when values are strictly decreasing along path`() {
        val root = treeNodeOf(10, 9, 8, 7, 6, 5, 4)
        val result = solution.goodNodes(root)
        assertEquals(1, result)
    }

    @Test
    fun `counts all nodes when all node values are identical`() {
        val root = treeNodeOf(5, 5, 5, 5, 5)
        val result = solution.goodNodes(root)
        assertEquals(5, result)
    }

    @Test
    fun `counts good nodes with negative values along path`() {
        val root = treeNodeOf(-5, -3, -10, -2, -4, null, -8)
        val result = solution.goodNodes(root)
        // Root: -5 (good, max = -5)
        // Left: -3 (good, max = -3)
        // Left.left: -2 (good, max = -2)
        // Left.right: -4 (not good, max = -3)
        // Right: -10 (not good, max = -5)
        // Right.right: -8 (not good, max = -5)
        // Total good: -5, -3, -2 => 3
        assertEquals(3, result)
    }

    @Test
    fun `handles nodes at constraint value boundaries`() {
        val root = treeNodeOf(-10_000, 10_000, -10_000, null, null, 10_000, 0)
        val result = solution.goodNodes(root)
        // Root: -10_000 (good, max = -10_000)
        // Left: 10_000 (good, max = 10_000)
        // Right: -10_000 (good, max = -10_000)
        // Right.left: 10_000 (good, max = 10_000)
        // Right.right: 0 (good, max = 0)
        // Total good: 5
        assertEquals(5, result)
    }
}
