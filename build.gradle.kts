import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    kotlin("jvm") version "1.4.31"
}

group = "me.anton"
version = "1.0-SNAPSHOT"

repositories {
    mavenLocal()
    mavenCentral()
}

dependencies {
    testImplementation(kotlin("test-junit5"))
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.6.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.6.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core-jvm:1.5.0-RC-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactive:1.5.0-RC-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-reactor:1.5.0-RC-SNAPSHOT")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-rx3:1.5.0-RC-SNAPSHOT")
    implementation("io.projectreactor:reactor-core:3.4.5")
}

tasks.test {
    useJUnitPlatform()
}

tasks.withType<KotlinCompile>() {
    kotlinOptions.jvmTarget = "11"
}