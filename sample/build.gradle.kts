import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id(BuildPlugins.kotlinJVM)
    application
}

dependencies {
    implementation(Libraries.kotlinStdLib)
}

tasks {
    withType<KotlinCompile>().configureEach {
        kotlinOptions.jvmTarget = Definitions.targetJDK
    }
}

application {
    mainClassName = "io.labs.dotanuki.sample.ApplicationKt"
}