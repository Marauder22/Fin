plugins {
    kotlin("jvm") version "1.8.0"
    application
}

group = "com.example"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

dependencies {
    implementation("io.ktor:ktor-client-core:2.2.3")
    implementation("io.ktor:ktor-client-cio:2.2.3")
    implementation("io.ktor:ktor-client-serialization:2.2.3")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.7.0")
}

application {
    mainClass.set("Main")
}

tasks.withType<Jar> {
    manifest {
        attributes["Main-Class"] = "Main"
    }
    duplicatesStrategy = DuplicatesStrategy.EXCLUDE
}

