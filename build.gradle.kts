import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.internal.config.LanguageFeature

plugins {
    kotlin("jvm") version "2.1.0-Beta1"
    kotlin("plugin.serialization") version "2.1.0-Beta1"
}

group = "me.anton"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

configurations {
    compileOnly {
        extendsFrom(configurations.annotationProcessor.get())
    }
}

dependencies {
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.5.0")
    implementation("org.jetbrains.kotlin:kotlin-test-junit5:1.9.25")
    implementation("org.junit.jupiter:junit-jupiter-api:5.10.3")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.8.1")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.2")
    implementation(kotlin("reflect"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.8.1")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.7.3")
    implementation(kotlin("script-runtime"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
//    explicitApi()
//    explicitApiWarning()

    compilerOptions {
        jvmTarget.set(JvmTarget.JVM_17)
    }

    sourceSets.all {
        languageSettings {
            enableLanguageFeature(LanguageFeature.ContextReceivers.name)
            enableLanguageFeature(LanguageFeature.WhenGuards.name)
            version = 2.0
        }
    }

}
