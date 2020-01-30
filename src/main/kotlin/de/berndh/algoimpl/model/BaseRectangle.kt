package de.berndh.algoimpl.model

import de.berndh.algoimpl.exception.Dimension2dException

open class BaseRectangle(var width: Int, var height: Int, var name: String = "") {
    var posX = 0
    var posY = 0

    init {
        if (width <= 0 || height <= 0) {
            throw Dimension2dException(width, height)
        }
    }
}
