package com.randomlychosenbytes.kotlincv

import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.tool.xml.XMLWorkerHelper
import java.io.FileOutputStream
import java.nio.charset.Charset


fun main() {
    val result =
            html {
                head {
                    title { +"HTML encoding with Kotlin" }
                }
                body {
                    h1 { +"HTML encoding with Kotlin" }
                    p { +"this format can be used as an alternative markup to HTML" }

                    // an element with attributes and text content
                    a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }

                    // mixed content
                    p {
                        +"This is some"
                        b { +"mixed" }
                        +"text. For more see the"
                        a(href = "http://jetbrains.com/kotlin") { +"Kotlin" }
                        +"project"
                    }
                    p { +"some text" }

                    // content generated from command-line arguments
                    p {
                        +"Command line arguments were:"
                        ul {
                        }
                    }
                }
            }
    println(result)

    val doc = Document(PageSize.A4)
    val writer = PdfWriter.getInstance(doc, FileOutputStream("test.pdf"))

    doc.open()

    val xmlWorkerHelper = XMLWorkerHelper.getInstance()

    xmlWorkerHelper.parseXHtml(
            writer,
            doc,
            result.toString().byteInputStream(),
            Charset.forName("UTF-8")
    );

    doc.close()
}