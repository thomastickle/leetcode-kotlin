package leetcode.p0443

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class StringCompressionTest {
    private val solution = Solution()

    @Test
    fun `compresses repeated groups`() {
        val chars = charArrayOf('a', 'a', 'b', 'b', 'c', 'c', 'c')

        val length = solution.compress(chars)

        assertEquals(6, length)
        assertEquals("a2b2c3", String(chars, 0, length))
    }

    @Test
    fun `leaves a single character unchanged`() {
        val chars = charArrayOf('a')

        val length = solution.compress(chars)

        assertEquals(1, length)
        assertEquals("a", String(chars, 0, length))
    }

    @Test
    fun `writes multi-digit group counts`() {
        val chars = charArrayOf('a') + CharArray(12) { 'b' }

        val length = solution.compress(chars)

        assertEquals(4, length)
        assertEquals("ab12", String(chars, 0, length))
    }
}
