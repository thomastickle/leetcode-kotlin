package leetcode.p1768

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
