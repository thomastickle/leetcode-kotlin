package leetcode.p0205

/**
 * # 205. Isomorphic Strings
 *
 * Given strings `s` and `t`, determine whether they are isomorphic. Two strings are isomorphic
 * when the characters in `s` can be replaced to produce `t`. Every occurrence of a character
 * must be replaced consistently while preserving character order. Different characters cannot
 * map to the same character, but a character may map to itself.
 *
 * Examples:
 * - Input: `s = "egg"`, `t = "add"`. Output: `true`. The mappings are `e` to `a` and `g` to `d`.
 * - Input: `s = "f11"`, `t = "b23"`. Output: `false`. The character `1` would need to map to both
 *   `2` and `3`.
 * - Input: `s = "paper"`, `t = "title"`. Output: `true`.
 *
 * Constraints:
 * - `1 <= s.length <= 5 * 10^4`
 * - `t.length == s.length`
 * - `s` and `t` consist of any valid ASCII character.
 *
 * [LeetCode 205: Isomorphic Strings](https://leetcode.com/problems/isomorphic-strings/)
 */
class Solution {
    fun isIsomorphic(s: String, t: String): Boolean {
        val sToTMap = CharArray(128) { Char.MAX_VALUE }
        val tToSMap = CharArray(128) { Char.MAX_VALUE }

        for (i in s.indices) {
            val sChar = s[i]
            val tChar = t[i]
            val sMapValue = sToTMap[sChar.code]
            val tMapValue = tToSMap[tChar.code]
            if (sMapValue == Char.MAX_VALUE && tMapValue == Char.MAX_VALUE) {
                sToTMap[sChar.code] = tChar
                tToSMap[tChar.code] = sChar
            } else if (sMapValue != tChar || tMapValue != sChar) {
                return false
            }
        }
        return true
    }
}
