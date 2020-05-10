package com.randomlychosenbytes.kotlincv.attributes

import com.randomlychosenbytes.kotlincv.DistanceUnit
import com.randomlychosenbytes.kotlincv.attributes.Distance.Companion.findUnit
import com.randomlychosenbytes.kotlincv.attributes.table.TdAttributes

class Height(value: Int, unit: DistanceUnit) : Attribute, TdAttributes {

    private val value: Distance = Distance(value, unit)

    override fun render() = """height="${value.render()}""""

    companion object {
        fun fromString(string: String): Height {
            val unit = findUnit(string)
            return Height(string.replace(unit.value, "").toInt(), unit)
        }
    }
}