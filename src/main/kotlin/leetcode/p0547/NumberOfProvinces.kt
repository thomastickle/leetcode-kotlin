package leetcode.p0547

/**
 * # 547. Number of Provinces
 *
 * There are `n` cities. Some cities are connected directly, while others are not. If city `a` is
 * directly connected to city `b`, and city `b` is directly connected to city `c`, then city `a` is
 * indirectly connected to city `c`.
 *
 * A province is a group of cities that are directly or indirectly connected, with no cities outside
 * the group connected to them.
 *
 * You are given an `n x n` matrix `isConnected`, where `isConnected[i][j]` is `1` when the `i`th city
 * and the `j`th city are directly connected, and `0` otherwise. Return the total number of
 * provinces.
 *
 * Examples:
 * - Input: `isConnected = [[1,1,0],[1,1,0],[0,0,1]]`. Output: `2`.
 *   Explanation: Cities 0 and 1 form one province, and city 2 forms another province.
 * - Input: `isConnected = [[1,0,0],[0,1,0],[0,0,1]]`. Output: `3`.
 *   Explanation: Each city is isolated, so each city forms its own province.
 *
 * Constraints:
 * - `1 <= n <= 200`.
 * - `n == isConnected.length`.
 * - `n == isConnected[i].length`.
 * - `isConnected[i][j]` is either `1` or `0`.
 * - `isConnected[i][i] == 1`.
 * - `isConnected[i][j] == isConnected[j][i]`.
 *
 * Follow-up: Can you solve this problem using both depth-first search and breadth-first search?
 *
 * [LeetCode 547: Number of Provinces](https://leetcode.com/problems/number-of-provinces/)
 */
class Solution {
    fun findCircleNum(isConnected: Array<IntArray>): Int {
        val visitedCities = BooleanArray(isConnected.size)
        var provinces = 0

        fun visitConnection(city: Int) {
            visitedCities[city] = true

            val connections = isConnected[city]

            for (connectedCity in connections.indices) {
                if (connections[connectedCity] == 1 && !visitedCities[connectedCity]) {
                    visitConnection(connectedCity)
                }
            }
        }

        for (city in isConnected.indices) {
            if (!visitedCities[city]) {
                provinces++
                visitConnection(city)
            }
        }

        return provinces
    }
}