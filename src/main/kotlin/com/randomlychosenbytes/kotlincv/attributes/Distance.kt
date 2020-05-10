package com.randomlychosenbytes.kotlincv.attributes

import com.randomlychosenbytes.kotlincv.DistanceUnit

class Distance(
        private val value: Int,
        private val unit: DistanceUnit
) : RenderableElement {

    companion object {
        fun findUnit(string: String) = DistanceUnit.values().firstOrNull {
            string.endsWith(it.value)
        } ?: DistanceUnit.None
    }

    override fun render() = "$value${unit.value}"
}