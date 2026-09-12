package leetcode.p0875

/**
 * # 875. Koko Eating Bananas
 *
 * Koko loves to eat bananas. There are `n` piles of bananas, the `i`th pile has `piles[i]` bananas.
 * The guards have gone and will come back in `h` hours.
 *
 * Koko can decide her bananas-per-hour eating speed of `k`. Each hour, she chooses some pile of
 * bananas and eats `k` bananas from that pile. If the pile has less than `k` bananas, she eats all
 * of them instead and will not eat any more bananas during this hour.
 *
 * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
 *
 * Return the minimum integer `k` such that she can eat all the bananas within `h` hours.
 *
 * Examples:
 * - Input: `piles = [3, 6, 7, 11]`, `h = 8`
 *   Output: `4`
 * - Input: `piles = [30, 11, 23, 4, 20]`, `h = 5`
 *   Output: `30`
 * - Input: `piles = [30, 11, 23, 4, 20]`, `h = 6`
 *   Output: `23`
 *
 * Constraints:
 * - `1 <= piles.length <= 10^4`
 * - `piles.length <= h <= 10^9`
 * - `1 <= piles[i] <= 10^9`
 *
 * [LeetCode 875: Koko Eating Bananas](https://leetcode.com/problems/koko-eating-bananas/)
 */
class Solution {
    fun minEatingSpeed(piles: IntArray, h: Int): Int {
        var low = 1L
        var high = piles.max().toLong()

        while (low < high) {
            val speed = low + (high - low) / 2
            val hoursNeeded = piles.sumOf { pile -> (pile - 1) / speed + 1 }
            if (hoursNeeded <= h) {
                high = speed
            } else {
                low = speed + 1
            }
        }

        return high.toInt()
    }
}
