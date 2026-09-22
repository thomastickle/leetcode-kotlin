package leetcode.p0013

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class RomanToIntegerTest {
    private val solution = Solution()

    @Test
    fun `converts simple repeated symbols in example 1`() {
        assertEquals(3, solution.romanToInt("III"))
    }

    @Test
    fun `converts additive combination in example 2`() {
        assertEquals(58, solution.romanToInt("LVIII"))
    }

    @Test
    fun `converts mixed subtractive combination in example 3`() {
        assertEquals(1994, solution.romanToInt("MCMXCIV"))
    }

    @Test
    fun `converts single character numerals`() {
        assertEquals(1, solution.romanToInt("I"))
        assertEquals(5, solution.romanToInt("V"))
        assertEquals(10, solution.romanToInt("X"))
        assertEquals(50, solution.romanToInt("L"))
        assertEquals(100, solution.romanToInt("C"))
        assertEquals(500, solution.romanToInt("D"))
        assertEquals(1000, solution.romanToInt("M"))
    }

    @Test
    fun `converts all six subtractive instances`() {
        assertEquals(4, solution.romanToInt("IV"))
        assertEquals(9, solution.romanToInt("IX"))
        assertEquals(40, solution.romanToInt("XL"))
        assertEquals(90, solution.romanToInt("XC"))
        assertEquals(400, solution.romanToInt("CD"))
        assertEquals(900, solution.romanToInt("CM"))
    }

    @Test
    fun `converts maximum valid constraint value 3999`() {
        assertEquals(3999, solution.romanToInt("MMMCMXCIX"))
    }

    @Test
    fun `converts complex additive numeral without subtraction`() {
        assertEquals(27, solution.romanToInt("XXVII"))
    }
}
