package leetcode.p0605

class Solution {
    fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
        var remaining = n
        for (i in flowerbed.indices) {
            val leftEmpty = i == 0 || flowerbed[i - 1] == 0
            val rightEmpty = i == flowerbed.lastIndex || flowerbed[i + 1] == 0

            if (flowerbed[i] == 0 && leftEmpty && rightEmpty) {
                flowerbed[i] = 1
                remaining--

                if (remaining == 0) return true
            }
        }

        return remaining <= 0
    }
}
