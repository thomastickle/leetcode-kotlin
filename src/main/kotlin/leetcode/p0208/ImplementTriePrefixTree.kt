package leetcode.p0208

/**
 * # 208. Implement Trie (Prefix Tree)
 *
 * A trie, pronounced as "try" and also called a prefix tree, is a tree data structure used to
 * efficiently store and retrieve strings in a dataset. Tries are useful for applications such as
 * autocomplete and spellcheckers.
 *
 * Implement the `Trie` class:
 * - `Trie()` initializes the trie object.
 * - `void insert(String word)` inserts the string `word` into the trie.
 * - `boolean search(String word)` returns `true` if `word` is in the trie, meaning it was inserted
 *   before, and `false` otherwise.
 * - `boolean startsWith(String prefix)` returns `true` if there is a previously inserted string
 *   `word` that has the prefix `prefix`, and `false` otherwise.
 *
 * Example 1:
 * - Input: `operations = ["Trie", "insert", "search", "search", "startsWith", "insert", "search"]`.
 * - Arguments: `[[], ["apple"], ["apple"], ["app"], ["app"], ["app"], ["app"]]`.
 * - Output: `[null, null, true, false, true, null, true]`.
 * - Explanation:
 *   ```
 *   Trie trie = new Trie();
 *   trie.insert("apple");
 *   trie.search("apple");     // returns true
 *   trie.search("app");       // returns false
 *   trie.startsWith("app");   // returns true
 *   trie.insert("app");
 *   trie.search("app");       // returns true
 *   ```
 *
 * Constraints:
 * - `1 <= word.length, prefix.length <= 2000`.
 * - `word` and `prefix` consist only of lowercase English letters.
 * - At most `3 * 10^4` calls in total will be made to `insert`, `search`, and `startsWith`.
 *
 * [LeetCode 208: Implement Trie (Prefix Tree)](https://leetcode.com/problems/implement-trie-prefix-tree/)
 */
class Trie {

    private class TrieNode {
        val children: Array<TrieNode?> = arrayOfNulls(26)
        var isWord: Boolean = false
    }

    private val root = TrieNode()

    fun insert(word: String) {
        var currentNode = root

        for (c in word) {
            val index = c - 'a'

            if (currentNode.children[index] == null) {
                currentNode.children[index] = TrieNode()
            }

            currentNode = currentNode.children[index]!!
        }

        currentNode.isWord = true
    }

    fun search(word: String): Boolean {
        return searchHelper(word)
    }

    fun startsWith(prefix: String): Boolean {
        return searchHelper(prefix, true)
    }

    private fun searchHelper(word: String, prefixMode: Boolean = false): Boolean {
        var currentNode: TrieNode = root

        for (c in word) {
            currentNode = currentNode.children[c-'a'] ?: return false
        }

        return currentNode.isWord || prefixMode
    }
}
