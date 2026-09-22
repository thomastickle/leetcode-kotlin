package leetcode.p0042

/**
 * # 42. Trapping Rain Water
 *
 * Given `n` non-negative integers representing an elevation map where the width of each bar is `1`,
 * compute how much water it can trap after raining.
 *
 * Examples:
 * - Input: `height = [0,1,0,2,1,0,1,3,2,1,2,1]`. Output: `6`.
 *   Explanation: The elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case,
 *   6 units of rainwater are being trapped.
 * - Input: `height = [4,2,0,3,2,5]`. Output: `9`.
 *
 * Constraints:
 * - `n == height.length`
 * - `1 <= n <= 2 * 10^4`
 * - `0 <= height[i] <= 10^5`
 *
 * [LeetCode 42: Trapping Rain Water](https://leetcode.com/problems/trapping-rain-water/)
 */
class Solution {
    fun trap(height: IntArray): Int {
        var leftIndex = 0
        var rightIndex = height.size - 1
        var leftMax = 0
        var rightMax = 0
        var answer = 0

        while (leftIndex < rightIndex) {
            leftMax = maxOf(leftMax, height[leftIndex])
            rightMax = maxOf(rightMax, height[rightIndex])

            if (leftMax < rightMax) {
                answer += leftMax - height[leftIndex]
                leftIndex++
            } else {
                answer += rightMax - height[rightIndex]
                rightIndex--
            }
        }

        return answer
    }
}
