package leetcode.p0006

/**
 * # 6. Zigzag Conversion
 *
 * The string `s` is written in a zigzag pattern on a given number of rows: begin at the top,
 * write characters vertically downward, then diagonally upward toward the top, and repeat this
 * pattern. Read the rows from top to bottom, left to right, to produce the converted string.
 *
 * Examples:
 * - Input: `s = "PAYPALISHIRING"`, `numRows = 3`. Output: `"PAHNAPLSIIGYIR"`.
 *   The rows read as `"PAHN"`, `"APLSIIG"`, and `"YIR"`.
 * - Input: `s = "PAYPALISHIRING"`, `numRows = 4`. Output: `"PINALSIGYAHRPI"`.
 *   The rows read as `"PINAL"`, `"ASIG"`, `"YAH"`, and `"PI"`.
 * - Input: `s = "A"`, `numRows = 1`. Output: `"A"`.
 *
 * Constraints:
 * - `1 <= s.length <= 1000`
 * - `s` consists of English letters (lower-case and upper-case), `','` and `'.'`.
 * - `1 <= numRows <= 1000`
 *
 * Follow-up: Could you solve it in `O(1)` extra space?
 *
 * [LeetCode 6: Zigzag Conversion](https://leetcode.com/problems/zigzag-conversion/)
 */
class Solution {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) return s

        val cycleLength = 2 * (numRows - 1)
        val length = s.length
        val output = StringBuilder(length)

        for (currentRow in 0 until numRows) {
            for (j in currentRow until length step cycleLength) {
                output.append(s[j])
                if (currentRow != 0 && currentRow !=  numRows - 1) {
                    val diag = j + cycleLength - 2 * currentRow
                    if (diag < length) output.append(s[diag])
                }
            }
        }

        return output.toString()
    }
}
