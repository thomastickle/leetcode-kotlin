package leetcode.p0443

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
