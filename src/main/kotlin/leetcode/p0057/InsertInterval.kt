package leetcode.p0057

/**
 * # 57. Insert Interval
 *
 * You are given an array of non-overlapping intervals `intervals`, where
 * `intervals[i] = [start_i, end_i]` represents the start and end of the interval, and the
 * intervals are sorted in ascending order by `start_i`. You are also given an interval
 * `newInterval = [start, end]` representing the start and end of another interval.
 *
 * Insert `newInterval` into `intervals` so that the resulting intervals remain sorted in
 * ascending order by start and contain no overlapping intervals. Merge overlapping intervals if
 * necessary. Return the intervals after the insertion.
 *
 * You do not need to modify `intervals` in place. You may create and return a new array.
 *
 * Examples:
 * - Input: `intervals = [[1,3],[6,9]]`, `newInterval = [2,5]`. Output: `[[1,5],[6,9]]`.
 * - Input: `intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]]`, `newInterval = [4,8]`.
 *   Output: `[[1,2],[3,10],[12,16]]`. Explanation: The new interval overlaps with `[3,5]`,
 *   `[6,7]`, and `[8,10]`.
 *
 * Constraints:
 * - `0 <= intervals.length <= 10^4`.
 * - `intervals[i].length == 2`.
 * - `0 <= start_i <= end_i <= 10^5`.
 * - `intervals` is sorted by `start_i` in ascending order.
 * - `newInterval.length == 2`.
 * - `0 <= start <= end <= 10^5`.
 *
 * [LeetCode 57: Insert Interval](https://leetcode.com/problems/insert-interval/)
 */
class Solution {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        val mergedIntervals = mutableListOf<IntArray>()

        // Copy intervals strictly before the new interval
        var i = 0
        while (i < intervals.size && intervals[i][1] < newInterval[0]) {
            mergedIntervals.add(intervals[i])
            i++
        }

        // Merge the found interval and continue until we move out of a merged interval
        while (i < intervals.size && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = minOf(newInterval[0], intervals[i][0])
            newInterval[1] = maxOf(newInterval[1], intervals[i][1])
            i++
        }

        mergedIntervals.add(newInterval)

        // Add the rest of the intervals
        while (i < intervals.size) {
            mergedIntervals.add(intervals[i])
            i++
        }

        return mergedIntervals.toTypedArray()
    }
}