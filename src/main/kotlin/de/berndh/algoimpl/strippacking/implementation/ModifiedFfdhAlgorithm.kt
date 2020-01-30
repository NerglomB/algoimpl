package de.berndh.algoimpl.strippacking.implementation

import de.berndh.algoimpl.exception.Dimension2dException
import de.berndh.algoimpl.strippacking.StripPacking
import de.berndh.algoimpl.strippacking.model.Rectangle
import de.berndh.algorithms.strippacking.models.Field
import de.berndh.algorithms.strippacking.models.Shelf

@Throws(Dimension2dException::class)
fun StripPacking.modifiedFfdh(
    width: Int,
    height: Int,
    rectangles: Collection<Rectangle>,
    rotatable: Boolean = false
): Field {
    val field = Field(width, height)
    if (rotatable) {
        rotateRectangles(rectangles)
    }
    var currentShelfHeight = 0

    sortRectangles(rectangles).forEach boxes@{ rect ->
        field.shelves.forEachIndexed { index, shelf ->
            if (shelf.width - shelf.appendAt >= rect.virtualWidth() && rect.virtualHeight() <= shelf.height) {
                placeRectangle(field, shelf, rect, index)

                return@boxes
            } else if (
                rotatable &&
                shelf.width - shelf.appendAt >= rect.virtualHeight() &&
                rect.virtualWidth() <= shelf.height
            ) {
                rect.rotated = !rect.rotated
                placeRectangle(field, shelf, rect, index)

                return@boxes
            }
        }
        if (currentShelfHeight + rect.virtualHeight() <= field.height) {
            currentShelfHeight = addShelf(field, rect, currentShelfHeight)
        } else if (
            rotatable &&
            rect.virtualHeight() > rect.virtualWidth() &&
            currentShelfHeight + rect.virtualWidth() <= field.height
        ) {
            rect.rotated = !rect.rotated
            currentShelfHeight = addShelf(field, rect, currentShelfHeight)
        } else {
            field.remainingRectangles.add(rect)
        }
    }

    return field
}

private fun placeRectangle(field: Field, shelf: Shelf, rectangle: Rectangle, index: Int) {
    rectangle.placed = true
    rectangle.posX = shelf.posX + shelf.appendAt
    rectangle.posY = shelf.posY
    shelf.rectangles.add(rectangle)
    shelf.appendAt += rectangle.virtualWidth()
    if (rectangle.virtualHeight() < shelf.height) {
        field.shelves.add(
            index,
            Shelf(
                rectangle.virtualWidth(),
                shelf.height - rectangle.virtualHeight(),
                rectangle.posX,
                rectangle.posY + rectangle.virtualHeight()
            )
        )
    }
}

private fun addShelf(field: Field, rectangle: Rectangle, currentShelfHeight: Int): Int {
    val newShelf = Shelf(field.width, rectangle.virtualHeight(), 0, currentShelfHeight)
    val newCurrentShelfHeight = currentShelfHeight + rectangle.virtualHeight()
    rectangle.placed = true
    rectangle.posX = newShelf.posX + newShelf.appendAt
    rectangle.posY = newShelf.posY
    newShelf.rectangles.add(rectangle)
    newShelf.appendAt += rectangle.virtualWidth()
    field.shelves.add(newShelf)

    return newCurrentShelfHeight
}
