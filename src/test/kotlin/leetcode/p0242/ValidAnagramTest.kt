package leetcode.p0242

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ValidAnagramTest {
    private val solution = Solution()

    @Test
    fun `returns true for the first example`() {
        assertTrue(solution.isAnagram("anagram", "nagaram"))
    }

    @Test
    fun `returns false for the second example`() {
        assertFalse(solution.isAnagram("rat", "car"))
    }

    @Test
    fun `returns true when the same letters appear in a different order`() {
        assertTrue(solution.isAnagram("aabbcc", "cbacba"))
    }

    @Test
    fun `returns false when letter frequencies differ`() {
        assertFalse(solution.isAnagram("aabb", "abbb"))
    }

    @Test
    fun `returns false when string lengths differ`() {
        assertFalse(solution.isAnagram("ab", "a"))
    }

    @Test
    fun `handles minimum length strings`() {
        assertTrue(solution.isAnagram("a", "a"))
    }

    @Test
    fun `handles maximum length strings`() {
        val s = "a".repeat(50_000)
        val t = "a".repeat(50_000)

        assertTrue(solution.isAnagram(s, t))
    }
}
