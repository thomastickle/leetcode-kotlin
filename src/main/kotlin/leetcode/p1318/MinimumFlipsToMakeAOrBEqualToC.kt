package leetcode.p1318

/**
 * # 1318. Minimum Flips to Make a OR b Equal to c
 *
 * Given three positive integers `a`, `b`, and `c`, return the minimum number of bit flips needed
 * in some bits of `a` and `b` to make `(a OR b) == c`. A flip operation changes any single bit in
 * the binary representation of `a` or `b` from `0` to `1`, or from `1` to `0`.
 *
 * Examples:
 * - Input: `a = 2, b = 6, c = 5`. Output: `3`. Explanation: Flip bits so that `a = 1` and
 *   `b = 4`; then `a OR b = 5`.
 * - Input: `a = 4, b = 2, c = 7`. Output: `1`.
 * - Input: `a = 1, b = 2, c = 3`. Output: `0`.
 *
 * Constraints:
 * - `1 <= a, b, c <= 10^9`.
 *
 * [LeetCode 1318: Minimum Flips to Make a OR b Equal to c](https://leetcode.com/problems/minimum-flips-to-make-a-or-b-equal-to-c/)
 */
class Solution {
    fun minFlips(a: Int, b: Int, c: Int): Int {
        val flips = (a or b) xor c
        val extraFlips = flips and (a and b)
        return flips.countOneBits() + extraFlips.countOneBits()
    }
}
