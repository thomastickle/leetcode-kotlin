package leetcode.p0739

/**
 * # 739. Daily Temperatures
 *
 * Given an array of integers `temperatures` representing the daily temperatures, return an array
 * `answer` such that `answer[i]` is the number of days that must be waited after day `i` to reach
 * a warmer temperature. If there is no future day for which a warmer temperature exists, set
 * `answer[i]` to `0` instead.
 *
 * Examples:
 * - Input: `temperatures = [73,74,75,71,69,72,76,73]`
 *   Output: `[1,1,4,2,1,1,0,0]`
 * - Input: `temperatures = [30,40,50,60]`
 *   Output: `[1,1,1,0]`
 * - Input: `temperatures = [30,60,90]`
 *   Output: `[1,1,0]`
 *
 * Constraints:
 * - `1 <= temperatures.length <= 10^5`
 * - `30 <= temperatures[i] <= 100`
 *
 * Follow-up: Can you solve this problem in `O(n)` time and `O(n)` space?
 *
 * [LeetCode 739: Daily Temperatures](https://leetcode.com/problems/daily-temperatures/)
 */
class Solution {

    fun dailyTemperatures(temperatures: IntArray): IntArray {
        val answer = IntArray(temperatures.size)
        val stack = ArrayDeque<Int>()

        for (index in temperatures.indices) {
            while (stack.isNotEmpty() && (temperatures[stack.last()] < temperatures[index])) {
               val poppedEntry = stack.removeLast()
               answer[poppedEntry] = index - poppedEntry
            }
            stack.add(index)
        }

        return answer
    }
}
