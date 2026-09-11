package leetcode.p2542

import java.util.*

/**
 * # 2542. Maximum Subsequence Score
 *
 * You are given two 0-indexed integer arrays `nums1` and `nums2` of equal length `n`, and a
 * positive integer `k`. Choose a subsequence of indices from `nums1` with length `k`.
 *
 * For chosen indices `i0`, `i1`, ..., `i(k - 1)`, the score is the sum of the selected elements
 * from `nums1` multiplied by the minimum of the selected elements from `nums2`:
 *
 * `(nums1[i0] + nums1[i1] + ... + nums1[i(k - 1)]) *
 * min(nums2[i0], nums2[i1], ..., nums2[i(k - 1)])`
 *
 * Return the maximum possible score.
 *
 * A subsequence of indices is a set derived from `{0, 1, ..., n - 1}` by deleting some or no
 * elements. The selected indices therefore preserve their original order, although any `k`
 * indices may be chosen.
 *
 * Examples:
 * - Input: `nums1 = [1, 3, 3, 2]`, `nums2 = [2, 1, 3, 4]`, `k = 3`. Output: `12`.
 *   The four possible scores are:
 *   - Indices `0, 1, 2`: `(1 + 3 + 3) * min(2, 1, 3) = 7`.
 *   - Indices `0, 1, 3`: `(1 + 3 + 2) * min(2, 1, 4) = 6`.
 *   - Indices `0, 2, 3`: `(1 + 3 + 2) * min(2, 3, 4) = 12`.
 *   - Indices `1, 2, 3`: `(3 + 3 + 2) * min(1, 3, 4) = 8`.
 *   - Therefore, the maximum score is `12`.
 * - Input: `nums1 = [4, 2, 3, 1, 1]`, `nums2 = [7, 5, 10, 9, 6]`, `k = 1`. Output: `30`.
 *   Choosing index `2` is optimal because `nums1[2] * nums2[2] = 3 * 10 = 30`.
 *
 * Constraints:
 * - `n == nums1.length == nums2.length`
 * - `1 <= n <= 10^5`
 * - `0 <= nums1[i], nums2[i] <= 10^5`
 * - `1 <= k <= n`
 *
 * [LeetCode 2542: Maximum Subsequence Score](https://leetcode.com/problems/maximum-subsequence-score/)
 */
class Solution {
    fun maxScore(nums1: IntArray, nums2: IntArray, k: Int): Long {
        val pairWiseSorted = nums1.zip(nums2).sortedByDescending { it.second }

        val minHeap = PriorityQueue<Int>()
        var sum = 0L
        var ans = 0L

        for ((num1, minNum2) in pairWiseSorted) {
            minHeap.add(num1)
            sum += num1

            if (minHeap.size > k) {
                sum -= minHeap.poll()
            }

            if (minHeap.size == k) {
                ans = maxOf(ans, minNum2 * sum)
            }
        }

        return ans
    }
}
