package leetcode.p1268

/**
 * # 1268. Search Suggestions System
 *
 * Given an array of product names `products` and a string `searchWord`, design a system that
 * suggests at most three product names from `products` after each character of `searchWord` is
 * typed. Suggested products must share a common prefix with the portion of `searchWord` typed so
 * far. If more than three products match, return the three that come first in lexicographical
 * order.
 *
 * Return a list of lists containing the suggested products after each character of `searchWord` is
 * typed.
 *
 * **Example 1:**
 * - Input: `products = ["mobile", "mouse", "moneypot", "monitor", "mousepad"]`,
 *   `searchWord = "mouse"`.
 * - Output: `[["mobile", "moneypot", "monitor"], ["mobile", "moneypot", "monitor"],
 *   ["mouse", "mousepad"], ["mouse", "mousepad"], ["mouse", "mousepad"]]`.
 * - Explanation: The products sorted lexicographically are
 *   `["mobile", "moneypot", "monitor", "mouse", "mousepad"]`. After typing `m` and `mo`,
 *   all products match, so the system shows `["mobile", "moneypot", "monitor"]`. After typing
 *   `mou`, `mous`, and `mouse`, it suggests `["mouse", "mousepad"]`.
 *
 * **Example 2:**
 * - Input: `products = ["havana"]`, `searchWord = "havana"`.
 * - Output: `[["havana"], ["havana"], ["havana"], ["havana"], ["havana"], ["havana"]]`.
 *
 * **Example 3:**
 * - Input: `products = ["bags", "baggage", "banner", "box", "cloths"]`,
 *   `searchWord = "bags"`.
 * - Output: `[["baggage", "bags", "banner"], ["baggage", "bags", "banner"],
 *   ["baggage", "bags"], ["bags"]]`.
 *
 * **Example 4:**
 * - Input: `products = ["havana"]`, `searchWord = "tatiana"`.
 * - Output: `[[], [], [], [], [], [], []]`.
 *
 * **Constraints:**
 * - `1 <= products.length <= 1000`.
 * - There are no repeated elements in `products`.
 * - `1 <= sum(products[i].length) <= 2 * 10^4`.
 * - All characters of `products[i]` are lowercase English letters.
 * - `1 <= searchWord.length <= 1000`.
 * - All characters of `searchWord` are lowercase English letters.
 *
 * [LeetCode 1268: Search Suggestions System](https://leetcode.com/problems/search-suggestions-system/)
 */
class Solution {
    fun suggestedProducts(products: Array<String>, searchWord: String): List<List<String>> {
        TODO("Implement solution")
    }
}
