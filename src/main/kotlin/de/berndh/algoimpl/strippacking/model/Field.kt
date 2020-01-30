package de.berndh.algorithms.strippacking.models

import de.berndh.algoimpl.exception.Dimension2dException
import de.berndh.algoimpl.strippacking.model.Rectangle

class Field(
    val width: Int,
    val height: Int
) {
    val shelves: MutableList<Shelf> = ArrayList()
    val remainingRectangles: MutableList<Rectangle> = ArrayList()

    init {
        if (width <= 0 || height <= 0) {
            throw Dimension2dException(width, height)
        }
    }
}
