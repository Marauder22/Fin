plugins {
    kotlin("jvm") version "1.9.0"
    kotlin("plugin.serialization") version "1.9.0"
}

repositories {
    mavenCentral()
}

dependencies {
    implementation("com.github.doyaaaaaken:kotlin-csv-jvm:1.3.0")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.5.0")
    implementation("ch.qos.logback:logback-classic:1.2.3")
}



application {
    mainClass.set("MainKt")
}
