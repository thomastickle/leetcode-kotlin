package leetcode.p1207

/**
 * # 1207. Unique Number of Occurrences
 *
 * Given an array of integers `arr`, return `true` if the number of occurrences of each value in
 * the array is unique or `false` otherwise.
 *
 * Examples:
 * - Input: `arr = [1,2,2,1,1,3]`. Output: `true`.
 *   Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same
 *   number of occurrences.
 * - Input: `arr = [1,2]`. Output: `false`.
 *   Explanation: The value 1 has 1 occurrence and 2 has 1 occurrence. Both have 1 occurrence, so
 *   the occurrences are not unique.
 * - Input: `arr = [-3,0,1,-3,1,1,1,-3,10,0]`. Output: `true`.
 *   Explanation: The value -3 has 3 occurrences, 0 has 2, 1 has 4, and 10 has 1. All number of
 *   occurrences are unique.
 *
 * Constraints:
 * - `1 <= arr.length <= 1000`
 * - `-1000 <= arr[i] <= 1000`
 *
 * [LeetCode 1207: Unique Number of Occurrences](https://leetcode.com/problems/unique-number-of-occurrences/)
 */
class Solution {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val frequencyByNumber = HashMap<Int, Int>()

        for (number in arr) {
            frequencyByNumber[number] =
                frequencyByNumber.getOrDefault(number, 0) + 1
        }

        val observedFrequencies = HashSet<Int>()

        for (frequency in frequencyByNumber.values) {
            if (!observedFrequencies.add(frequency)) {
                return false
            }
        }

        return true
    }
}
