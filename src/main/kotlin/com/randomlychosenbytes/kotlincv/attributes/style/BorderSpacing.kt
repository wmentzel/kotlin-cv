package com.randomlychosenbytes.kotlincv.attributes.style

import com.randomlychosenbytes.kotlincv.DistanceUnit
import com.randomlychosenbytes.kotlincv.attributes.Distance

class BorderSpacing(value: Int, unit: DistanceUnit) : StyleElement {
    private val value: Distance = Distance(value, unit)
    override fun render() = """border-spacing: ${value.render()}"""
}