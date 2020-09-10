import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

description = "Kotlin Symbol Processing API"

group = "org.jetbrains.kotlin"
version = "1.4.0"

tasks.withType<KotlinCompile> {
    kotlinOptions.jvmTarget = "1.8"
    kotlinOptions.freeCompilerArgs += "-Xjvm-default=compatibility"
}

plugins {
    kotlin("jvm")
    `maven-publish`
}

publishing {
    publications {
        create<MavenPublication>("default") {
            artifactId = "ksp-api"
            from(components["java"])
        }
        repositories {
            mavenLocal()
        }
    }
}
