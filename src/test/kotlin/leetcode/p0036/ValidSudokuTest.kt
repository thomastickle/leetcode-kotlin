package leetcode.p0036

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class ValidSudokuTest {
    private val solution = Solution()

    private fun boardOf(vararg rows: String): Array<CharArray> = rows.map(String::toCharArray).toTypedArray()

    @Test
    fun `returns true for example 1`() {
        assertEquals(
            true,
            solution.isValidSudoku(
                boardOf(
                    "53..7....",
                    "6..195...",
                    ".98....6.",
                    "8...6...3",
                    "4..8.3..1",
                    "7...2...6",
                    ".6....28.",
                    "...419..5",
                    "....8..79",
                ),
            ),
        )
    }

    @Test
    fun `returns false for example 2 with a duplicate in a sub-box`() {
        assertEquals(
            false,
            solution.isValidSudoku(
                boardOf(
                    "83..7....",
                    "6..195...",
                    ".98....6.",
                    "8...6...3",
                    "4..8.3..1",
                    "7...2...6",
                    ".6....28.",
                    "...419..5",
                    "....8..79",
                ),
            ),
        )
    }

    @Test
    fun `returns false when a row contains a duplicate digit`() {
        assertEquals(
            false,
            solution.isValidSudoku(
                boardOf(
                    "11.......",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                ),
            ),
        )
    }

    @Test
    fun `returns false when a column contains a duplicate digit`() {
        assertEquals(
            false,
            solution.isValidSudoku(
                boardOf(
                    "1........",
                    "1........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                ),
            ),
        )
    }

    @Test
    fun `returns false when a sub-box contains a duplicate outside a shared row or column`() {
        assertEquals(
            false,
            solution.isValidSudoku(
                boardOf(
                    "1........",
                    ".1.......",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                ),
            ),
        )
    }

    @Test
    fun `allows the same digit in different rows columns and sub-boxes`() {
        assertEquals(
            true,
            solution.isValidSudoku(
                boardOf(
                    "1........",
                    ".........",
                    ".........",
                    "...1.....",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                ),
            ),
        )
    }

    @Test
    fun `returns true for a board with no filled cells`() {
        assertEquals(
            true,
            solution.isValidSudoku(
                boardOf(
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                    ".........",
                ),
            ),
        )
    }
}
