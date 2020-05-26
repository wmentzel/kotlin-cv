package com.randomlychosenbytes.kotlincv

fun String.toSingleLine(keepNewlines: Boolean = false) = escapeChars()
        .split("\n")
        .joinToString(if (keepNewlines) "${BR()}" else " ") {
            it.trim()
        }

val charsToEscape = mapOf(
        '>' to "&gt;",
        '<' to "&lt;"
)

fun String.escapeChars() = toCharArray().joinToString("") {
    charsToEscape[it] ?: it.toString()
}