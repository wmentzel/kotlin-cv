package com.randomlychosenbytes.kotlincv

fun String.toSingleLine(keepNewlines: Boolean = false) = split("\n").joinToString(if (keepNewlines) "${BR()}" else " ") {
    it.trim()
}