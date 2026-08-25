package leetcode.p0735

import org.junit.jupiter.api.Assertions.assertArrayEquals
import org.junit.jupiter.api.Test

class AsteroidCollisionTest {
    private val solution = Solution()

    @Test
    fun `larger right-moving asteroid destroys smaller left-moving asteroid for first example`() {
        assertArrayEquals(intArrayOf(5, 10), solution.asteroidCollision(intArrayOf(5, 10, -5)))
    }

    @Test
    fun `equal sized opposite moving asteroids destroy each other for second example`() {
        assertArrayEquals(intArrayOf(), solution.asteroidCollision(intArrayOf(8, -8)))
    }

    @Test
    fun `larger left-moving asteroid destroys intermediate before colliding with larger right-moving asteroid`() {
        assertArrayEquals(intArrayOf(10), solution.asteroidCollision(intArrayOf(10, 2, -5)))
    }

    @Test
    fun `no collisions when asteroids move away from each other`() {
        assertArrayEquals(intArrayOf(-2, -1, 1, 2), solution.asteroidCollision(intArrayOf(-2, -1, 1, 2)))
    }

    @Test
    fun `no collisions when all asteroids move to the left`() {
        assertArrayEquals(intArrayOf(-2, -2, -2), solution.asteroidCollision(intArrayOf(-2, -2, -2)))
    }

    @Test
    fun `no collisions when all asteroids move to the right`() {
        assertArrayEquals(intArrayOf(1, 2, 3), solution.asteroidCollision(intArrayOf(1, 2, 3)))
    }

    @Test
    fun `handles chain collisions where left-moving asteroid destroys multiple smaller right-moving asteroids`() {
        assertArrayEquals(intArrayOf(-10), solution.asteroidCollision(intArrayOf(5, 4, 3, 2, 1, -10)))
    }

    @Test
    fun `handles left-moving asteroid destroyed in first collision and mutual annihilation in second collision`() {
        assertArrayEquals(intArrayOf(-2), solution.asteroidCollision(intArrayOf(-2, 2, -1, -2)))
    }

    @Test
    fun `handles constraint boundary values with equal magnitude`() {
        assertArrayEquals(intArrayOf(), solution.asteroidCollision(intArrayOf(1000, -1000)))
    }
}
