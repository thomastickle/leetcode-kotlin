package leetcode.p1372

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class LongestZigZagPathInABinaryTreeTest {
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
    fun `finds longest zigzag for the first example`() {
        val root = treeNodeOf(1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1)
        assertEquals(3, solution.longestZigZag(root))
    }

    @Test
    fun `finds longest zigzag for the second example`() {
        val root = treeNodeOf(1, 1, 1, null, 1, null, null, 1, 1, null, 1)
        assertEquals(4, solution.longestZigZag(root))
    }

    @Test
    fun `returns zero for a single-node tree in third example`() {
        val root = treeNodeOf(1)
        assertEquals(0, solution.longestZigZag(root))
    }

    @Test
    fun `returns one for a left-skewed tree`() {
        val root = treeNodeOf(1, 2, null, 3, null, 4, null)
        assertEquals(1, solution.longestZigZag(root))
    }

    @Test
    fun `returns one for a right-skewed tree`() {
        val root = treeNodeOf(1, null, 2, null, 3, null, 4)
        assertEquals(1, solution.longestZigZag(root))
    }

    @Test
    fun `returns one for a balanced tree of three nodes`() {
        val root = treeNodeOf(1, 2, 3)
        assertEquals(1, solution.longestZigZag(root))
    }

    @Test
    fun `returns two for a full binary tree of height two`() {
        val root = treeNodeOf(1, 2, 3, 4, 5, 6, 7)
        assertEquals(2, solution.longestZigZag(root))
    }

    @Test
    fun `finds longest zigzag when optimal path is located deep in subtree`() {
        // Root has left branch with a long zigzag (len 3: left -> right -> left) and right subtree of len 1
        // 1
        //  / \
        // 2   3
        //  \
        //   4
        //  /
        // 5
        val root = treeNodeOf(1, 2, 3, null, 4, null, null, 5)
        assertEquals(3, solution.longestZigZag(root))
    }
}
