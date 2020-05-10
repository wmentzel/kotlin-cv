package com.randomlychosenbytes.kotlincv.attributes.style

import com.randomlychosenbytes.kotlincv.DistanceUnit
import com.randomlychosenbytes.kotlincv.attributes.Distance

class FontSize(value: Int, unit: DistanceUnit) : StyleElement {
    private val value: Distance = Distance(value, unit)
    override fun render() = """font-size: ${value.render()}"""
}