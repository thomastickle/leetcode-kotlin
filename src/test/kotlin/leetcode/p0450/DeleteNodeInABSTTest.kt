package leetcode.p0450

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class DeleteNodeInABSTTest {
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

    private fun assertTreeEquals(expected: TreeNode?, actual: TreeNode?) {
        assertEquals(expected?.`val`, actual?.`val`)
        if (expected == null || actual == null) return
        assertTreeEquals(expected.left, actual.left)
        assertTreeEquals(expected.right, actual.right)
    }

    private fun assertBstContainsExactly(expectedValues: List<Int>, root: TreeNode?) {
        val actualValues = mutableListOf<Int>()

        fun collectInOrder(node: TreeNode?) {
            if (node == null) return
            collectInOrder(node.left)
            actualValues += node.`val`
            collectInOrder(node.right)
        }

        fun isValidBst(node: TreeNode?, minimum: Int?, maximum: Int?): Boolean {
            if (node == null) return true
            if (minimum != null && node.`val` <= minimum) return false
            if (maximum != null && node.`val` >= maximum) return false
            return isValidBst(node.left, minimum, node.`val`) &&
                isValidBst(node.right, node.`val`, maximum)
        }

        collectInOrder(root)
        assertEquals(expectedValues, actualValues)
        assertTrue(isValidBst(root, null, null))
    }

    @Test
    fun `deletes a node with two children while preserving the BST`() {
        val root = treeNodeOf(5, 3, 6, 2, 4, null, 7)

        assertBstContainsExactly(listOf(2, 4, 5, 6, 7), solution.deleteNode(root, 3))
    }

    @Test
    fun `leaves the tree unchanged when key does not exist for the second example`() {
        val root = treeNodeOf(5, 3, 6, 2, 4, null, 7)
        val expected = treeNodeOf(5, 3, 6, 2, 4, null, 7)

        assertTreeEquals(expected, solution.deleteNode(root, 0))
    }

    @Test
    fun `returns an empty tree for the third example`() {
        assertTreeEquals(null, solution.deleteNode(null, 0))
    }

    @Test
    fun `deletes a leaf node`() {
        val root = treeNodeOf(5, 3, 6, 2, 4, null, 7)
        val expected = treeNodeOf(5, 3, 6, null, 4, null, 7)

        assertTreeEquals(expected, solution.deleteNode(root, 2))
    }

    @Test
    fun `deletes a node with one child`() {
        val root = treeNodeOf(5, 3, null, 2)
        val expected = treeNodeOf(5, 2)

        assertTreeEquals(expected, solution.deleteNode(root, 3))
    }

    @Test
    fun `deletes the only node in the tree`() {
        assertTreeEquals(null, solution.deleteNode(treeNodeOf(42), 42))
    }

    @Test
    fun `deletes the root with two children while preserving the BST`() {
        val root = treeNodeOf(5, 3, 7, 2, 4, 6, 8)

        assertBstContainsExactly(listOf(2, 3, 4, 6, 7, 8), solution.deleteNode(root, 5))
    }

    @Test
    fun `handles values at both constraint boundaries`() {
        val root = treeNodeOf(0, -100_000, 100_000)
        val expected = treeNodeOf(0, null, 100_000)

        assertTreeEquals(expected, solution.deleteNode(root, -100_000))
    }
}
