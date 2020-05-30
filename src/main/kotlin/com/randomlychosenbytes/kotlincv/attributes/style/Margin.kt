package com.randomlychosenbytes.kotlincv.attributes.style

import com.randomlychosenbytes.kotlincv.DistanceUnit
import com.randomlychosenbytes.kotlincv.attributes.Distance

class Margin(
        private val top: Int = 0,
        private val right: Int = 0,
        private val bottom: Int = 0,
        private val left: Int = 0,
        private val unit: DistanceUnit
) : StyleElement {
    override fun render() = """margin: ${Distance(top, unit).render()} ${Distance(right, unit).render()} ${Distance(bottom, unit).render()} ${Distance(left, unit).render()}"""
}