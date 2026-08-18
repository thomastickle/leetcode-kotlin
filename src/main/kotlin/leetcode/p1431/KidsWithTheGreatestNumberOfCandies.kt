package leetcode.p1431

class Solution {
    fun kidsWithCandies(candies: IntArray, extraCandies: Int): List<Boolean> {
        val largest = candies.max();
        return candies.map { it + extraCandies >= largest }
    }
}
