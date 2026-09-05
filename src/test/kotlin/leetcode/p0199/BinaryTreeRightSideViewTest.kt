package leetcode.p0199

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class BinaryTreeRightSideViewTest {
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
    fun `returns visible nodes for the first example`() {
        val root = treeNodeOf(1, 2, 3, null, 5, null, 4)
        assertEquals(listOf(1, 3, 4), solution.rightSideView(root))
    }

    @Test
    fun `returns visible nodes for the second example`() {
        val root = treeNodeOf(1, null, 3)
        assertEquals(listOf(1, 3), solution.rightSideView(root))
    }

    @Test
    fun `returns an empty list for the third example`() {
        assertEquals(emptyList<Int>(), solution.rightSideView(null))
    }

    @Test
    fun `returns the root for a single-node tree`() {
        assertEquals(listOf(7), solution.rightSideView(treeNodeOf(7)))
    }

    @Test
    fun `uses the deepest visible node when a level has no right child`() {
        val root = treeNodeOf(1, 2, null, 3, null, 4)
        assertEquals(listOf(1, 2, 3, 4), solution.rightSideView(root))
    }

    @Test
    fun `returns the rightmost node at every level of a full tree`() {
        val root = treeNodeOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals(listOf(1, 3, 7), solution.rightSideView(root))
    }

    @Test
    fun `handles negative and constraint-boundary node values`() {
        val root = treeNodeOf(-100, -99, 100, null, -50, null, 99)
        assertEquals(listOf(-100, 100, 99), solution.rightSideView(root))
    }
}
