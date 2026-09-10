package leetcode.p1137

/**
 * # 1137. N-th Tribonacci Number
 *
 * The Tribonacci sequence `Tn` is defined by `T0 = 0`, `T1 = 1`, `T2 = 1`, and
 * `Tn+3 = Tn + Tn+1 + Tn+2` for `n >= 0`. Given an integer `n`, return the value of `Tn`.
 *
 * Examples:
 * - Input: `n = 4`. Output: `4`. The sequence gives `T3 = 0 + 1 + 1 = 2` and
 *   `T4 = 1 + 1 + 2 = 4`.
 * - Input: `n = 25`. Output: `1389537`.
 *
 * Constraints:
 * - `0 <= n <= 37`.
 *
 * [LeetCode 1137: N-th Tribonacci Number](https://leetcode.com/problems/n-th-tribonacci-number/)
 */
class Solution {
    fun tribonacci(n: Int): Int {
        val cache = IntArray(n + 1) { -1 }

        fun tribonacciHelper(n: Int): Int {
            if (n == 0) return 0
            if (n == 1 || n == 2) return 1

            if (cache[n] != -1) {
                return cache[n]
            }
            val value = tribonacciHelper(n - 3) + tribonacciHelper(n - 2) + tribonacciHelper(n - 1)
            cache[n] = value
            return value
        }

        tailrec fun tribonacciHelperTail(remaining: Int, a: Int, b: Int, c: Int): Int {
            return if (remaining == 0) {
                a
            } else {
                tribonacciHelperTail(remaining - 1, b, c, a + b + c)
            }
        }

        return tribonacciHelper(n)
    }
}
