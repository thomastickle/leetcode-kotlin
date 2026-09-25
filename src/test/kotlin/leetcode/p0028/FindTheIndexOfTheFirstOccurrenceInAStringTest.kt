package leetcode.p0028

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class FindTheIndexOfTheFirstOccurrenceInAStringTest {
    private val solution = Solution()

    @Test
    fun `finds first occurrence in example 1`() {
        assertEquals(0, solution.strStr("sadbutsad", "sad"))
        assertEquals(0, solution.strStrBrute("sadbutsad", "sad"))
    }

    @Test
    fun `returns negative one when needle is absent in example 2`() {
        assertEquals(-1, solution.strStr("leetcode", "leeto"))
        assertEquals(-1, solution.strStrBrute("leetcode", "leeto"))
    }

    @Test
    fun `finds occurrence at the end of haystack`() {
        assertEquals(4, solution.strStr("mississippi", "issippi"))
        assertEquals(4, solution.strStrBrute("mississippi", "issippi"))
    }

    @Test
    fun `finds entire haystack when it equals needle`() {
        assertEquals(0, solution.strStr("a", "a"))
        assertEquals(0, solution.strStrBrute("a", "a"))
    }

    @Test
    fun `finds earliest occurrence when matches overlap`() {
        assertEquals(0, solution.strStr("ababab", "abab"))
        assertEquals(0, solution.strStrBrute("ababab", "abab"))
    }
}