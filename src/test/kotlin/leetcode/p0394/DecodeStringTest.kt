package leetcode.p0394

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class DecodeStringTest {
    private val solution = Solution()

    @Test
    fun `decodes multiple encoded groups for the first example`() {
        assertEquals("aaabcbc", solution.decodeString("3[a]2[bc]"))
    }

    @Test
    fun `decodes nested encoded groups for the second example`() {
        assertEquals("accaccacc", solution.decodeString("3[a2[c]]"))
    }

    @Test
    fun `decodes encoded groups with trailing plain characters for the third example`() {
        assertEquals("abcabccdcdcdef", solution.decodeString("2[abc]3[cd]ef"))
    }

    @Test
    fun `leaves plain string without encoded brackets unchanged`() {
        assertEquals("leetcode", solution.decodeString("leetcode"))
    }

    @Test
    fun `decodes single character repetition`() {
        assertEquals("aaaa", solution.decodeString("4[a]"))
    }

    @Test
    fun `handles multi-digit repetition count`() {
        assertEquals("aaaaaaaaaa", solution.decodeString("10[a]"))
    }

    @Test
    fun `handles deeply nested repetitions`() {
        assertEquals("aaaaaaaa", solution.decodeString("2[2[2[a]]]"))
    }

    @Test
    fun `decodes encoded segment surrounded by unencoded prefix and suffix`() {
        assertEquals("abcddef", solution.decodeString("abc2[d]ef"))
    }

    @Test
    fun `handles combination of nested and sequential groups`() {
        assertEquals("abbabbccc", solution.decodeString("2[a2[b]]3[c]"))
    }
}
