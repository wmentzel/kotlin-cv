# Motivation

Recently, I needed an up to date CV. I created a new one using Word. I didn't like it since I wanted to be able to track changes via Git. 
So, a binary format or a format not intended to be created and edited by humans (doc, docx) for the source was out of question. 

There are several options to write the source of such a markup document - LaTeX, Markdown, HTML etc. 
In my opinion LaTeX was too powerful and Markdown not sufficient for my use-case. I decided to go with HTML.

Since I love Kotlin and it is really great to create [DSLs (Domain Specific Languages)](https://en.wikipedia.org/wiki/Domain-specific_language), 
I wanted to leverage that and create HTML code in a type-safe way.

There already is a [kotlinx project](https://github.com/Kotlin/kotlinx.html) which supports a fair amount of HTMLs features (if not all!?), but 
to get a better understanding, I wanted to do it on my own using [this](https://try.kotlinlang.org/#/Examples/Longer%20examples/HTML%20Builder/HTML%20Builder.kt) as starting point.

My implementation only covers a tiny subset of HTML. It is tailored to my specific, limited use-case and will be extended if I
need new features for my CV.

So, the CV is written in Kotlin and the output of this program will be an HTML and a PDF file.

# Build and run

Check out the sources, navigate into the source directory and issue:

For Linux:
```
./gradlew run
```

For Windows:
```
gradle.bat run
```

If everything went smoothly, the output should show the locations of the generated files (HTML and PDF).
They should be located in the source directory.