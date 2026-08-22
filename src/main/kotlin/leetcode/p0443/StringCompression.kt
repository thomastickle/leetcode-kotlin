package leetcode.p0443

/**
 * # 443. String Compression
 *
 * Compress the character array `chars` one consecutive group at a time. Write a group of length
 * one as its character alone; otherwise, write the character followed by the decimal digits of
 * the group length. Store the compressed result at the beginning of `chars` and return its new
 * length. Counts of 10 or more occupy multiple characters. Values beyond the returned length are
 * irrelevant. The algorithm must use only constant additional space.
 *
 * Examples:
 * - `chars = ["a", "a", "b", "b", "c", "c", "c"]` returns `6`; the first six entries become
 *   `["a", "2", "b", "2", "c", "3"]`, representing `"a2b2c3"`.
 * - `chars = ["a"]` returns `1`, with the first entry remaining `["a"]`.
 * - `chars = ["a", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b", "b"]`
 *   returns `4`; the first four entries become `["a", "b", "1", "2"]`, representing `"ab12"`.
 *
 * Constraints:
 * - `1 <= chars.length <= 2000`
 * - Each entry is an uppercase or lowercase English letter, digit, or symbol.
 *
 * [LeetCode 443: String Compression](https://leetcode.com/problems/string-compression/)
 */
class Solution {
    fun compress(chars: CharArray): Int {
        var write = 0
        var start = 0

        while (start < chars.size) {
            var end = start

            while (end < chars.size && chars[end] == chars[start]) {
                end++
            }

            chars[write++] = chars[start]

            val count = end - start
            if (count > 1) {
                for (digit in count.toString()) {
                    chars[write++] = digit
                }
            }

            start = end
        }

        return write
    }
}
