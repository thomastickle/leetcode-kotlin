package leetcode.p0015

/**
 * # 15. 3Sum
 *
 * Given an integer array `nums`, return all the triplets `[nums[i], nums[j], nums[k]]` such that
 * `i`, `j`, and `k` are different indices and `nums[i] + nums[j] + nums[k] == 0`.
 *
 * The solution set must not contain duplicate triplets. The order of the triplets and the order of
 * the values within each triplet do not matter.
 *
 * Examples:
 * - Input: `nums = [-1, 0, 1, 2, -1, -4]`. Output: `[[-1, -1, 2], [-1, 0, 1]]`.
 *   Explanation: The distinct triplets that sum to zero are `[-1, -1, 2]` and `[-1, 0, 1]`.
 * - Input: `nums = [0, 1, 1]`. Output: `[]`.
 *   Explanation: The only possible triplet does not sum to zero.
 * - Input: `nums = [0, 0, 0]`. Output: `[[0, 0, 0]]`.
 *   Explanation: The only possible triplet sums to zero.
 *
 * Constraints:
 * - `3 <= nums.length <= 3000`.
 * - `-10^5 <= nums[i] <= 10^5`.
 *
 * [LeetCode 15: 3Sum](https://leetcode.com/problems/3sum/)
 */
class Solution {
    fun threeSum(nums: IntArray): List<List<Int>> {
        nums.sort()
        val triplets = mutableListOf<List<Int>>()

        for (fixedIndex in nums.indices) {
            if (nums[fixedIndex] > 0) break

            if (fixedIndex > 0 && nums[fixedIndex] == nums[fixedIndex - 1]) {
                continue
            }

            findPairs(nums, fixedIndex, triplets)
        }

        return triplets
    }

    private fun findPairs(nums: IntArray, fixedIndex: Int, triplets: MutableList<List<Int>>) {
        val fixedValue = nums[fixedIndex]
        val pairTarget = -fixedValue

        var leftIndex = fixedIndex + 1
        var rightIndex = nums.size - 1

        while (leftIndex < rightIndex) {
            val pairSum = nums[leftIndex] + nums[rightIndex]

            when {
                pairSum < pairTarget -> leftIndex++
                pairSum > pairTarget -> rightIndex--

                else -> {
                    triplets.add(
                        listOf(
                            fixedValue, nums[leftIndex], nums[rightIndex]
                        )
                    )

                    leftIndex++
                    rightIndex--

                    while (leftIndex < rightIndex && nums[leftIndex] == nums[leftIndex - 1]) {
                        leftIndex++
                    }

                    while (leftIndex < rightIndex && nums[rightIndex] == nums[rightIndex + 1]) {
                        rightIndex--
                    }
                }
            }
        }
    }
}
