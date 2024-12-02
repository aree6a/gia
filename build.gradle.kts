plugins {
    application
    id("org.openjfx.javafxplugin") version "0.1.0"
}

repositories {
    mavenCentral()
}

application {

    mainClass.set("Main")
}

javafx {
    version = "23.0.1"
    modules = listOf("javafx.controls")
}