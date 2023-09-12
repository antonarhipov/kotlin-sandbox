import org.jetbrains.kotlin.config.LanguageFeature
import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    kotlin("jvm") version "1.9.20-Beta"
    kotlin("plugin.serialization") version "1.9.20-Beta"
}

group = "me.anton"
version = "1.0-SNAPSHOT"

repositories {
//    mavenLocal()
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
//    implementation("org.projectlombok:lombok")
//    annotationProcessor("org.projectlombok:lombok")
    implementation("org.jetbrains.kotlinx:kotlinx-datetime:0.4.0")
    implementation("org.jetbrains.kotlin:kotlin-test-junit5:1.6.10")
    implementation("org.junit.jupiter:junit-jupiter-api:5.9.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-jdk8:1.6.4")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.9.0")
    implementation("org.jetbrains.kotlin:kotlin-reflect:1.7.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.6.4")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
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
//        languageVersion.set(KotlinVersion.KOTLIN_1_9)
    }

    sourceSets.all {
        languageSettings {
            enableLanguageFeature(LanguageFeature.ContextReceivers.name)
        }
    }

}

//tasks.withType<KotlinCompile> {
//    compilerOptions {
//        freeCompilerArgs.set(listOf("-Xcontext-receivers"))
//        jvmTarget.set(JvmTarget.JVM_17)
//        languageVersion.set(KotlinVersion.KOTLIN_1_9)
//    }
//}

//tasks.withType<KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf(
//            "-Xcontext-receivers",
//            "-Xuse-k2",
//        )
//        languageVersion = "2.0"
//    }
//}

