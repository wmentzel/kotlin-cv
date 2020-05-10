package com.randomlychosenbytes.kotlincv.attributes

import com.randomlychosenbytes.kotlincv.attributes.table.TdAttributes

class Colspan(private val value: Int) : TdAttributes, Attribute {
    override fun render() = if (value > 1) {
        """colspan="$value""""
    } else {
        ""
    }
}