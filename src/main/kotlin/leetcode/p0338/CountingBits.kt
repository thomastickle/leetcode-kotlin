package leetcode.p0338

/**
 * # 338. Counting Bits
 *
 * Given an integer `n`, return an array `ans` of length `n + 1` such that, for every `i` where
 * `0 <= i <= n`, `ans[i]` is the number of `1` bits in the binary representation of `i`.
 * Do not use built-in functions to solve the problem.
 *
 * Examples:
 * - Input: `n = 2`. Output: `[0, 1, 1]`. Explanation: `0` has zero `1` bits, `1` has one
 *   `1` bit, and `2` (`10` in binary) has one `1` bit.
 * - Input: `n = 5`. Output: `[0, 1, 1, 2, 1, 2]`. Explanation: `0` through `5` have,
 *   respectively, zero, one, one, two, one, and two `1` bits in binary.
 *
 * Constraints:
 * - `0 <= n <= 10^5`.
 *
 * Follow-up: It is easy to devise a solution with `O(n log n)` runtime. Can you solve it in
 * `O(n)` time?
 *
 * [LeetCode 338: Counting Bits](https://leetcode.com/problems/counting-bits/)
 */
class Solution {
    fun countBits(n: Int): IntArray {
        val bits = IntArray(n + 1)

        for (currentValue in 1..n) {
            bits[currentValue] = bits[currentValue shr 1] + (currentValue and 1)
        }

        return bits
    }
}
