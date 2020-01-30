package de.berndh.algoimpl.exception

class Dimension2dException(width: Int, height: Int) : Exception(
    "Width is $width, height is $height, both must be greater than zero."
)
