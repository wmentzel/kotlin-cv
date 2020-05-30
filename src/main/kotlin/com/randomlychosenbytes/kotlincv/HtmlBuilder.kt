package com.randomlychosenbytes.kotlincv

import com.randomlychosenbytes.kotlincv.attributes.Attribute
import com.randomlychosenbytes.kotlincv.attributes.Href
import com.randomlychosenbytes.kotlincv.attributes.RenderableElement
import com.randomlychosenbytes.kotlincv.attributes.table.TdAttributes

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

    protected fun <T : Tag> initTag(tag: T, vararg attributes: Attribute, init: T.() -> Unit): T {
        tag.init()
        tag.attributes += attributes
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

    private fun renderAttributes() = attributes.joinToString(separator = " ") { it.render() }

    override fun toString(): String {
        val builder = StringBuilder()
        render(builder, "")
        return builder.toString()
    }
}

abstract class TagWithText(name: String) : Tag(name) {
    operator fun String.unaryPlus() {
        children.add(TextElement(this.toSingleLine()))
    }

    fun br() {
        children.add(TextElement(BR().render()))
    }
}

class HTML() : TagWithText("html") {
    fun head(init: Head.() -> Unit) = initTag(Head(), init = init)
    fun body(vararg attributes: Attribute, init: Body.() -> Unit) = initTag(Body(), *attributes, init = init)
}

class Span() : BodyTag("span")

class TD() : BodyTag("td")

class TR() : Tag("tr") {
    fun td(vararg attributes: TdAttributes, init: TD.() -> Unit) = initTag(TD(), *attributes, init = init)
}

class Table() : Tag("table") {
    fun tr(vararg attributes: Attribute, init: TR.() -> Unit) = initTag(TR(), *attributes, init = init)
}

class Head() : TagWithText("head") {
    fun title(init: Title.() -> Unit) = initTag(Title(), init = init)
}

class Title() : TagWithText("title")

abstract class BodyTag(name: String) : TagWithText(name) {
    fun b(vararg attributes: Attribute, init: B.() -> Unit) = initTag(B(), *attributes, init = init)

    fun p(vararg attributes: Attribute, init: P.() -> Unit) = initTag(P(), *attributes, init = init)

    fun span(vararg attributes: Attribute, init: Span.() -> Unit) = initTag(Span(), *attributes, init = init)

    fun h1(vararg attributes: Attribute, init: H1.() -> Unit) = initTag(H1(), *attributes, init = init)

    fun h2(vararg attributes: Attribute, init: H2.() -> Unit) = initTag(H2(), *attributes, init = init)

    fun h3(vararg attributes: Attribute, init: H3.() -> Unit) = initTag(H3(), *attributes, init = init)

    fun h4(vararg attributes: Attribute, init: H4.() -> Unit) = initTag(H4(), *attributes, init = init)

    fun ul(vararg attributes: Attribute, init: UL.() -> Unit) = initTag(UL(), *attributes, init = init)

    fun a(vararg attributes: Attribute, href: Href, init: A.() -> Unit) = initTag(A(), *attributes, init = init)

    fun table(vararg attributes: Attribute, init: Table.() -> Unit) = initTag(Table(), *attributes, init = init)
}

class Body() : BodyTag("body")
class UL() : BodyTag("ul") {
    fun li(vararg attributes: Attribute, init: LI.() -> Unit) = initTag(LI(), *attributes, init = init)
}

class B() : BodyTag("b")
class LI() : BodyTag("li")
class P() : BodyTag("p")
class H1() : BodyTag("h1")
class H2() : BodyTag("h2")
class H3() : BodyTag("h3")
class H4() : BodyTag("h4")

class A() : BodyTag("a")

class BR() : RenderableElement {
    override fun toString() = render()
    override fun render() = "<br/>"
}

fun html(init: HTML.() -> Unit): HTML {
    val html = HTML()
    html.init()
    return html
}
