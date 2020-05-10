package com.randomlychosenbytes.kotlincv

import com.randomlychosenbytes.kotlincv.attributes.Attribute
import com.randomlychosenbytes.kotlincv.attributes.Href
import com.randomlychosenbytes.kotlincv.attributes.TdAttributes

/*
* HTML builder as found here:
* https://try.kotlinlang.org/#/Examples/Longer%20examples/HTML%20Builder/HTML%20Builder.kt
*/

@DslMarker
annotation class HtmlTagMarker

@HtmlTagMarker
interface Element {
    fun render(builder: StringBuilder, indent: String)
}

class TextElement(private val text: String) : Element {
    override fun render(builder: StringBuilder, indent: String) {
        builder.append("$indent$text\n")
    }
}

abstract class Tag(private val name: String) : Element {
    val children = arrayListOf<Element>()
    val attributes = mutableSetOf<Attribute>()

    protected fun <T : Element> initTag(tag: T, init: T.() -> Unit): T {
        tag.init()
        children.add(tag)
        return tag
    }

    override fun render(builder: StringBuilder, indent: String) {
        val renderedAttributes = renderAttributes()

        builder.append("$indent<$name${if (renderedAttributes.isEmpty()) "" else " $renderedAttributes"}>\n")
        for (c in children) {
            c.render(builder, "$indent  ")
        }
        builder.append("$indent</$name>\n")
    }

    private fun renderAttributes() = attributes.joinToString(separator = "") { it.render() }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this))
    }
}

class HTML() : TagWithText("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init)
    fun body(init: Body.() -> Unit) = initTag(Body(), init)
}

class TD() : BodyTag("td")

class TR() : Tag("tr") {
    fun td(vararg attributes: TdAttributes, init: TD.() -> Unit) {
        val td = initTag(TD(), init)
        td.attributes += attributes
    }
}

class Table() : Tag("table") {
    fun tr(init: TR.() -> Unit) = initTag(TR(), init)
}

class Head() : TagWithText("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init)
}

class Title() : TagWithText("title")

abstract class BodyTag(name: String) : TagWithText(name) {
    fun b(vararg attributes: Attribute, init: B.() -> Unit) = initTag(B(), init)
    fun p(vararg attributes: Attribute, init: P.() -> Unit) = initTag(P(), init)
    fun h1(vararg attributes: Attribute, init: H1.() -> Unit) = initTag(H1(), init)
    fun ul(vararg attributes: Attribute, init: UL.() -> Unit) = initTag(UL(), init)
    fun a(vararg attributes: Attribute, href: Href, init: A.() -> Unit) {
        val a = initTag(A(), init)
        a.attributes += attributes
    }

    fun table(vararg attributes: Attribute, init: Table.() -> Unit) {
        val table = initTag(Table(), init)
        table.attributes += attributes
    }
}

class Body() : BodyTag("body")
class UL() : BodyTag("ul") {
    fun li(init: LI.() -> Unit) = initTag(LI(), init)
}

class B() : BodyTag("b")
class LI() : BodyTag("li")
class P() : BodyTag("p")
class H1() : BodyTag("h1")

class A() : BodyTag("a")

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}
