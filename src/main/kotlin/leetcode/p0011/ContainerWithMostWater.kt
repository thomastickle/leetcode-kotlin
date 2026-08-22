package leetcode.p0011

/**
 * # 11. Container With Most Water
 *
 * Given an integer array `height` of length `n`, imagine `n` vertical lines whose endpoints are
 * `(i, 0)` and `(i, height[i])`. Choose two lines that, together with the x-axis, form a container
 * holding the greatest possible amount of water. Return that maximum amount. The container's
 * sides must remain vertical and cannot be slanted.
 *
 * Examples:
 * - `height = [1, 8, 6, 2, 5, 4, 8, 3, 7]` returns `49`.
 * - `height = [1, 1]` returns `1`.
 *
 * Constraints:
 * - `n == height.length`
 * - `2 <= n <= 10^5`
 * - `0 <= height[i] <= 10^4`
 *
 * [LeetCode 11: Container With Most Water](https://leetcode.com/problems/container-with-most-water/)
 */
class Solution {
    fun maxArea(height: IntArray): Int {
        var left = 0
        var right = height.lastIndex
        var maxArea = 0

        while (left < right) {
            val area = minOf(height[left], height[right]) * (right - left)
            maxArea = maxOf(area, maxArea)

            if (height[left] <= height[right]) {
                left++
            } else {
                right--
            }
        }

        return maxArea
    }
}
