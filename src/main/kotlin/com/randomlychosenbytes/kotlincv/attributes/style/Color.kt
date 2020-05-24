package com.randomlychosenbytes.kotlincv.attributes.style

import com.randomlychosenbytes.kotlincv.attributes.ColorFormat

class Color(private val value: ColorFormat) : StyleElement {
    override fun render() = """color: ${value.render()}"""
}