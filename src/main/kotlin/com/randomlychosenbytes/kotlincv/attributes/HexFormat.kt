package com.randomlychosenbytes.kotlincv.attributes

class HexFormat(
        val r: String,
        val g: String,
        val b: String
) : ColorFormat {
    override fun render() = "$r$g$b"
}