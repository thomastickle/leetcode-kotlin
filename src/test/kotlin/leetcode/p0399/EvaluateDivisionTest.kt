package leetcode.p0399

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class EvaluateDivisionTest {
    private val solution = Solution()

    private fun assertAnswers(expected: DoubleArray, actual: DoubleArray) {
        assertEquals(expected.size, actual.size)
        expected.indices.forEach { index ->
            assertEquals(expected[index], actual[index], 1e-9)
        }
    }

    @Test
    fun `evaluates connected and unknown queries for the first example`() {
        val equations = listOf(
            listOf("a", "b"),
            listOf("b", "c"),
        )
        val queries = listOf(
            listOf("a", "c"),
            listOf("b", "a"),
            listOf("a", "e"),
            listOf("a", "a"),
            listOf("x", "x"),
        )

        assertAnswers(
            doubleArrayOf(6.0, 0.5, -1.0, 1.0, -1.0),
            solution.calcEquation(equations, doubleArrayOf(2.0, 3.0), queries),
        )
    }

    @Test
    fun `evaluates independent variable names for the second example`() {
        val equations = listOf(
            listOf("a", "b"),
            listOf("b", "c"),
            listOf("bc", "cd"),
        )
        val queries = listOf(
            listOf("a", "c"),
            listOf("c", "b"),
            listOf("bc", "cd"),
            listOf("cd", "bc"),
        )

        assertAnswers(
            doubleArrayOf(3.75, 0.4, 5.0, 0.2),
            solution.calcEquation(equations, doubleArrayOf(1.5, 2.5, 5.0), queries),
        )
    }

    @Test
    fun `evaluates direct reverse and unknown queries for the third example`() {
        val equations = listOf(listOf("a", "b"))
        val queries = listOf(
            listOf("a", "b"),
            listOf("b", "a"),
            listOf("a", "c"),
            listOf("x", "y"),
        )

        assertAnswers(
            doubleArrayOf(0.5, 2.0, -1.0, -1.0),
            solution.calcEquation(equations, doubleArrayOf(0.5), queries),
        )
    }

    @Test
    fun `returns one for a known variable divided by itself`() {
        assertAnswers(
            doubleArrayOf(1.0),
            solution.calcEquation(
                listOf(listOf("x", "y")),
                doubleArrayOf(7.5),
                listOf(listOf("x", "x")),
            ),
        )
    }

    @Test
    fun `returns minus one when both variables are unknown`() {
        assertAnswers(
            doubleArrayOf(-1.0),
            solution.calcEquation(
                listOf(listOf("a", "b")),
                doubleArrayOf(2.0),
                listOf(listOf("u", "v")),
            ),
        )
    }

    @Test
    fun `multiplies ratios across a longer chain`() {
        val equations = listOf(
            listOf("a", "b"),
            listOf("b", "c"),
            listOf("c", "d"),
        )

        assertAnswers(
            doubleArrayOf(24.0, 1.0 / 24.0),
            solution.calcEquation(
                equations,
                doubleArrayOf(2.0, 3.0, 4.0),
                listOf(listOf("a", "d"), listOf("d", "a")),
            ),
        )
    }
}