package leetcode.p0452

/**
 * # 452. Minimum Number of Arrows to Burst Balloons
 *
 * There are spherical balloons taped onto a flat wall represented by the XY-plane. Each balloon is
 * represented by an interval `points[i] = [xstart, xend]`, meaning that the balloon occupies every
 * x-coordinate from `xstart` through `xend`, inclusive.
 *
 * An arrow may be shot vertically upward from any point on the x-axis. An arrow keeps traveling
 * upward indefinitely. A balloon with horizontal range `[xstart, xend]` is burst when the arrow is
 * shot at an x-coordinate satisfying `xstart <= x <= xend`. There is no limit to the number of
 * arrows that may be shot, and one arrow can burst every balloon whose range contains its x-coordinate.
 *
 * Given the array `points`, return the minimum number of arrows that must be shot to burst all
 * balloons.
 *
 * Examples:
 * - Input: `points = [[10,16],[2,8],[1,6],[7,12]]`, Output: `2`
 *   Explanation: Shoot one arrow at `x = 6` to burst `[2,8]` and `[1,6]`, and another at `x = 11`
 *   to burst `[10,16]` and `[7,12]`.
 * - Input: `points = [[1,2],[3,4],[5,6],[7,8]]`, Output: `4`
 *   Explanation: One arrow must be shot for each balloon because no two balloons overlap.
 * - Input: `points = [[1,2],[2,3],[3,4],[4,5]]`, Output: `2`
 *   Explanation: Shoot one arrow at `x = 2` to burst `[1,2]` and `[2,3]`, and another at `x = 4`
 *   to burst `[3,4]` and `[4,5]`.
 *
 * Constraints:
 * - `1 <= points.length <= 10^5`
 * - `points[i].length == 2`
 * - `-2^31 <= xstart < xend <= 2^31 - 1`
 *
 * [LeetCode 452: Minimum Number of Arrows to Burst Balloons](https://leetcode.com/problems/minimum-number-of-arrows-to-burst-balloons/)
 */
class Solution {
    fun findMinArrowShots(points: Array<IntArray>): Int {
        TODO("Implement solution")
    }
}
