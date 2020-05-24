package com.randomlychosenbytes.kotlincv.attributes

class DecimalFormat(
        val r: Int,
        val g: Int,
        val b: Int
) : ColorFormat {
    override fun render() = "rgb($r, $g, $b)"
}