package leetcode.p0112

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class PathSumTest {
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
    fun `returns true when a root-to-leaf path matches the first example`() {
        val root = treeNodeOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1)
        assertTrue(solution.hasPathSum(root, 22))
    }

    @Test
    fun `returns false when no root-to-leaf path matches the second example`() {
        val root = treeNodeOf(1, 2, 3)
        assertFalse(solution.hasPathSum(root, 5))
    }

    @Test
    fun `returns false for an empty tree`() {
        assertFalse(solution.hasPathSum(null, 0))
    }

    @Test
    fun `returns true for a single-node path matching the target`() {
        assertTrue(solution.hasPathSum(treeNodeOf(7), 7))
    }

    @Test
    fun `returns false for a single node that does not match`() {
        assertFalse(solution.hasPathSum(treeNodeOf(7), 8))
    }

    @Test
    fun `does not treat a matching intermediate node as a leaf`() {
        val root = treeNodeOf(1, 2, null, 3)
        assertFalse(solution.hasPathSum(root, 1))
    }

    @Test
    fun `handles negative values and a zero target`() {
        val root = treeNodeOf(1, -2, 3, 1, null, -1, -2)
        assertTrue(solution.hasPathSum(root, 0))
    }

    @Test
    fun `handles values at the constraint boundaries`() {
        val root = treeNodeOf(1_000, -1_000)
        assertTrue(solution.hasPathSum(root, 0))
    }
}
