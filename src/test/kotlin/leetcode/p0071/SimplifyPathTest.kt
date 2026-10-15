package leetcode.p0071

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SimplifyPathTest {
    private val solution = Solution()

    @Test
    fun `removes a trailing slash`() {
        assertEquals("/home", solution.simplifyPath("/home/"))
    }

    @Test
    fun `collapses consecutive slashes`() {
        assertEquals("/home/foo", solution.simplifyPath("/home//foo/"))
    }

    @Test
    fun `resolves a parent directory`() {
        assertEquals("/home/user/Pictures", solution.simplifyPath("/home/user/Documents/../Pictures"))
    }

    @Test
    fun `does not move above the root directory`() {
        assertEquals("/", solution.simplifyPath("/../"))
    }

    @Test
    fun `preserves directory names containing more than two periods`() {
        assertEquals("/.../b/d", solution.simplifyPath("/.../a/../b/c/../d/./"))
    }

    @Test
    fun `returns the root for a path containing only separators`() {
        assertEquals("/", solution.simplifyPath("////"))
    }

    @Test
    fun `ignores current directory components`() {
        assertEquals("/a/b", solution.simplifyPath("/a/./b/./"))
    }

    @Test
    fun `handles repeated parent traversal at the root`() {
        assertEquals("/", solution.simplifyPath("/../../.."))
    }

    @Test
    fun `preserves names containing two periods as part of the name`() {
        assertEquals("/..hidden", solution.simplifyPath("/..hidden"))
    }

    @Test
    fun `resolves mixed parent traversal and current directory components`() {
        assertEquals("/c", solution.simplifyPath("/a/../../b/../c//.//"))
    }
}