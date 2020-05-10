package com.randomlychosenbytes.kotlincv.attributes

import com.randomlychosenbytes.kotlincv.DistanceUnit

class Height(value: Int, unit: DistanceUnit) : Distance(value, unit) {
    override fun render() = """height="$value${unit.value}""""

    companion object {
        fun fromString(string: String): Distance {
            val unit = findUnit(string)
            return Height(string.replace(unit.value, "").toInt(), unit)
        }
    }
}