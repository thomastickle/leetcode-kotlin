package leetcode.p0605

/**
 * # 605. Can Place Flowers
 *
 * A flowerbed is represented by `flowerbed`, where `0` is an empty plot and `1` is a planted
 * plot. Flowers may not occupy adjacent plots. Given the number `n` of new flowers, return `true`
 * if all `n` can be planted without breaking that rule; otherwise, return `false`.
 *
 * Examples:
 * - `flowerbed = [1, 0, 0, 0, 1]`, `n = 1` returns `true`.
 * - `flowerbed = [1, 0, 0, 0, 1]`, `n = 2` returns `false`.
 *
 * Constraints:
 * - `1 <= flowerbed.length <= 2 * 10^4`
 * - Every `flowerbed[i]` is either `0` or `1`.
 * - The initial flowerbed has no adjacent planted plots.
 * - `0 <= n <= flowerbed.length`
 *
 * [LeetCode 605: Can Place Flowers](https://leetcode.com/problems/can-place-flowers/)
 */
class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        if (n == 0) return true

        var remaining = n

        for (i in flowerbed.indices) {
            if (flowerbed[i] != 0) continue

            val leftEmpty = i == 0 || flowerbed[i - 1] == 0
            val rightEmpty = i == flowerbed.size - 1 || flowerbed[i + 1] == 0

            if (leftEmpty && rightEmpty) {
                flowerbed[i] = 1

                if (--remaining == 0) return true
            }
        }

        return false
    }
}
