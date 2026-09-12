package leetcode.p2462

import java.util.*

/**
 * # 2462. Total Cost to Hire K Workers
 *
 * You are given a 0-indexed integer array `costs`, where `costs[i]` is the cost of hiring the
 * `i`th worker. You are also given two integers `k` and `candidates`.
 *
 * You want to hire exactly `k` workers according to these rules:
 * - There will be exactly `k` hiring sessions. In each session, exactly one worker is hired.
 * - In each session, choose the worker with the lowest cost from either the first `candidates`
 *   workers or the last `candidates` workers in the current array of workers.
 * - If multiple workers have the same lowest cost, choose the worker with the smallest index.
 * - After a worker is hired, remove that worker from the array.
 * - If fewer than `candidates` workers remain, choose the worker with the lowest cost among all
 *   remaining workers. If several workers have the same cost, choose the one with the smallest
 *   index.
 *
 * Return the total cost of hiring exactly `k` workers.
 *
 * Examples:
 * - Input: `costs = [17,12,10,2,7,2,11,20,8]`, `k = 3`, `candidates = 4`.
 *   Output: `11`.
 *   Explanation: The workers hired have costs `2`, `2`, and `7`.
 * - Input: `costs = [1,2,4,1]`, `k = 3`, `candidates = 3`.
 *   Output: `4`.
 *   Explanation: The total cost of hiring exactly three workers is `4`.
 *
 * Constraints:
 * - `1 <= costs.length <= 10^5`
 * - `1 <= costs[i] <= 10^5`
 * - `1 <= k, candidates <= costs.length`
 *
 * [LeetCode 2462: Total Cost to Hire K Workers](https://leetcode.com/problems/total-cost-to-hire-k-workers/)
 */
class Solution {
    fun totalCost(costs: IntArray, k: Int, candidates: Int): Long {
        val leftQueue = PriorityQueue<Int>()
        val rightQueue = PriorityQueue<Int>()

        var left = 0
        var right = costs.lastIndex


        repeat(candidates) {
            if (left <= right) {
                leftQueue.offer(costs[left++])
            }
        }

        repeat(candidates) {
            if (left <= right) {
                rightQueue.offer(costs[right--])
            }
        }

        var result = 0L
        repeat(k) {
            val takeLeft = rightQueue.isEmpty() || leftQueue.isNotEmpty() && leftQueue.peek() <= rightQueue.peek()

            if (takeLeft) {
                result += leftQueue.poll()
                if (left <= right) {
                    leftQueue.offer(costs[left++])
                }
            } else {
                result += rightQueue.poll()
                if (right >= left) {
                    rightQueue.offer(costs[right--])
                }
            }
        }

        return result
    }
}
