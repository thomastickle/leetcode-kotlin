package leetcode.p0374

/**
 * # 374. Guess Number Higher or Lower
 *
 * We are playing the Guess Game. The game works as follows:
 * - I choose a number from `1` to `n`.
 * - You try to guess the number.
 * - Whenever your guess is wrong, I tell you whether the number I chose is higher or lower than
 *   your guess.
 *
 * You can call the predefined API `guess(num)` to receive feedback about a guess:
 * - `guess(num)` returns `-1` when the number I chose is lower than `num`.
 * - `guess(num)` returns `1` when the number I chose is higher than `num`.
 * - `guess(num)` returns `0` when `num` equals the number I chose.
 *
 * Given the integer `n` and the hidden picked number, return the number that was picked.
 *
 * Examples:
 * - Input: `n = 10`, `pick = 6`. Output: `6`.
 * - Input: `n = 1`, `pick = 1`. Output: `1`.
 * - Input: `n = 2`, `pick = 1`. Output: `1`.
 *
 * Constraints:
 * - `1 <= n <= 2^31 - 1`
 * - `1 <= pick <= n`
 *
 * [LeetCode 374: Guess Number Higher or Lower](https://leetcode.com/problems/guess-number-higher-or-lower/)
 */
abstract class GuessGame(private val pickedNumber: Int = 0) {
    fun guess(num: Int): Int = pickedNumber.compareTo(num)

    abstract fun guessNumber(n: Int): Int
}

class Solution(pickedNumber: Int = 0) : GuessGame(pickedNumber) {
    override fun guessNumber(n: Int): Int {
        var low = 1
        var high = n

        while (low <= high) {
            val midpoint = low + (high - low) / 2
            when (guess(midpoint)) {
                -1 -> high = midpoint - 1
                1 -> low = midpoint + 1
                0 -> return midpoint
            }
        }
        return -1
    }
}
