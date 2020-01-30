package de.berndh.algoimpl

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

class HelperTest {
    @Test
    fun `Should sort correctly`() {
        val list = listOf(
            Pair(1, 2),
            Pair(2, 2),
            Pair(2, 5),
            Pair(-1, -1),
            Pair(7, 8),
            Pair(7, 5),
            Pair(7, 1)
        )

        val listSorted = list.sortedWith(Helper.compareByDescending(Pair<Int, Int>::first, Pair<Int, Int>::second))

        assertEquals(7, listSorted.size)

        assertEquals(7, listSorted[0].first)
        assertEquals(8, listSorted[0].second)

        assertEquals(7, listSorted[1].first)
        assertEquals(5, listSorted[1].second)

        assertEquals(7, listSorted[2].first)
        assertEquals(1, listSorted[2].second)

        assertEquals(2, listSorted[3].first)
        assertEquals(5, listSorted[3].second)

        assertEquals(2, listSorted[4].first)
        assertEquals(2, listSorted[4].second)

        assertEquals(1, listSorted[5].first)
        assertEquals(2, listSorted[5].second)

        assertEquals(-1, listSorted[6].first)
        assertEquals(-1, listSorted[6].second)
    }
}
