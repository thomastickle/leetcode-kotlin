package leetcode.p1768

/**
 * # 1768. Merge Strings Alternately
 *
 * Given `word1` and `word2`, build a new string by alternately taking characters from each input,
 * beginning with `word1`. When one input is longer, append all of its remaining characters after
 * the alternating portion.
 *
 * Examples:
 * - `word1 = "abc"`, `word2 = "pqr"` returns `"apbqcr"`.
 * - `word1 = "ab"`, `word2 = "pqrs"` returns `"apbqrs"`; the remaining `"rs"` comes from
 *   `word2`.
 * - `word1 = "abcd"`, `word2 = "pq"` returns `"apbqcd"`; the remaining `"cd"` comes from
 *   `word1`.
 *
 * Constraints:
 * - `1 <= word1.length, word2.length <= 100`
 * - Both inputs contain only lowercase English letters.
 *
 * [LeetCode 1768: Merge Strings Alternately](https://leetcode.com/problems/merge-strings-alternately/)
 */
class Solution {
  fun mergeAlternately(word1: String, word2: String): String =
      buildString(word1.length + word2.length) {
        val pairedLength = minOf(word1.length, word2.length)

        for (i in 0 until pairedLength) {
          append(word1[i])
          append(word2[i])
        }

        append(word1, pairedLength, word1.length)
        append(word2, pairedLength, word2.length)
      }
}
