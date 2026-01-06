import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    application
    kotlin("jvm") version "2.0.21"
}

application {
    mainClass.set("com.randomlychosenbytes.kotlincv.MainKt")
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.itextpdf.tool:xmlworker:5.5.13.1")
    implementation("com.itextpdf:itextpdf:5.5.13.1")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.3.5")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-android:1.3.5")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(22))
    }
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_22)
    }
}

repositories {
    mavenCentral()
}
