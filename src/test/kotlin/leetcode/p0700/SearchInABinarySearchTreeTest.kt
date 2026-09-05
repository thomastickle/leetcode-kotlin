package leetcode.p0700

import org.junit.jupiter.api.Assertions.assertNull
import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class SearchInABinarySearchTreeTest {
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
    fun `finds subtree rooted at target node for first example`() {
        val root = treeNodeOf(4, 2, 7, 1, 3)
        val expected = root?.left
        val actual = solution.searchBST(root, 2)
        assertSame(expected, actual)
    }

    @Test
    fun `returns null when target value does not exist for second example`() {
        val root = treeNodeOf(4, 2, 7, 1, 3)
        val actual = solution.searchBST(root, 5)
        assertNull(actual)
    }

    @Test
    fun `returns root when target value is at the root`() {
        val root = treeNodeOf(4, 2, 7, 1, 3)
        val actual = solution.searchBST(root, 4)
        assertSame(root, actual)
    }

    @Test
    fun `finds leaf node in the right subtree`() {
        val root = treeNodeOf(4, 2, 7, 1, 3)
        val expected = root?.right
        val actual = solution.searchBST(root, 7)
        assertSame(expected, actual)
    }

    @Test
    fun `finds leaf node in the left subtree`() {
        val root = treeNodeOf(4, 2, 7, 1, 3)
        val expected = root?.left?.right
        val actual = solution.searchBST(root, 3)
        assertSame(expected, actual)
    }

    @Test
    fun `returns single node when matching in a single-node tree`() {
        val root = treeNodeOf(42)
        val actual = solution.searchBST(root, 42)
        assertSame(root, actual)
    }

    @Test
    fun `returns null when not matching in a single-node tree`() {
        val root = treeNodeOf(42)
        val actual = solution.searchBST(root, 10)
        assertNull(actual)
    }

    @Test
    fun `returns null when searching an empty tree`() {
        val actual = solution.searchBST(null, 5)
        assertNull(actual)
    }

    @Test
    fun `handles boundary constraint values`() {
        val root = treeNodeOf(10_000_000, 1, null)
        val expected = root?.left
        val actual = solution.searchBST(root, 1)
        assertSame(expected, actual)
    }
}
