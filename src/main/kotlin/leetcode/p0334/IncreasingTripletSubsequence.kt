package leetcode.p0334

class Solution {
  fun increasingTriplet(nums: IntArray): Boolean {
    var first = Int.MAX_VALUE
    var second = Int.MAX_VALUE

    for (num in nums) {
      if (num <= first) {
        first = num
      } else if (num <= second) {
        second = num
      } else {
        return true
      }
    }
    return false
  }
}
