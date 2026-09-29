package leetcode.p0030

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SubstringWithConcatenationOfAllWordsTest {
    private val solution = Solution()

    @Test
    fun `returns both concatenations for the first example`() {
        assertEquals(
            setOf(0, 9),
            solution.findSubstring("barfoothefoobarman", arrayOf("foo", "bar")).toSet(),
        )
    }

    @Test
    fun `returns no indices for the second example`() {
        assertEquals(
            emptySet<Int>(),
            solution.findSubstring(
                "wordgoodgoodgoodbestword",
                arrayOf("word", "good", "best", "word"),
            ).toSet(),
        )
    }

    @Test
    fun `returns all three permutations for the third example`() {
        assertEquals(
            setOf(6, 9, 12),
            solution.findSubstring("barfoofoobarthefoobarman", arrayOf("bar", "foo", "the")).toSet(),
        )
    }

    @Test
    fun `counts duplicate words with their required multiplicity`() {
        assertEquals(
            setOf(0),
            solution.findSubstring("foobarfoobar", arrayOf("foo", "bar", "foo")).toSet(),
        )
    }

    @Test
    fun `finds overlapping concatenations`() {
        assertEquals(
            setOf(0, 1, 2),
            solution.findSubstring("aaaaaa", arrayOf("aa", "aa")).toSet(),
        )
    }

    @Test
    fun `returns no indices when the string is shorter than the required concatenation`() {
        assertEquals(
            emptySet<Int>(),
            solution.findSubstring("short", arrayOf("long", "word")).toSet(),
        )
    }
}