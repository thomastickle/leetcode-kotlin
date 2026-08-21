package leetcode.p0151

class Solution {
//    fun reverseWords(s: String) =
//        s.split(" ").filter { it.isNotEmpty() }.asReversed().joinToString(" ")

    fun reverseWords(s: String): String {
        val output = StringBuilder()
        var i = s.length - 1  // We use this because leetcode makes the kotlin stdlib very costly
        while (i >= 0) {
            // Skip spaces
            while (i >= 0 && s[i] == ' ') {
                i--
            }

            if (i < 0) break

            val wordEnd = i

            // Find beginning of word
            while (i >= 0 && s[i] != ' ') {
                i--
            }

            if (output.isNotEmpty()) {
                output.append(' ')
            }

            output.append(s, i + 1, wordEnd + 1)
        }

        return output.toString()
    }


}
