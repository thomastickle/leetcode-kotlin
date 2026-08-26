package leetcode.p0649

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test

class Dota2SenateTest {
    private val solution = Solution()

    @Test
    fun `radiant wins for the first example`() {
        assertEquals("Radiant", solution.predictPartyVictory("RD"))
    }

    @Test
    fun `dire wins for the second example`() {
        assertEquals("Dire", solution.predictPartyVictory("RDD"))
    }

    @Test
    fun `radiant wins for single radiant senator`() {
        assertEquals("Radiant", solution.predictPartyVictory("R"))
    }

    @Test
    fun `dire wins for single dire senator`() {
        assertEquals("Dire", solution.predictPartyVictory("D"))
    }

    @Test
    fun `radiant wins when all senators belong to radiant`() {
        assertEquals("Radiant", solution.predictPartyVictory("RRR"))
    }

    @Test
    fun `dire wins when all senators belong to dire`() {
        assertEquals("Dire", solution.predictPartyVictory("DDD"))
    }

    @Test
    fun `dire bans upcoming radiant senators and prevails across rounds`() {
        assertEquals("Dire", solution.predictPartyVictory("DDRRR"))
    }

    @Test
    fun `radiant wins in multi-round voting with alternating blocks`() {
        assertEquals("Radiant", solution.predictPartyVictory("DRRDRD"))
    }

    @Test
    fun `dire wins when starting with dire in simple pair`() {
        assertEquals("Dire", solution.predictPartyVictory("DR"))
    }

    @Test
    fun `radiant overcomes trailing majority through early bans`() {
        assertEquals("Radiant", solution.predictPartyVictory("RRDDD"))
    }
}
