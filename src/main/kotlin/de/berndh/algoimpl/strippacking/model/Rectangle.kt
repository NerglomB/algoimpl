package de.berndh.algoimpl.strippacking.model

import de.berndh.algoimpl.model.BaseRectangle

class Rectangle(width: Int, height: Int, name: String = "") : BaseRectangle(width, height, name) {
    var placed = false
    var rotated = false

    fun virtualWidth() = if (rotated) height else width

    fun virtualHeight() = if (rotated) width else height
}
