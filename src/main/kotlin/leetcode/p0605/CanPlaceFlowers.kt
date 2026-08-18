package leetcode.p0605

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
