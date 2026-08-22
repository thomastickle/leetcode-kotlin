package leetcode.p0392

class Solution {
//    fun isSubsequence(s: String, t: String): Boolean {
//        var i = 0
//        var j = 0
//
//        while (i < s.length && j < t.length) {
//            if (s[i] == t[j]) {
//               i++
//            }
//            j++
//        }
//
//        return i == s.length
//    }

    fun isSubsequence(s: String, t: String): Boolean {
        var i = 0
        for (c in t) {
           if (i == s.length) break

           if (s[i] == c) {
              i++
           }
        }
        return i == s.length
    }
}
