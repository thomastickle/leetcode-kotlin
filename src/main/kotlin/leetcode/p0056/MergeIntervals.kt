package leetcode.p0056

/**
 * # 56. Merge Intervals
 *
 * Given an array of intervals where `intervals[i] = [start_i, end_i]`, merge all overlapping
 * intervals and return an array of the non-overlapping intervals that cover all the intervals in
 * the input.
 *
 * Intervals that share an endpoint are merged because they overlap at that point.
 *
 * Examples:
 * - Input: `intervals = [[1,3],[2,6],[8,10],[15,18]]`. Output: `[[1,6],[8,10],[15,18]]`.
 *   Explanation: `[1,3]` and `[2,6]` overlap, so they are merged into `[1,6]`.
 * - Input: `intervals = [[1,4],[4,5]]`. Output: `[[1,5]]`.
 *   Explanation: `[1,4]` and `[4,5]` overlap at endpoint `4`, so they are merged into `[1,5]`.
 *
 * Constraints:
 * - `1 <= intervals.length <= 10^4`.
 * - `intervals[i].length == 2`.
 * - `0 <= start_i <= end_i <= 10^4`.
 *
 * [LeetCode 56: Merge Intervals](https://leetcode.com/problems/merge-intervals/)
 */
class Solution {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        intervals.sortWith { a, b ->
            a[0].compareTo(b[0])
        }

        val mergedIntervals = mutableListOf<IntArray>()
        var mergedStart = intervals[0][0]
        var mergedEnd = intervals[0][1]

        for (index in 1 until intervals.size) {
            val currentInterval = intervals[index]
            val currentStart = currentInterval[0]
            val currentEnd = currentInterval[1]

            if (currentStart <= mergedEnd) {
                if (currentEnd > mergedEnd) {
                    mergedEnd = currentEnd
                }
            } else {
                mergedIntervals.add(intArrayOf(mergedStart, mergedEnd))
                mergedStart = currentStart
                mergedEnd = currentEnd
            }
        }

        mergedIntervals.add(intArrayOf(mergedStart, mergedEnd))

        return mergedIntervals.toTypedArray()
    }
}
