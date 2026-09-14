package leetcode.p0748

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ShortestCompletingWordTest {
    private val solution = Solution()

    @Test
    fun `returns the shortest completing word for the first example`() {
        assertEquals(
            "steps",
            solution.shortestCompletingWord(
                "1s3 PSt",
                arrayOf("step", "steps", "stripe", "stepple"),
            ),
        )
    }

    @Test
    fun `returns the first shortest completing word for the second example`() {
        assertEquals(
            "pest",
            solution.shortestCompletingWord(
                "1s3 456",
                arrayOf("looks", "pest", "stew", "show"),
            ),
        )
    }

    @Test
    fun `requires repeated letters from the license plate`() {
        assertEquals(
            "aabb",
            solution.shortestCompletingWord(
                "1A2bB",
                arrayOf("abca", "aabb", "baba"),
            ),
        )
    }

    @Test
    fun `ignores digits spaces and letter case`() {
        assertEquals(
            "cab",
            solution.shortestCompletingWord(
                "9 C-bA",
                arrayOf("abcde", "cab", "ca"),
            ),
        )
    }

    @Test
    fun `handles a single required letter`() {
        assertEquals(
            "z",
            solution.shortestCompletingWord("z", arrayOf("apple", "z", "zoom")),
        )
    }

    @Test
    fun `handles the maximum license plate length`() {
        assertEquals(
            "abcdefg",
            solution.shortestCompletingWord(
                "a1b2c3d4e5f6g",
                arrayOf("abcdefgh", "abcdefg"),
            ),
        )
    }
}
