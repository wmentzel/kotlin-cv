package com.randomlychosenbytes.kotlincv.attributes.style

import com.randomlychosenbytes.kotlincv.attributes.Attribute
import com.randomlychosenbytes.kotlincv.attributes.table.TdAttributes

class Style(private vararg val styleElements: StyleElement) : Attribute, TdAttributes {
    override fun render() = """style="${styleElements.joinToString("; ") {
        it.render()
    }}""""
}