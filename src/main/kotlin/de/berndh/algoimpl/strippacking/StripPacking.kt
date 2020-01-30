package de.berndh.algoimpl.strippacking

import de.berndh.algoimpl.Helper
import de.berndh.algoimpl.strippacking.model.Rectangle

object StripPacking {
    fun rotateRectangles(rectangles: Collection<Rectangle>) {
        rectangles.forEach {
            if (it.width > it.height) {
                it.rotated = true
            }
        }
    }

    fun sortRectangles(rectangles: Collection<Rectangle>): Collection<Rectangle> =
        rectangles.sortedWith(Helper.compareByDescending(Rectangle::height, Rectangle::width))
}
