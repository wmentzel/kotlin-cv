package com.randomlychosenbytes.kotlincv.attributes

import com.randomlychosenbytes.kotlincv.DistanceUnit

class Width(value: Int, unit: DistanceUnit) : Distance(value, unit) {
    override fun render() = """width="$value${unit.value}""""

    companion object {
        fun fromString(string: String): Distance {
            val unit = findUnit(string)
            return Width(string.replace(unit.value, "").toInt(), unit)
        }
    }
}