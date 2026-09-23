package leetcode.p0012

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class IntegerToRomanTest {
    private val solution = Solution()

    @Test
    fun `converts decimal place values in example 1`() {
        assertEquals("MMMDCCXLIX", solution.intToRoman(3749))
    }

    @Test
    fun `converts additive combination in example 2`() {
        assertEquals("LVIII", solution.intToRoman(58))
    }

    @Test
    fun `converts mixed subtractive combination in example 3`() {
        assertEquals("MCMXCIV", solution.intToRoman(1994))
    }

    @Test
    fun `converts simple repeated numeral in example 4`() {
        assertEquals("III", solution.intToRoman(3))
    }

    @Test
    fun `converts single character numeral values`() {
        assertEquals("I", solution.intToRoman(1))
        assertEquals("V", solution.intToRoman(5))
        assertEquals("X", solution.intToRoman(10))
        assertEquals("L", solution.intToRoman(50))
        assertEquals("C", solution.intToRoman(100))
        assertEquals("D", solution.intToRoman(500))
        assertEquals("M", solution.intToRoman(1000))
    }

    @Test
    fun `converts all six subtractive instances`() {
        assertEquals("IV", solution.intToRoman(4))
        assertEquals("IX", solution.intToRoman(9))
        assertEquals("XL", solution.intToRoman(40))
        assertEquals("XC", solution.intToRoman(90))
        assertEquals("CD", solution.intToRoman(400))
        assertEquals("CM", solution.intToRoman(900))
    }

    @Test
    fun `converts maximum valid constraint value 3999`() {
        assertEquals("MMMCMXCIX", solution.intToRoman(3999))
    }

    @Test
    fun `converts complex additive numeral without subtraction`() {
        assertEquals("XXVII", solution.intToRoman(27))
    }
}
