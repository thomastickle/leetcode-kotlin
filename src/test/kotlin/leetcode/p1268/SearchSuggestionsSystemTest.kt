package leetcode.p1268

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SearchSuggestionsSystemTest {
    private val solution = Solution()

    @Test
    fun `follows the first example`() {
        assertEquals(
            listOf(
                listOf("mobile", "moneypot", "monitor"),
                listOf("mobile", "moneypot", "monitor"),
                listOf("mouse", "mousepad"),
                listOf("mouse", "mousepad"),
                listOf("mouse", "mousepad"),
            ),
            solution.suggestedProducts(
                arrayOf("mobile", "mouse", "moneypot", "monitor", "mousepad"),
                "mouse",
            ),
        )
    }

    @Test
    fun `follows the single-product example`() {
        assertEquals(
            listOf(
                listOf("havana"),
                listOf("havana"),
                listOf("havana"),
                listOf("havana"),
                listOf("havana"),
                listOf("havana"),
            ),
            solution.suggestedProducts(arrayOf("havana"), "havana"),
        )
    }

    @Test
    fun `follows the bags example with lexicographic ordering`() {
        assertEquals(
            listOf(
                listOf("baggage", "bags", "banner"),
                listOf("baggage", "bags", "banner"),
                listOf("baggage", "bags"),
                listOf("bags"),
            ),
            solution.suggestedProducts(
                arrayOf("bags", "baggage", "banner", "box", "cloths"),
                "bags",
            ),
        )
    }

    @Test
    fun `returns empty suggestions after the first unmatched prefix`() {
        assertEquals(
            listOf(
                emptyList<String>(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
                emptyList(),
            ),
            solution.suggestedProducts(arrayOf("havana"), "tatiana"),
        )
    }

    @Test
    fun `returns at most three matching products in sorted order`() {
        assertEquals(
            listOf(
                listOf("alpha", "alpine", "alps"),
                listOf("alpha", "alpine", "alps"),
                listOf("alpha", "alpine", "alps"),
            ),
            solution.suggestedProducts(
                arrayOf("alps", "alpine", "alpha", "alto"),
                "alp",
            ),
        )
    }

    @Test
    fun `returns all products when fewer than three share the prefix`() {
        assertEquals(
            listOf(listOf("cat", "cater"), listOf("cat", "cater"), listOf("cat", "cater")),
            solution.suggestedProducts(arrayOf("cat", "cater", "dog"), "cat"),
        )
    }

    @Test
    fun `does not reuse products between calls`() {
        assertEquals(
            listOf(listOf("apple")),
            solution.suggestedProducts(arrayOf("apple"), "a"),
        )
        assertEquals(
            listOf(listOf("banana")),
            solution.suggestedProducts(arrayOf("banana"), "b"),
        )
    }
}
