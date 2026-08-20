package leetcode.p0345

class Solution {
    fun reverseVowels(s: String): String {
        val chars = s.toCharArray()

        fun Char.isVowel(): Boolean = when (this) {
            'a', 'e', 'i', 'o', 'u',
            'A', 'E', 'I', 'O', 'U' -> true

            else -> false
        }

        var left = 0
        var right = chars.lastIndex

        while (left < right) {
            while (left < right && !chars[left].isVowel()) {
                left++
            }

            while (left < right && !chars[right].isVowel()) {
                right--
            }

            if (left < right) {
                val temp = chars[left]
                chars[left] = chars[right]
                chars[right] = temp

                left++
                right--
            }
        }

        return chars.concatToString()

    }
}
