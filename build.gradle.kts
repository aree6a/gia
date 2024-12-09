plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
    java
}

repositories {
    mavenCentral()
}

application {

    mainClass.set("Main")
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

javafx {
    version = "23.0.1"
    modules = listOf("javafx.controls")
}

dependencies {
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.10.0")
    testRuntimeOnly("org.junit.jupiter:junit-jupiter-engine:5.10.0")
}

tasks.test {
    useJUnitPlatform()
}