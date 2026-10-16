package leetcode.p0071

/**
 * # 71. Simplify Path
 *
 * Given the absolute path to a file or directory in a Unix-style file system, which always
 * begins with `/`, return its simplified canonical path.
 *
 * In a Unix-style file system:
 * - A single period `.` represents the current directory.
 * - Two periods `..` represent the parent directory.
 * - Multiple consecutive slashes, such as `//` and `///`, are treated as one slash `/`.
 * - Any sequence of periods that is not exactly `.` or `..`, such as `...` or `....`, is a
 *   valid directory or file name.
 *
 * The simplified canonical path must follow these rules:
 * - It starts with a single slash `/`.
 * - Directories are separated by exactly one slash `/`.
 * - It does not end with a slash `/`, unless it is the root directory.
 * - It does not use single or double periods (`.` and `..`) to denote the current or parent
 *   directories.
 *
 * Examples:
 * - Input: `path = "/home/"`, Output: `"/home"`.
 *   The trailing slash is removed.
 * - Input: `path = "/home//foo/"`, Output: `"/home/foo"`.
 *   Multiple consecutive slashes are replaced by a single slash.
 * - Input: `path = "/home/user/Documents/../Pictures"`, Output: `"/home/user/Pictures"`.
 *   The `..` component moves from `Documents` to its parent directory.
 * - Input: `path = "/../"`, Output: `"/"`.
 *   Going one level up from the root is not possible.
 * - Input: `path = "/.../a/../b/c/../d/./"`, Output: `"/.../b/d"`.
 *   `...` is a valid directory name in this problem.
 *
 * Constraints:
 * - `1 <= path.length <= 3000`
 * - `path` consists of English letters, digits, period `.`, slash `/`, or underscore `_`.
 * - `path` is a valid absolute Unix path.
 *
 * The problem statement does not include a follow-up question.
 *
 * [LeetCode 71: Simplify Path](https://leetcode.com/problems/simplify-path/)
 */
class Solution {
    fun simplifyPath(path: String): String {
        val splitPath = path.split('/')
        val stack = ArrayList<String>()

        for (current in splitPath) {
            when (current) {
                "", "." -> continue
                ".." -> if (stack.isNotEmpty()) stack.removeLast()
                else -> stack.add(current)
            }
        }

        return if (stack.isEmpty()) "/" else {
            val result = StringBuilder()
            for (i in stack) {
                result.append('/')
                result.append(i)
            }
            result.toString()
        }
    }
}