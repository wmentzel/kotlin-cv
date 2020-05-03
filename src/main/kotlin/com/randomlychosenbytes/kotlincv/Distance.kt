package com.randomlychosenbytes.kotlincv

class Distance(
        private val value: Int,
        private val unit: DistanceUnit
) {

    fun render() = "$value${unit.value}"

    companion object {
        fun fromString(string: String): Distance {
            val unit = string.findUnit()
            return Distance(string.replace(unit.value, "").toInt(), unit)
        }

        private fun String.findUnit() = DistanceUnit.values().firstOrNull {
            this.endsWith(it.value)
        } ?: DistanceUnit.None
    }
}