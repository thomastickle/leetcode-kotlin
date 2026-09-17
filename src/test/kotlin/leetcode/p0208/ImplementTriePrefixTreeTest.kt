package leetcode.p0208

import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class ImplementTriePrefixTreeTest {
    @Test
    fun `follows the operation sequence from the example`() {
        val trie = Trie()

        trie.insert("apple")
        assertTrue(trie.search("apple"))
        assertFalse(trie.search("app"))
        assertTrue(trie.startsWith("app"))
        trie.insert("app")
        assertTrue(trie.search("app"))
    }

    @Test
    fun `does not find a word that was never inserted`() {
        val trie = Trie()

        trie.insert("apple")

        assertFalse(trie.search("application"))
        assertFalse(trie.search("banana"))
    }

    @Test
    fun `distinguishes a complete word from its prefix`() {
        val trie = Trie()

        trie.insert("app")

        assertTrue(trie.search("app"))
        assertFalse(trie.search("ap"))
        assertTrue(trie.startsWith("ap"))
    }

    @Test
    fun `matches prefixes shared by multiple words`() {
        val trie = Trie()

        trie.insert("apple")
        trie.insert("apply")

        assertTrue(trie.startsWith("app"))
        assertTrue(trie.startsWith("appl"))
        assertFalse(trie.startsWith("apples"))
    }

    @Test
    fun `supports a single-character word and prefix`() {
        val trie = Trie()

        trie.insert("a")

        assertTrue(trie.search("a"))
        assertTrue(trie.startsWith("a"))
        assertFalse(trie.search("b"))
        assertFalse(trie.startsWith("b"))
    }

    @Test
    fun `keeps inserted words independent across separate tries`() {
        val first = Trie()
        val second = Trie()

        first.insert("apple")

        assertTrue(first.search("apple"))
        assertFalse(second.search("apple"))
    }
}
