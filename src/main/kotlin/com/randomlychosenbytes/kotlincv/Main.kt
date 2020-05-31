package com.randomlychosenbytes.kotlincv

import com.itextpdf.text.Document
import com.itextpdf.text.PageSize
import com.itextpdf.text.pdf.PdfWriter
import com.itextpdf.tool.xml.XMLWorkerFontProvider
import com.itextpdf.tool.xml.XMLWorkerHelper
import com.randomlychosenbytes.kotlincv.attributes.Colspan
import com.randomlychosenbytes.kotlincv.attributes.DecimalFormat
import com.randomlychosenbytes.kotlincv.attributes.Width
import com.randomlychosenbytes.kotlincv.attributes.style.*
import java.io.File
import java.nio.charset.Charset

fun main() {
    val result =
            html {

                head {
                    title { +"CV Willi Mentzel" }
                }

                body(Style(FontFamily("CourierPrime-Regular"))) {
                    table(Width(100, DistanceUnit.Percent), Style(BorderSpacing(20, DistanceUnit.Px))) {
                        tr {
                            td(Width(30, DistanceUnit.Percent), Style(FontSize(50, DistanceUnit.Px))) { +"CV" }
                            td(Width(70, DistanceUnit.Percent)) {
                                b { +"Willi-Wolfram Mentzel"; br() }
                                +"""Example Street 99, 99999 Dresden, Germany"""; br()
                                +"""Phone No: +49 176 99 99 99 99"""; br()
                                +"""Email Address: willi@example.com"""; br()
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                h3(Style(Margin(bottom = 0, unit = DistanceUnit.Px))) { +"Personal Profile" }
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                +"I am a young software professional who is always eager to improve. I have great interest in the latest technologies and languages. I am a quick learner and can adapt fast"
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                h3(Style(Margin(bottom = 0, unit = DistanceUnit.Px))) { +"Career Objective" }
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                +"I want to be a team leader and make architectural decisions and give guidance. Still, I’d like to write (backend) code myself."
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                h3(Style(Margin(bottom = 0, unit = DistanceUnit.Px))) { +"Work Experience" }
                            }
                        }
                        tr {
                            td { +"06/2020 - Present" }
                            td { b { +"Backend Engineer at Staffbase" } }
                        }
                        tr {
                            td { }
                            td {
                                +"""
                                I develop and improve RESTful backend services.
                                """
                                br(); br()
                                +"""Tech: Kotlin, Spring Boot"""
                            }
                        }
                        tr {
                            td { +"01/2020 - 05/2020" }
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
                                +"""Tech: Kotlin, Spring Boot, Spring Data JPA, MySQL,
                                AngularJS, HTML, JavaScript, Git"""
                            }
                        }
                        tr {
                            td { +"09/2016 - 01/2017" }
                            td { b { +"Full Stack Software Developer (Working Student) at Sherpa.Dresden" } }
                        }
                        tr {
                            td { }
                            td {
                                +"""I developed a web app to manage the cash flow for companies"""
                                br(); br()
                                +"""Tech: Java, Spring MVC, jQuery, HTML, CSS, Git"""
                            }
                        }
                        tr {
                            td { +"10/2013 - 08/2016" }
                            td { b { +"Software Developer (Working Stundent) at FSD Fahrzeugsystemdaten GmbH" } }
                        }
                        tr {
                            td { }
                            td {
                                +"""I helped with the management and conversion of vehicle
                                specific data. Each deliverer (BMW, VW etc.) sends data
                                to us which associates vehicles, which are identified
                                with a VIN (vehicle identification number), with built-
                                in systems. The problem is that the data formats vary
                                greatly. We receive CSV, TXT, XSLX, XSL, ACCDB, MDB
                                etc. files and our job is to evaluate and standardize
                                the contained information."""
                                br(); br()
                                +"""So to summarize, I did: data conversion, data management, create GUIs for data manipulation."""
                                br(); br()
                                +"""Tech: Java, PostgreSQL, Bash, SQLite, MySQL, Git, SVN, PHP, JavaScript, CSS, HTML"""
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                h3(Style(Margin(bottom = 0, unit = DistanceUnit.Px))) { +"Education" }
                            }
                        }
                        tr {
                            td { +"10/2016 - 02/2017" }
                            td {
                                +"""Master of Science, TU Dresden (Media Computer Science), unfinished - because I was
                                offered a full time position"""
                            }
                        }
                        tr {
                            td { +"10/2011 - 05/2016" }
                            td { +"""Bachelor of Science, TU Dresden (Media Computer Science)""" }
                        }
                        tr {
                            td { +"10/2010 - 04/2011" }
                            td { +"""Bachelor of Science, TU Dresden (Mathematics), unfinished""" }
                        }
                        tr {
                            td(Colspan(2)) {
                                b { +"Skills" }
                            }
                        }
                        tr {
                            td { +"Kotlin" }
                            td {
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o o o o o o o""" }
                            }
                        }
                        tr {
                            td { +"Spring Boot" }
                            td {
                                b { +"""o o o o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o""" }
                            }
                        }
                        tr {
                            td { +"Spring Data JPA" }
                            td {
                                b { +"""o o o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o""" }
                            }
                        }
                        tr {
                            td { +"Spring Security" }
                            td {
                                b { +"""o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o""" }
                            }
                        }
                        tr {
                            td { +"Java <= 7" }
                            td {
                                b { +"""o o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o""" }
                            }
                        }
                        tr {
                            td { +"Java > 7" }
                            td {
                                b { +"""o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o o""" }
                            }
                        }
                        tr {
                            td { +"Angular" }
                            td {
                                b { +"""o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o o""" }
                            }
                        }
                        tr {
                            td { +"AngularJS" }
                            td {
                                b { +"""o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o""" }
                            }
                        }
                        tr {
                            td { +"AngularJS" }
                            td {
                                b { +"""o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o o o o""" }
                            }
                        }
                        tr {
                            td { +"TypeScript" }
                            td {
                                b { +"""o o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o""" }
                            }
                        }
                        tr {
                            td { +"Docker" }
                            td {
                                b { +"""o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o o""" }
                            }
                        }
                        tr {
                            td { +"Kubernetes" }
                            td {
                                b { +"""o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o o o""" }
                            }
                        }
                        tr {
                            td { +"MySQL" }
                            td {
                                b { +"""o o o o o o o o""" }
                                span(Style(Color(DecimalFormat(128, 128, 128)))) { +"""o o""" }
                            }
                        }
                        tr {
                            td { +"German" }
                            td {
                                +"""first language"""
                            }
                        }
                        tr {
                            td { +"English" }
                            td {
                                +"""proficient"""
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                h3(Style(Margin(bottom = 0, unit = DistanceUnit.Px))) { +"Interests" }
                            }
                        }
                        tr {
                            td(Colspan(2)) {
                                ul {
                                    li { +"Strength training" }
                                    li { +"Long-distance running" }
                                    li { +"StackOverflow" }
                                }

                            }
                        }
                    }
                }
            }

    val htmlFile = File("cv.html")
    val pdfFile = File("cv.pdf")

    htmlFile.writeText(result.toString())

    val doc = Document(PageSize.A4)
    val writer = PdfWriter.getInstance(doc, pdfFile.outputStream())

    val fontProvider = XMLWorkerFontProvider("Courier_Prime")

    doc.open()

    val xmlWorkerHelper = XMLWorkerHelper.getInstance()

    xmlWorkerHelper.parseXHtml(
            writer,
            doc,
            result.toString().byteInputStream(),
            Charset.forName("UTF-8"),
            fontProvider
    );

    doc.close()

    println("\nPDF file: ${pdfFile.absolutePath}")
    println("HTML file: ${htmlFile.absolutePath}")
}