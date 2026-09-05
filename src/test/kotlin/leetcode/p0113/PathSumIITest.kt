package leetcode.p0113

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class PathSumIITest {
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
    fun `returns all matching paths for the first example`() {
        val root = treeNodeOf(5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1)
        val result = solution.pathSum(root, 22)
        assertEquals(listOf(listOf(5, 4, 11, 2), listOf(5, 8, 4, 5)), result)
    }

    @Test
    fun `returns no paths for the second example`() {
        val root = treeNodeOf(1, 2, 3)
        assertEquals(emptyList<List<Int>>(), solution.pathSum(root, 5))
    }

    @Test
    fun `returns no paths when only an intermediate path matches`() {
        val root = treeNodeOf(1, 2, null, 3)
        assertEquals(emptyList<List<Int>>(), solution.pathSum(root, 3))
    }

    @Test
    fun `returns no paths for an empty tree`() {
        assertEquals(emptyList<List<Int>>(), solution.pathSum(null, 0))
    }

    @Test
    fun `returns a single-node path when it matches`() {
        assertEquals(listOf(listOf(7)), solution.pathSum(treeNodeOf(7), 7))
    }

    @Test
    fun `handles negative values and zero target`() {
        val root = treeNodeOf(1, -2, 3, 1, null, -1, -2)
        assertEquals(listOf(listOf(1, -2, 1)), solution.pathSum(root, 0))
    }

    @Test
    fun `returns every matching path when multiple paths share a prefix`() {
        val root = treeNodeOf(1, 2, 2, 3, null, null, 3)
        assertEquals(listOf(listOf(1, 2, 3), listOf(1, 2, 3)), solution.pathSum(root, 6))
    }

    @Test
    fun `handles node values at constraint boundaries`() {
        val root = treeNodeOf(-1_000, 1_000)
        assertEquals(listOf(listOf(-1_000, 1_000)), solution.pathSum(root, 0))
    }

}