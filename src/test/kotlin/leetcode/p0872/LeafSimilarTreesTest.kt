package leetcode.p0872

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class LeafSimilarTreesTest {
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
    fun `returns true for trees with identical leaf sequences in first example`() {
        val root1 = treeNodeOf(3, 5, 1, 6, 2, 9, 8, null, null, 7, 4)
        val root2 = treeNodeOf(3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8)
        val result = solution.leafSimilar(root1, root2)
        assertTrue(result)
    }

    @Test
    fun `returns false for trees with different leaf sequences in second example`() {
        val root1 = treeNodeOf(1, 2, 3)
        val root2 = treeNodeOf(1, 3, 2)
        val result = solution.leafSimilar(root1, root2)
        assertFalse(result)
    }

    @Test
    fun `returns true for identical single-node trees`() {
        val root1 = treeNodeOf(1)
        val root2 = treeNodeOf(1)
        val result = solution.leafSimilar(root1, root2)
        assertTrue(result)
    }

    @Test
    fun `returns false for single-node trees with different values`() {
        val root1 = treeNodeOf(1)
        val root2 = treeNodeOf(2)
        val result = solution.leafSimilar(root1, root2)
        assertFalse(result)
    }

    @Test
    fun `returns true for single-node tree and deeper tree with identical single leaf`() {
        val root1 = treeNodeOf(1)
        val root2 = treeNodeOf(2, 1, null)
        val result = solution.leafSimilar(root1, root2)
        assertTrue(result)
    }

    @Test
    fun `returns false when trees have different number of leaves`() {
        val root1 = treeNodeOf(1, 2, 3)
        val root2 = treeNodeOf(1, 2, null)
        val result = solution.leafSimilar(root1, root2)
        assertFalse(result)
    }

    @Test
    fun `returns true for left-skewed and right-skewed trees with same leaf value`() {
        val root1 = treeNodeOf(1, 2, null, 3)
        val root2 = treeNodeOf(4, null, 5, null, 3)
        val result = solution.leafSimilar(root1, root2)
        assertTrue(result)
    }

    @Test
    fun `handles leaf nodes at constraint boundaries`() {
        val root1 = treeNodeOf(100, 0, 200)
        val root2 = treeNodeOf(50, 0, 200)
        val result = solution.leafSimilar(root1, root2)
        assertTrue(result)
    }
}
