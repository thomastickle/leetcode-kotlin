package leetcode.p0215

/**
 * # 215. Kth Largest Element in an Array
 *
 * Given an integer array `nums` and an integer `k`, return the `k`th largest element in the array.
 *
 * Note that it is the `k`th largest element in the sorted order, not the `k`th distinct element.
 *
 * Can you solve it without sorting?
 *
 * Examples:
 * - Input: `nums = [3,2,1,5,6,4], k = 2`. Output: `5`.
 * - Input: `nums = [3,2,3,1,2,4,5,5,6], k = 4`. Output: `4`.
 *
 * Constraints:
 * - `1 <= k <= nums.length <= 10^5`
 * - `-10^4 <= nums[i] <= 10^4`
 *
 * [LeetCode 215: Kth Largest Element in an Array](https://leetcode.com/problems/kth-largest-element-in-an-array/)
 */
class Solution {
    private class MaxHeap(private val values: IntArray) {
        private var size = values.size

        init {
            for (i in size / 2 - 1 downTo 0) {
                siftDown(i)
            }
        }

        /**
         * Remove the top of the heap.
         */
        fun removeMax(): Int {
            check(size > 0)

            val max = values[0]

            size--
            values[0] = values[size]
            siftDown(0)

            return max
        }

        private fun siftDown(start: Int) {
            var parent = start

            while (true) {
                val left = parent * 2 + 1
                if (left >= size) return

                val right = left + 1
                val largerChild = if (right < size && values[right] > values[left]) right else left

                if (values[parent] >= values[largerChild]) return

                swap(parent, largerChild)

                parent = largerChild
            }
        }

        private fun swap(first: Int, second: Int) {
            val temp = values[first]
            values[first] = values[second]
            values[second] = temp
        }
    }


    fun findKthLargest(nums: IntArray, k: Int): Int {
        val maxHeap = MaxHeap(nums)

        repeat(k - 1) {
            maxHeap.removeMax()
        }
        return maxHeap.removeMax()
    }

}
