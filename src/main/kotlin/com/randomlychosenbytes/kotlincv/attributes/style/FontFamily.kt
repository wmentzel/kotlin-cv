package com.randomlychosenbytes.kotlincv.attributes.style

class FontFamily(private val name: String) : StyleElement {
    override fun render() = """font-family: '$name'"""
}