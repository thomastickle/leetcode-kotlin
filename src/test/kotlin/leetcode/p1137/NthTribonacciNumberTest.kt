package leetcode.p1137

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class NthTribonacciNumberTest {
    private val solution = Solution()

    @Test
    fun `returns the fourth Tribonacci number`() {
        assertEquals(4, solution.tribonacci(4))
    }

    @Test
    fun `returns the twenty-fifth Tribonacci number`() {
        assertEquals(1_389_537, solution.tribonacci(25))
    }

    @Test
    fun `returns the initial sequence values`() {
        assertEquals(0, solution.tribonacci(0))
        assertEquals(1, solution.tribonacci(1))
        assertEquals(1, solution.tribonacci(2))
    }

    @Test
    fun `applies the recurrence at the first computed value`() {
        assertEquals(2, solution.tribonacci(3))
    }

    @Test
    fun `handles the maximum constrained input`() {
        assertEquals(2_082_876_103, solution.tribonacci(37))
    }
}
