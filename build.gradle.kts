plugins {
//    kotlin("jvm") version "1.7.21"
    kotlin("jvm") version "1.8.20-RC"
}

group = "me.anton"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
//        vendor.set(JvmVendorSpec.BELLSOFT)
    }
//    targetCompatibility = JavaVersion.VERSION_17
//    sourceCompatibility = JavaVersion.VERSION_17
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
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-rx3:1.6.4")
//    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.6.4")
//    implementation("io.projectreactor:reactor-core:3.4.22")
//    implementation("io.projectreactor:reactor-test:3.4.22")

    implementation(kotlin("script-runtime"))
}

tasks.test {
    useJUnitPlatform()
}

kotlin {
    sourceSets.all {
        languageSettings {
            languageVersion = "2.0"
        }
    }
}


tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompilationTask<*>>()
    .configureEach {
        compilerOptions {
            freeCompilerArgs.set(
                listOf(
                    "-Xcontext-receivers",
                    "-Xuse-k2",
                    )
            )
            languageVersion.set(org.jetbrains.kotlin.gradle.dsl.KotlinVersion.KOTLIN_2_0)
            // how to set jvmTarget?
        }

    }

// Deprecated
//tasks.withType<org.jetbrains.kotlin.gradle.tasks.KotlinCompile> {
//    kotlinOptions {
//        freeCompilerArgs = listOf(
//            "-Xcontext-receivers",
//            "-Xuse-k2",
//        )
//        jvmTarget = "17"
//        languageVersion = "2.0"
//    }
//}



