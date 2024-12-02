plugins {
    kotlin("jvm") version "2.0.20"
    application
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

repositories {
    mavenCentral()
    maven { setUrl("https://jitpack.io") }
}

group = "com.expedia.levelup"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.github.kotlin-inquirer:kotlin-inquirer:0.1.0")
}

kotlin {
    jvmToolchain(21)
}

application {
    mainClass.set("text.ApplicationKt")
}

tasks {
    shadowJar {
        archiveBaseName.set("txt")
        archiveClassifier.set("")
        archiveVersion.set("")
        manifest {
            attributes("Main-Class" to application.mainClass.get())
        }
        mergeServiceFiles()
    }
}
