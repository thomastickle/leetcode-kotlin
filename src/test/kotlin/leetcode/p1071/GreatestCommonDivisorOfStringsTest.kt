package leetcode.p1071

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class GreatestCommonDivisorOfStringsTest {
    private val solution = Solution()

    @Test
    fun `returns ABC when ABC divides both strings`() {
        assertEquals("ABC", solution.gcdOfStrings("ABCABC", "ABC"))
    }

    @Test
    fun `returns AB when AB is the greatest common divisor`() {
        assertEquals("AB", solution.gcdOfStrings("ABABAB", "ABAB"))
    }

    @Test
    fun `returns an empty string when there is no common divisor`() {
        assertEquals("", solution.gcdOfStrings("LEET", "CODE"))
    }

    @Test
    fun `returns an empty string when matching prefixes do not divide both strings`() {
        assertEquals("", solution.gcdOfStrings("AAAAAB", "AAA"))
    }
}
