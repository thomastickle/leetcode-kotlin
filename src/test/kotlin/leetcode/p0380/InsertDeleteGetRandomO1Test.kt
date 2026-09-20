package leetcode.p0380

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Assertions.assertFalse
import org.junit.jupiter.api.Assertions.assertTrue
import org.junit.jupiter.api.Test

class InsertDeleteGetRandomO1Test {

    @Test
    fun `executes sequence from example 1`() {
        val randomizedSet = RandomizedSet()

        assertTrue(randomizedSet.insert(1))
        assertFalse(randomizedSet.remove(2))
        assertTrue(randomizedSet.insert(2))

        val randomVal1 = randomizedSet.getRandom()
        assertTrue(randomVal1 == 1 || randomVal1 == 2)

        assertTrue(randomizedSet.remove(1))
        assertFalse(randomizedSet.insert(2))
        assertEquals(2, randomizedSet.getRandom())
    }

    @Test
    fun `duplicate insertions return false and do not add duplicate elements`() {
        val randomizedSet = RandomizedSet()

        assertTrue(randomizedSet.insert(10))
        assertFalse(randomizedSet.insert(10))
        assertTrue(randomizedSet.remove(10))
        assertFalse(randomizedSet.remove(10))
    }

    @Test
    fun `returns false when removing an element from an empty set`() {
        val randomizedSet = RandomizedSet()

        assertFalse(randomizedSet.remove(0))
    }

    @Test
    fun `supports insertion and removal of extreme integer values`() {
        val randomizedSet = RandomizedSet()

        assertTrue(randomizedSet.insert(Int.MIN_VALUE))
        assertTrue(randomizedSet.insert(Int.MAX_VALUE))

        val randomVal = randomizedSet.getRandom()
        assertTrue(randomVal == Int.MIN_VALUE || randomVal == Int.MAX_VALUE)

        assertTrue(randomizedSet.remove(Int.MIN_VALUE))
        assertEquals(Int.MAX_VALUE, randomizedSet.getRandom())
    }

    @Test
    fun `maintains state when removing elements from the middle of the list`() {
        val randomizedSet = RandomizedSet()

        assertTrue(randomizedSet.insert(1))
        assertTrue(randomizedSet.insert(2))
        assertTrue(randomizedSet.insert(3))

        assertTrue(randomizedSet.remove(2))
        val randomVal = randomizedSet.getRandom()
        assertTrue(randomVal == 1 || randomVal == 3)

        assertTrue(randomizedSet.insert(4))
        assertTrue(randomizedSet.remove(3))
        assertTrue(randomizedSet.remove(4))
        assertEquals(1, randomizedSet.getRandom())
    }

    @Test
    fun `consistently returns single existing element across multiple getRandom calls`() {
        val randomizedSet = RandomizedSet()

        assertTrue(randomizedSet.insert(42))

        repeat(10) {
            assertEquals(42, randomizedSet.getRandom())
        }
    }
}
