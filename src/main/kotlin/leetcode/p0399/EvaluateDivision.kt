package leetcode.p0399

/**
 * # 399. Evaluate Division
 *
 * You are given an array of variable pairs `equations` and an array of real numbers `values`.
 * For each index `i`, `equations[i] = [Aᵢ, Bᵢ]` represents the equation `Aᵢ / Bᵢ = values[i]`,
 * where `Aᵢ` and `Bᵢ` are strings representing variables.
 *
 * You are also given an array of queries. For each index `j`, `queries[j] = [Cⱼ, Dⱼ]` asks for
 * the value of `Cⱼ / Dⱼ`. Return an array containing the answers to all queries. If an answer
 * cannot be determined, return `-1.0` for that query.
 *
 * The input is guaranteed to be valid. No division by zero occurs, and the equations do not
 * contain contradictions.
 *
 * Examples:
 * - Input: `equations = [["a","b"],["b","c"]], values = [2.0,3.0],
 *   queries = [["a","c"],["b","a"],["a","e"],["a","a"],["x","x"]]`.
 *   Output: `[6.00000,0.50000,-1.00000,1.00000,-1.00000]`.
 * - Input: `equations = [["a","b"],["b","c"],["bc","cd"]], values = [1.5,2.5,5.0],
 *   queries = [["a","c"],["c","b"],["bc","cd"],["cd","bc"]]`.
 *   Output: `[3.75000,0.40000,5.00000,0.20000]`.
 * - Input: `equations = [["a","b"]], values = [0.5],
 *   queries = [["a","b"],["b","a"],["a","c"],["x","y"]]`.
 *   Output: `[0.50000,2.00000,-1.00000,-1.00000]`.
 *
 * Constraints:
 * - `1 <= equations.length <= 20`.
 * - `equations[i].length == 2`.
 * - `1 <= Aᵢ.length, Bᵢ.length <= 5`.
 * - `values.length == equations.length`.
 * - `0.0 < values[i] <= 20.0`.
 * - `1 <= queries.length <= 20`.
 * - `queries[j].length == 2`.
 * - `1 <= Cⱼ.length, Dⱼ.length <= 5`.
 * - `Aᵢ`, `Bᵢ`, `Cⱼ`, and `Dⱼ` consist of lowercase English letters and digits.
 * - No equation has `Aᵢ == Bᵢ`.
 * - There are no contradictory equations.
 *
 * [LeetCode 399: Evaluate Division](https://leetcode.com/problems/evaluate-division/)
 */
class Solution {
    fun calcEquation(equations: List<List<String>>, values: DoubleArray, queries: List<List<String>>): DoubleArray {
        data class Connection(val destination: String, val weight: Double)

        fun computeQueryHelper(
                paths: HashMap<String, MutableList<Connection>>,
                start: String,
                end: String,
                visited: MutableSet<String>
        ): Double {
            if (start !in paths) return -1.0
            if (start == end) return 1.0
            if (!visited.add(start)) return -1.0

            for ((destination, weight) in paths.getValue(start)) {
                val result = computeQueryHelper(
                    paths,
                    destination,
                    end,
                    visited
                )

                if (result != -1.0) {
                    return weight * result
                }
            }

            return -1.0
        }

        val paths = HashMap<String, MutableList<Connection>>()
        val output = DoubleArray(queries.size)
        for ((i, equation) in equations.withIndex()) {
            val value = values[i]
            val (a, b) = equation
            paths.getOrPut(a) { mutableListOf() }.add(Connection(b, value))
            paths.getOrPut(b) { mutableListOf() }.add(Connection(a, 1.0 / value))
        }

        for ((index, query) in queries.withIndex()) {
            val result = computeQueryHelper(paths,query[0], query[1], mutableSetOf())
            output[index] = result
        }

        return output
    }
}