package com.randomlychosenbytes.kotlincv.attributes

import com.randomlychosenbytes.kotlincv.DistanceUnit

abstract class Distance(
        protected val value: Int,
        protected val unit: DistanceUnit
) : Attribute, TdAttributes {

    companion object {
        fun findUnit(string: String) = DistanceUnit.values().firstOrNull {
            string.endsWith(it.value)
        } ?: DistanceUnit.None
    }
}