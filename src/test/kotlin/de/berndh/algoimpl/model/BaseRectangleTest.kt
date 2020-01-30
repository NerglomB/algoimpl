package de.berndh.algoimpl.model

import de.berndh.algoimpl.exception.Dimension2dException
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class BaseRectangleTest {
    @Test
    fun `Should create instance correctly`() {
        val baseRect = BaseRectangle(4, 5, "Name")

        assertEquals(4, baseRect.width)
        assertEquals(5, baseRect.height)
        assertEquals("Name", baseRect.name)
    }

    @Test
    fun `Should have default name`() {
        val baseRect = BaseRectangle(4, 5)

        assertEquals(4, baseRect.width)
        assertEquals(5, baseRect.height)
        assertEquals("", baseRect.name)
    }

    @Test
    fun `Should throw exception when width is out of bound`() {
        assertFailsWith(Dimension2dException::class) {
            BaseRectangle(0, 5, "Name")
        }
    }

    @Test
    fun `Should throw exception when height is out of bound`() {
        assertFailsWith(Dimension2dException::class) {
            BaseRectangle(4, 0, "Name")
        }
    }
}
