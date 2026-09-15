package leetcode.p0072

/**
 * # 72. Edit Distance
 *
 * Given two strings, `word1` and `word2`, return the minimum number of operations required to
 * convert `word1` to `word2`.
 *
 * You may perform these operations on a word:
 * - Insert one character.
 * - Delete one character.
 * - Replace one character with another character.
 *
 * Examples:
 * - Input: `word1 = "horse"`, `word2 = "ros"`. Output: `3`. Explanation: `horse` -> `rorse`
 *   (replace `h` with `r`) -> `rose` (delete the second `r`) -> `ros` (delete `e`).
 * - Input: `word1 = "intention"`, `word2 = "execution"`. Output: `5`. Explanation:
 *   `intention` -> `inention` (delete `t`) -> `enention` (replace `i` with `e`) -> `exention`
 *   (replace `n` with `x`) -> `exection` (replace `n` with `c`) -> `execution` (insert `u`).
 *
 * Constraints:
 * - `0 <= word1.length, word2.length <= 500`.
 * - `word1` and `word2` consist of lowercase English letters.
 *
 * [LeetCode 72: Edit Distance](https://leetcode.com/problems/edit-distance/)
 */
class Solution {
    fun minDistance(word1: String, word2: String): Int {
        TODO("Implement solution")
    }
}
