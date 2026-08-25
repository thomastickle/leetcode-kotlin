package leetcode.p0735

/**
 * # 735. Asteroid Collision
 *
 * We are given an array `asteroids` of integers representing asteroids in a row.
 * The indices of the asteroid in the array represent their relative position in space.
 *
 * For each asteroid, the absolute value represents its size, and the sign represents its
 * direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
 *
 * Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller
 * one will explode. If both are the same size, both will explode. Two asteroids moving in the same
 * direction will never meet.
 *
 * Examples:
 * - Input: `asteroids = [5,10,-5]`. Output: `[5,10]`.
 *   Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
 * - Input: `asteroids = [8,-8]`. Output: `[]`.
 *   Explanation: The 8 and -8 collide exploding each other.
 * - Input: `asteroids = [10,2,-5]`. Output: `[10]`.
 *   Explanation: The 2 and -5 collide resulting in -5. The 10 and -5 collide resulting in 10.
 *
 * Constraints:
 * - `2 <= asteroids.length <= 10^4`
 * - `-1000 <= asteroids[i] <= 1000`
 * - `asteroids[i] != 0`
 *
 * [LeetCode 735: Asteroid Collision](https://leetcode.com/problems/asteroid-collision/)
 */
class Solution {
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val output = ArrayDeque<Int>()
        for (asteroid in asteroids) {
            var destroyed = false

            while (output.isNotEmpty() && asteroid < 0 && output.last() > 0) {
                val topAsteroid = output.last()
                val collisionSum = topAsteroid + asteroid
                if (collisionSum == 0) {
                    output.removeLast()
                    destroyed = true
                    break
                } else if (collisionSum < 0) {
                    output.removeLast()
                } else {
                    destroyed = true
                    break
                }
            }

            if (!destroyed) {
                output.addLast(asteroid)
            }
        }
        return output.toIntArray()
    }


//    fun asteroidCollision(asteroids: IntArray): IntArray {
//
//        var size = 0
//
//        for (asteroid in asteroids) {
//            var destroyed = false
//
//            while (size > 0 && asteroid < 0 && asteroids[size - 1] > 0) {
//                val collisionSum = asteroids[size - 1] + asteroid
//
//                if (collisionSum == 0) {
//                    size--
//                    destroyed = true
//                    break
//                } else if (collisionSum < 0) {
//                    size--
//                } else {
//                    destroyed = true
//                    break
//                }
//            }
//
//            if (!destroyed) {
//                asteroids[size] = asteroid
//                size++
//            }
//        }
//
//        return asteroids.copyOf(size)
//    }
}
