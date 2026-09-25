package leetcode.p0068

/**
 * # 68. Text Justification
 *
 * Given an array of strings `words` and an integer `maxWidth`, format the text so that every line
 * contains exactly `maxWidth` characters and is fully justified on both the left and right.
 *
 * Pack as many words as possible into each line using a greedy approach. Add spaces when necessary
 * so every line has exactly `maxWidth` characters. For lines with multiple words, distribute the
 * extra spaces between words as evenly as possible. If the spaces cannot be divided evenly, the
 * gaps on the left receive more spaces than the gaps on the right. The final line must be
 * left-justified: use one space between words and append any remaining spaces at the end. A line
 * containing only one word is also left-justified.
 *
 * A word is a sequence of non-space characters. Every word has a positive length and is no longer
 * than `maxWidth`, and the input contains at least one word.
 *
 * Examples:
 * - Input: `words = ["This", "is", "an", "example", "of", "text", "justification."], maxWidth = 16`.
 *   Output: `["This    is    an", "example  of text", "justification.  "]`.
 * - Input: `words = ["What", "must", "be", "acknowledgment", "shall", "be"], maxWidth = 16`.
 *   Output: `["What   must   be", "acknowledgment  ", "shall be        "]`.
 *   Explanation: The last line is `"shall be        "` rather than `"shall     be"` because the
 *   last line is left-justified. The second line is also left-justified because it contains only
 *   one word.
 * - Input: `words = ["Science", "is", "what", "we", "understand", "well", "enough", "to",
 *   "explain", "to", "a", "computer.", "Art", "is", "everything", "else", "we", "do"],
 *   maxWidth = 20`.
 *   Output: `["Science  is  what we", "understand      well", "enough to explain to",
 *   "a  computer.  Art is", "everything  else  we", "do                  "]`.
 *
 * Constraints:
 * - `1 <= words.length <= 300`
 * - `1 <= words[i].length <= 20`
 * - `words[i]` consists only of English letters and symbols.
 * - `1 <= maxWidth <= 100`
 * - `words[i].length <= maxWidth`
 *
 * [LeetCode 68: Text Justification](https://leetcode.com/problems/text-justification/)
 */
class Solution {
    fun fullJustify(words: Array<String>, maxWidth: Int): List<String> {
        TODO("Implement solution")
    }
}
