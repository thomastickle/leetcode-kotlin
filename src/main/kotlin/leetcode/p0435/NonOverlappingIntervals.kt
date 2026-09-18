package leetcode.p0435

import java.util.*

/**
 * # 435. Non-overlapping Intervals
 *
 * Given an array of intervals `intervals` where `intervals[i] = [start_i, end_i]`, return the
 * minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 *
 * Note that intervals which only touch at a point are non-overlapping. For example, `[1, 2]` and
 * `[2, 3]` are non-overlapping.
 *
 * Examples:
 * - Input: `intervals = [[1,2],[2,3],[3,4],[1,3]]`, Output: `1`
 *   Explanation: `[1,3]` can be removed and the rest of the intervals are non-overlapping.
 * - Input: `intervals = [[1,2],[1,2],[1,2]]`, Output: `2`
 *   Explanation: You need to remove two `[1,2]` to make the rest of the intervals non-overlapping.
 * - Input: `intervals = [[1,2],[2,3]]`, Output: `0`
 *   Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 *
 * Constraints:
 * - `1 <= intervals.length <= 10^5`
 * - `intervals[i].length == 2`
 * - `-5 * 10^4 <= start_i < end_i <= 5 * 10^4`
 *
 * [LeetCode 435: Non-overlapping Intervals](https://leetcode.com/problems/non-overlapping-intervals/)
 */
class Solution {
    fun eraseOverlapIntervals(intervals: Array<IntArray>): Int {
        intervals.sortBy { it[1]}

        var count = 1
        var previousEnd = intervals[0][1]

        for (i in 1 until intervals.size) {
            if (intervals[i][0] >= previousEnd) {
                previousEnd = intervals[i][1]
                count++
            }
        }

        return intervals.size - count
    }
}
