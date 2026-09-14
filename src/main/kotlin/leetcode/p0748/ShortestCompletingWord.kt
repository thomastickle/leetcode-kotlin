package leetcode.p0748

/**
 * # 748. Shortest Completing Word
 *
 * Given a string `licensePlate` and an array of strings `words`, find the shortest completing word
 * in `words`.
 *
 * A completing word contains every letter that appears in `licensePlate`, ignoring numbers, spaces,
 * and letter case. If a letter appears multiple times in `licensePlate`, the completing word must
 * contain that letter at least the same number of times. For example, `step` completes `1s3 PSt`
 * because it contains `s`, `p`, `s`, and `t`.
 *
 * If more than one completing word has the shortest length, return the one that appears first in
 * `words`. It is guaranteed that at least one completing word exists.
 *
 * Examples:
 * - Input: `licensePlate = "1s3 PSt"`, `words = ["step", "steps", "stripe", "stepple"]`.
 *   Output: `"steps"`. `"steps"` is the shortest word containing `s`, `p`, `s`, and `t`.
 * - Input: `licensePlate = "1s3 456"`, `words = ["looks", "pest", "stew", "show"]`.
 *   Output: `"pest"`. `"pest"`, `"stew"`, and `"show"` are completing words of the shortest
 *   length, so the first one in `words` is returned.
 *
 * Constraints:
 * - `1 <= licensePlate.length <= 7`.
 * - `1 <= words.length <= 1000`.
 * - `1 <= words[i].length <= 15`.
 * - `licensePlate` consists of digits, lowercase English letters, and spaces.
 * - `words[i]` consists of lowercase English letters.
 * - At least one completing word exists in `words`.
 *
 * [LeetCode 748: Shortest Completing Word](https://leetcode.com/problems/shortest-completing-word/)
 */
class Solution {
    fun shortestCompletingWord(licensePlate: String, words: Array<String>): String {
        val required = IntArray(26).apply {
            licensePlate.forEach { char ->
                if (char.isLetter()) {
                    this[char.lowercaseChar() - 'a']++
                }
            }
        }

        var shortestWord: String? = null
        wordsIterating@ for (word in words) {
            if (shortestWord != null && shortestWord.length <= word.length) {
                continue
            }

            val counts = IntArray(26).apply {
                word.forEach { char ->
                    this[char- 'a']++
                }
            }

            for (index in required.indices) {
                if (counts[index] < required[index]) continue@wordsIterating
            }

            shortestWord = word
        }
        return shortestWord!!
    }
}
