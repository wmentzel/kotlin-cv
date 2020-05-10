package com.randomlychosenbytes.kotlincv

import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.tool.xml.XMLWorkerHelper
import com.randomlychosenbytes.kotlincv.attributes.Width
import com.randomlychosenbytes.kotlincv.attributes.style.FontSize
import com.randomlychosenbytes.kotlincv.attributes.style.Style
import java.io.FileOutputStream
import java.nio.charset.Charset

fun main() {
    val result =
            html {

                head {
                    title { +"CV Willi Mentzel" }
                }

                body {
                    table(Width(100, DistanceUnit.Percent)) {
                        tr {
                            td(Width(30, DistanceUnit.Percent), Style(FontSize(50, DistanceUnit.Px))) { +"CV" }
                            td(Width(70, DistanceUnit.Percent)) {
                                +"""
                                Willi-Wolfram Mentzel
                                Example street 99, 99999 Dresden, Germany
                                Phone No: +49 176 99 99 99 99
                                Email Address: willi@example.com
                                """.split("\n").joinToString(separator = "<br/>") {
                                        it.trim()
                                    }
                                }
                        }
                        tr {
                            td { +"col1" }
                            td { +"col2" }
                        }
                    }
                }
            }
    println(result)

    val doc = Document(PageSize.A4)
    val writer = PdfWriter.getInstance(doc, FileOutputStream("cv.pdf"))

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