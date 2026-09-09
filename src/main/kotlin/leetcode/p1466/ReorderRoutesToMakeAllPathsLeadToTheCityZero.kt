package leetcode.p1466

/**
 * # 1466. Reorder Routes to Make All Paths Lead to the City Zero
 *
 * There are `n` cities numbered from `0` to `n - 1` and `n - 1` connections between them. The
 * connections form a tree, so there is exactly one path between any two cities. Each connection
 * is currently directed in one direction, and `connections[i] = [aᵢ, bᵢ]` means there is a road
 * directed from city `aᵢ` to city `bᵢ`.
 *
 * The roads must be reordered so that every city can reach city `0` by following directed roads.
 * Reordering a road means reversing its direction, and each road may be reordered at most once.
 * Return the minimum number of roads that must be reordered.
 *
 * Examples:
 * - Input: `n = 6, connections = [[0,1],[1,3],[2,3],[4,0],[4,5]]`. Output: `3`.
 *   Explanation: Reverse the roads from `0` to `1`, from `1` to `3`, and from `4` to `5`.
 * - Input: `n = 5, connections = [[1,0],[1,2],[3,2],[3,4]]`. Output: `2`.
 *   Explanation: Reverse the roads from `1` to `2` and from `3` to `4`.
 * - Input: `n = 3, connections = [[1,0],[2,0]]`. Output: `0`.
 *   Explanation: Every city can already reach city `0`.
 *
 * Constraints:
 * - `2 <= n <= 5 * 10⁴`.
 * - `connections.length == n - 1`.
 * - `connections[i].length == 2`.
 * - `0 <= aᵢ, bᵢ < n`.
 * - `aᵢ != bᵢ`.
 * - All pairs `(aᵢ, bᵢ)` are distinct.
 * - There is exactly one path between any two cities.
 *
 * [LeetCode 1466: Reorder Routes to Make All Paths Lead to the City Zero](https://leetcode.com/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/)
 */
class Solution {
    fun minReorder(n: Int, connections: Array<IntArray>): Int {
        data class Route(
            val city: Int,
            val needsReversal: Boolean
        )

        fun dfs(city: Int, previousCity: Int, neighbors: List<List<Route>>): Int {
            var reversed = 0

            for ((nextCity, needsReversal) in neighbors[city]) {
                if (nextCity != previousCity) {
                    if (needsReversal) {
                        reversed++
                    }

                    reversed += dfs(nextCity, city, neighbors)
                }
            }

            return reversed
        }

        val neighbors = List(n) {
            mutableListOf<Route>()
        }

        for ((from, to) in connections) {
            neighbors[from].add(Route(to, true))
            neighbors[to].add(Route(from, false))
        }

        return dfs(0, -1, neighbors)
    }
}
