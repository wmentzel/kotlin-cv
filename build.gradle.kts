plugins {
    application
    kotlin("jvm") version "1.3.71"
}

application {
    mainClassName = "com.randomlychosenbytes.kotlincv.MainKt"
}

dependencies {
    compile(kotlin("stdlib"))
    compile("com.itextpdf.tool:xmlworker:5.5.13.1")
    compile("com.itextpdf:itextpdf:5.5.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5")
}

repositories {
    jcenter()
}
