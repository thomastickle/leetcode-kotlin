package leetcode.p2336

import java.util.*

/**
 * # 2336. Smallest Number in Infinite Set
 *
 * You have a set containing all positive integers `[1, 2, 3, 4, 5, ...]`.
 *
 * Implement the `SmallestInfiniteSet` class:
 * - `SmallestInfiniteSet()` initializes the object to contain all positive integers.
 * - `int popSmallest()` removes and returns the smallest integer contained in the set.
 * - `void addBack(int num)` adds the positive integer `num` back into the set if it is not
 *   already present.
 *
 * Example:
 * - Input:
 *   `['SmallestInfiniteSet', 'addBack', 'popSmallest', 'popSmallest', 'popSmallest', 'addBack',
 *   'popSmallest', 'popSmallest', 'popSmallest']`
 *   `[[], [2], [], [], [], [1], [], [], []]`
 * - Output: `[null, null, 1, 2, 3, null, 1, 4, 5]`
 * - Explanation:
 *   ```
 *   SmallestInfiniteSet smallestInfiniteSet = new SmallestInfiniteSet();
 *   smallestInfiniteSet.addBack(2); // 2 is already in the set, so no change is made.
 *   smallestInfiniteSet.popSmallest(); // returns 1, then removes 1 from the set.
 *   smallestInfiniteSet.popSmallest(); // returns 2, then removes 2 from the set.
 *   smallestInfiniteSet.popSmallest(); // returns 3, then removes 3 from the set.
 *   smallestInfiniteSet.addBack(1); // 1 is added back into the set.
 *   smallestInfiniteSet.popSmallest(); // returns 1, then removes 1 from the set.
 *   smallestInfiniteSet.popSmallest(); // returns 4, then removes 4 from the set.
 *   smallestInfiniteSet.popSmallest(); // returns 5, then removes 5 from the set.
 *   ```
 *
 * Constraints:
 * - `1 <= num <= 1000`
 * - At most `1000` calls will be made in total to `popSmallest` and `addBack`.
 *
 * [LeetCode 2336: Smallest Number in Infinite Set](https://leetcode.com/problems/smallest-number-in-infinite-set/)
 */
class SmallestInfiniteSet {

    private var next = 1
    private val queue = PriorityQueue<Int>()
    private val inQueue = mutableSetOf<Int>()


    fun popSmallest(): Int {
        if (queue.isNotEmpty()) {
            val smallest = queue.poll()
            inQueue.remove(smallest)
            return smallest
        }

        return next++
    }

    fun addBack(num: Int) {
        if (num < next && inQueue.add(num)) {
            queue.offer(num)
        }
    }
}