package com.randomlychosenbytes.kotlincv.attributes

import com.randomlychosenbytes.kotlincv.DistanceUnit
import com.randomlychosenbytes.kotlincv.attributes.Distance.Companion.findUnit
import com.randomlychosenbytes.kotlincv.attributes.table.TdAttributes

class Width(value: Int, unit: DistanceUnit) : Attribute, TdAttributes {

    private val value: Distance = Distance(value, unit)

    override fun render() = """width="${value.render()}""""

    companion object {
        fun fromString(string: String): Width {
            val unit = findUnit(string)
            return Width(string.replace(unit.value, "").toInt(), unit)
        }
    }
}