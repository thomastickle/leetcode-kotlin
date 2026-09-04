package leetcode.p0236

import org.junit.jupiter.api.Assertions.assertSame
import org.junit.jupiter.api.Test

class LowestCommonAncestorOfABinaryTreeTest {
    private val solution = Solution()

    private fun treeNodeOf(vararg values: Int?): TreeNode? {
        if (values.isEmpty() || values[0] == null) return null
        val root = TreeNode(values[0]!!)
        val queue = ArrayDeque<TreeNode>()
        queue.add(root)
        var index = 1
        while (index < values.size && queue.isNotEmpty()) {
            val current = queue.removeFirst()
            if (index < values.size) {
                val leftVal = values[index++]
                if (leftVal != null) {
                    val leftNode = TreeNode(leftVal)
                    current.left = leftNode
                    queue.add(leftNode)
                }
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

    private fun findNode(root: TreeNode?, value: Int): TreeNode? {
        if (root == null) return null
        if (root.`val` == value) return root
        return findNode(root.left, value) ?: findNode(root.right, value)
    }

    @Test
    fun `finds ancestor for nodes in separate subtrees in first example`() {
        val root = treeNodeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        assertSame(root, solution.lowestCommonAncestor(root, findNode(root, 5), findNode(root, 1)))
    }

    @Test
    fun `returns one queried node when it is an ancestor in second example`() {
        val root = treeNodeOf(3, 5, 1, 6, 2, 0, 8, null, null, 7, 4)
        val node5 = findNode(root, 5)
        assertSame(node5, solution.lowestCommonAncestor(root, node5, findNode(root, 4)))
    }

    @Test
    fun `returns root when it is an ancestor in third example`() {
        val root = treeNodeOf(1, 2)
        assertSame(root, solution.lowestCommonAncestor(root, root, root?.left))
    }

    @Test
    fun `finds ancestor of sibling nodes`() {
        val root = treeNodeOf(1, 2, 3)
        assertSame(root, solution.lowestCommonAncestor(root, root?.left, root?.right))
    }

    @Test
    fun `finds ancestor entirely within one subtree`() {
        val root = treeNodeOf(1, 2, 3, 4, 5, 6, 7)
        assertSame(root?.left, solution.lowestCommonAncestor(root, findNode(root, 4), findNode(root, 5)))
    }
}
