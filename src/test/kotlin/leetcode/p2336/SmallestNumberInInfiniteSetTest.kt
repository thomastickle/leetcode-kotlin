package leetcode.p2336

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class SmallestNumberInInfiniteSetTest {
    @Test
    fun `follows the operation sequence from the example`() {
        val smallestInfiniteSet = SmallestInfiniteSet()

        smallestInfiniteSet.addBack(2)
        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(2, smallestInfiniteSet.popSmallest())
        assertEquals(3, smallestInfiniteSet.popSmallest())
        smallestInfiniteSet.addBack(1)
        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(4, smallestInfiniteSet.popSmallest())
        assertEquals(5, smallestInfiniteSet.popSmallest())
    }

    @Test
    fun `starts with one and returns consecutive positive integers`() {
        val smallestInfiniteSet = SmallestInfiniteSet()

        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(2, smallestInfiniteSet.popSmallest())
        assertEquals(3, smallestInfiniteSet.popSmallest())
    }

    @Test
    fun `does not add a number that is already present`() {
        val smallestInfiniteSet = SmallestInfiniteSet()

        smallestInfiniteSet.addBack(1)

        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(2, smallestInfiniteSet.popSmallest())
    }

    @Test
    fun `returns a restored number before larger numbers`() {
        val smallestInfiniteSet = SmallestInfiniteSet()

        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(2, smallestInfiniteSet.popSmallest())
        smallestInfiniteSet.addBack(1)

        assertEquals(1, smallestInfiniteSet.popSmallest())
        assertEquals(3, smallestInfiniteSet.popSmallest())
    }

    @Test
    fun `keeps separate instances independent`() {
        val first = SmallestInfiniteSet()
        val second = SmallestInfiniteSet()

        assertEquals(1, first.popSmallest())
        assertEquals(1, second.popSmallest())
        assertEquals(2, first.popSmallest())
        assertEquals(2, second.popSmallest())
    }
}