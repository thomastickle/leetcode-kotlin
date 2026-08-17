package leetcode.p1071

class Solution {
    fun gcdOfStrings(str1: String, str2: String): String {
        tailrec fun gcd(a: Int, b: Int): Int {
            return if (b == 0) a else gcd(b, a % b)
        }

        if (str1 + str2 != str2 + str1) {
            return ""
        }

        val length = gcd(str1.length, str2.length)
        return str1.substring(0, length)
    }
}