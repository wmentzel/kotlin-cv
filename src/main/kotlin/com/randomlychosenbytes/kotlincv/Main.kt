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
                    title { +"CV Willi Mentzel" }
                }

                body {
                    table(width = Distance(100, DistanceUnit.Percent)) {
                        tr {
                            td(colspan = 2) { +"CV" }
                            td(colspan = 2) {
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
                            td { +"col3" }
                            td { +"col4" }
                            td { +"col5" }
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