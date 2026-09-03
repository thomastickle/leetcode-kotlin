package leetcode.p0437

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathSumIIITest {
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

    @Test
    fun `counts paths for the first example`() {
        val root = treeNodeOf(10, 5, -3, 3, 2, null, 11, 3, -2, null, 1)
        assertEquals(3, solution.pathSum(root, 8))
    }

    @Test
    fun `counts paths for the second example`() {
        val root = treeNodeOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1)
        assertEquals(3, solution.pathSum(root, 22))
    }

    @Test
    fun `returns zero for an empty tree`() {
        assertEquals(0, solution.pathSum(null, 0))
    }

    @Test
    fun `counts a single node when it matches the target`() {
        assertEquals(1, solution.pathSum(treeNodeOf(1), 1))
    }

    @Test
    fun `returns zero for a single node that does not match`() {
        assertEquals(0, solution.pathSum(treeNodeOf(1), 2))
    }

    @Test
    fun `counts paths that may start below the root`() {
        val root = treeNodeOf(1, 2, 3, 1, null, null, 1)
        assertEquals(3, solution.pathSum(root, 3))
    }

    @Test
    fun `counts overlapping paths with repeated values`() {
        val root = treeNodeOf(1, 1, 1, 1, 1, 1, 1)
        assertEquals(6, solution.pathSum(root, 2))
    }

    @Test
    fun `counts paths containing negative values`() {
        val root = treeNodeOf(-2, 1, -3, -1, null, null, 2)
        assertEquals(3, solution.pathSum(root, -1))
    }

    @Test
    fun `handles target and node values at constraint boundaries`() {
        val root = treeNodeOf(1_000_000_000, -1_000_000_000)
        assertEquals(1, solution.pathSum(root, -1_000_000_000))
    }
}
