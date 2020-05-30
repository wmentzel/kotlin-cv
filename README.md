# Motivation

I needed my CV and wanted to be able to track changes via Git. 
So, a binary format or a format not intended to be created and edited by humans (doc, docx) for the source was out of question. My goal was to create such a CV in Kotlin, the output format being a PDF document.

There are several options to write the source of such a markup document - LaTeX, Markdown, (X)HTML etc. In my opinion LaTeX was too powerful and Markdown not sufficient.

There already is a [kotlinx project](https://github.com/Kotlin/kotlinx.html) which supports a fair amount of HTMLs features (if not all!?).

I wanted to do it on my own using [this](https://try.kotlinlang.org/#/Examples/Longer%20examples/HTML%20Builder/HTML%20Builder.kt) as starting point.

There are tons of ways to go about it. My implementation is suited for my own suited for my limited use-case.
