package de.berndh.algorithms.strippacking.models

import de.berndh.algoimpl.strippacking.model.Rectangle

class Shelf(
    val width: Int,
    val height: Int,
    val posX: Int,
    val posY: Int
) {
    val rectangles: MutableList<Rectangle> = ArrayList()
    var appendAt = 0
}
