package com.randomlychosenbytes.kotlincv.attributes

import java.net.URL

class Href(private val url: URL) : Attribute {
    override fun render() = """href="$url""""
}