package leetcode.p0841

/**
 * # 841. Keys and Rooms
 *
 * There are `n` rooms labeled from `0` to `n - 1`. All rooms are locked initially except room `0`.
 * To enter a locked room, you need its key.
 *
 * When you visit a room, you may find a set of distinct keys in it. Each key has a number on it
 * that identifies the room it unlocks. You can take all keys with you and use them to unlock other
 * rooms.
 *
 * Return `true` if you can visit every room, or `false` otherwise.
 *
 * Examples:
 * - Input: `rooms = [[1],[2],[3],[]]`. Output: `true`.
 *   Explanation: Starting in room 0, take the key to room 1. Then take the key to room 2 from
 *   room 1, and the key to room 3 from room 2. All rooms can be visited.
 * - Input: `rooms = [[1,3],[3,0,1],[2],[0]]`. Output: `false`.
 *   Explanation: Room 2 can only be reached using its key, but that key is in room 2 itself, so
 *   room 2 can never be visited.
 *
 * Constraints:
 * - `n == rooms.length`.
 * - `2 <= n <= 1000`.
 * - `0 <= rooms[i].length <= 1000`.
 * - `1 <= sum(rooms[i].length) <= 3000`.
 * - `0 <= rooms[i][j] < n`.
 * - All the values of `rooms[i]` are unique.
 *
 * Follow-up: Can you solve the problem using both a depth-first search and a breadth-first search?
 *
 * [LeetCode 841: Keys and Rooms](https://leetcode.com/problems/keys-and-rooms/)
 */
class Solution {
    fun canVisitAllRooms(rooms: List<List<Int>>): Boolean {
        val visitedRooms = BooleanArray(rooms.size)
        var visitedRoomCount = 0

        fun visitRoom(room: Int) {
            if (visitedRooms[room]) {
                return
            }

            visitedRooms[room] = true
            visitedRoomCount++

            for (key in rooms[room]) {
                visitRoom(key)
            }
        }

        visitRoom(0)

        return visitedRoomCount == rooms.size
    }
}
