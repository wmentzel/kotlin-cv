package com.randomlychosenbytes.kotlincv

import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.tool.xml.XMLWorkerHelper
import com.randomlychosenbytes.kotlincv.attributes.Colspan
import com.randomlychosenbytes.kotlincv.attributes.Width
import com.randomlychosenbytes.kotlincv.attributes.style.BorderSpacing
import com.randomlychosenbytes.kotlincv.attributes.style.FontFamily
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

                body(Style(FontFamily("Courier New"))) {
                    table(Width(100, DistanceUnit.Percent), Style(BorderSpacing(15, DistanceUnit.Px))) {
                        tr {
                            td(Width(30, DistanceUnit.Percent), Style(FontSize(50, DistanceUnit.Px))) { +"CV" }
                            td(Width(70, DistanceUnit.Percent)) {
                                b { +"Willi-Wolfram Mentzel"; br() }
                                +"""
                                Example street 99, 99999 Dresden, Germany
                                Phone No: +49 176 99 99 99 99
                                Email Address: willi@example.com
                                """.split("\n").joinToString(separator = "<br/>") {
                                        it.trim()
                                    }
                                }
                        }
                        tr {
                            td(Colspan(2)) {
                                b { +"Personal Profile" }
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                +"I am a young software professional who is always eager to improve. I have great interest in the latest technologies and languages. I am a quick learner and can adapt fast"
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                b { +"Career Objective" }
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                +"I want to be a team leader and make architectural decisions and give guidance. Still, I’d like to write (backend) code myself."
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                b { +"Work Experience" }
                            }
                        }
                        tr {
                            td { +"01/2020 - Present" }
                            td { b { +"Lead Software Developer at Innospire Group" } }
                        }
                        tr {
                            td { }
                            td {
                                +"""
                                I supervise every step between the first line of code
                                of a Spring Boot backend and Angular frontend and the
                                deployment in a Kubernetes cluster for several of our
                                products."""
                                br(); br()
                                +"""Although I do frontend development too, my main
                                interest and passion lies in backend development.
                                Also, I serve as a mentor for new team members by
                                bringing them up to speed with the technologies we use.
                                I review their code and give them hints on how to
                                improve it."""
                                br(); br()
                                +"""My contribution on StackOverlow helped a lot with that,
                                because I learned to articulate solutions to complex
                                technical problems in a short and concise manner."""
                                br(); br()
                                +"""Tech: Same as in previous position + Spring Security,
                                Redis"""
                            }
                        }
                        tr {
                            td { +"06/2017 - 01/2020" }
                            td { b { +"Full Stack Software Developer at Innospire Group" } }
                        }
                        tr {
                            td { }
                            td {
                                +"""I understand every step between the first line of code
                                of a Spring Boot backend and Angular frontend and the
                                deployment in a Kubernetes cluster for several of our
                                products."""
                                br(); br()
                                +"""As the title suggests I do frontend and backend
                                development. Clean code and a flawless commit history
                                are very important to me."""
                                br(); br()
                                +"""I give guidance to new team members and help them
                                understand our architecture and tech stack."""
                                br(); br()
                                +"""Tech: Kotlin, Spring Boot, Spring Data JPA, MySQL,
                                Angular, HTML, JavaScript, TypeScript, Git, Docker,
                                Kubernetes, Bitbucket Pipelines
                                """
                            }
                        }
                        tr {
                            td { +"02/2017 - 05/2017" }
                            td { b { +"Software Developer (Working Student) at Innospire Group" } }
                        }
                        tr {
                            td { }
                            td {
                                +"""I was working on a CRM system for the financial
                                industry."""
                                br(); br()
                                """Tech: Kotlin, Spring Boot, Spring Data JPA, MySQL,
                                AngularJS, HTML, JavaScript, Git"""
                            }
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