package leetcode.p0128

/**
 * # 128. Longest Consecutive Sequence
 *
 * Given an unsorted integer array `nums`, return the length of the longest consecutive elements
 * sequence.
 *
 * A consecutive sequence is a sequence of elements in which each element is exactly `1` greater
 * than the previous element. The elements do not have to be consecutive in the original array.
 *
 * Your algorithm must run in `O(n)` time.
 *
 * Examples:
 * - Input: `nums = [100,4,200,1,3,2]`. Output: `4`.
 *   Explanation: The longest consecutive elements sequence is `[1,2,3,4]`, so its length is `4`.
 * - Input: `nums = [0,3,7,2,5,8,4,6,0,1]`. Output: `9`.
 * - Input: `nums = [1,0,1,2]`. Output: `3`.
 *
 * Constraints:
 * - `0 <= nums.length <= 10^5`.
 * - `-10^9 <= nums[i] <= 10^9`.
 *
 * [LeetCode 128: Longest Consecutive Sequence](https://leetcode.com/problems/longest-consecutive-sequence/)
 */
class Solution {
    fun longestConsecutive(nums: IntArray): Int {
        val numSet = nums.toSet()
        var maxIntervalLength = 0
        for (num in numSet) {
            if (num - 1 !in numSet) {
                var length = 1
                while (num + length in numSet) {
                    length++
                }
                if (length > maxIntervalLength) {
                    maxIntervalLength = length
                }
            }
        }

        return maxIntervalLength
    }

    fun longestConsecutiveRadix(nums: IntArray): Int {
        if (nums.isEmpty()) return 0

        val scratch = IntArray(nums.size)
        val counts = IntArray(256)

        var source = nums
        var destination = scratch

        // Four passes, 8 bits each, for 32-bit integers.
        for (shift in 0..24 step 8) {
            counts.fill(0)

            // Count occurrences in each bucket.
            for (value in source) {
                val bucket = ((value xor Int.MIN_VALUE) ushr shift) and 0xFF
                counts[bucket]++
            }

            // Convert counts into starting positions.
            var offset = 0
            for (bucket in counts.indices) {
                val count = counts[bucket]
                counts[bucket] = offset
                offset += count
            }

            // Distribute values in stable order.
            for (value in source) {
                val bucket = ((value xor Int.MIN_VALUE) ushr shift) and 0xFF
                destination[counts[bucket]++] = value
            }

            // Swap input and output buffers.
            val temp = source
            source = destination
            destination = temp
        }

        // Find the longest consecutive sequence.
        var longest = 1
        var currentLength = 1

        for (index in 1 until source.size) {
            val current = source[index]
            val previous = source[index - 1]

            if (current == previous) continue

            if (current == previous + 1) {
                currentLength++
            } else {
                currentLength = 1
            }

            if (currentLength > longest) {
                longest = currentLength
            }
        }

        return longest
    }
}
