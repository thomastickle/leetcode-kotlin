package leetcode.p0068

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class TextJustificationTest {
    private val solution = Solution()

    @Test
    fun `justifies text in example 1`() {
        assertEquals(
            listOf("This    is    an", "example  of text", "justification.  "),
            solution.fullJustify(
                arrayOf("This", "is", "an", "example", "of", "text", "justification."),
                16,
            ),
        )
    }

    @Test
    fun `left justifies final and single-word lines in example 2`() {
        assertEquals(
            listOf("What   must   be", "acknowledgment  ", "shall be        "),
            solution.fullJustify(arrayOf("What", "must", "be", "acknowledgment", "shall", "be"), 16),
        )
    }

    @Test
    fun `justifies text in example 3`() {
        assertEquals(
            listOf(
                "Science  is  what we",
                "understand      well",
                "enough to explain to",
                "a  computer.  Art is",
                "everything  else  we",
                "do                  ",
            ),
            solution.fullJustify(
                arrayOf(
                    "Science", "is", "what", "we", "understand", "well", "enough", "to", "explain",
                    "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do",
                ),
                20,
            ),
        )
    }

    @Test
    fun `pads a single word to the requested width`() {
        assertEquals(
            listOf("hello     "),
            solution.fullJustify(arrayOf("hello"), 10),
        )
    }

    @Test
    fun `keeps words together when they exactly fill a line`() {
        assertEquals(
            listOf("one two", "three  "),
            solution.fullJustify(arrayOf("one", "two", "three"), 7),
        )
    }

    @Test
    fun `assigns uneven extra spaces to the left gaps`() {
        assertEquals(
            listOf("a  bb c", "dd     "),
            solution.fullJustify(arrayOf("a", "bb", "c", "dd"), 7),
        )
    }
}
