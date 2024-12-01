plugins {
    application
    id("common")
    id("com.github.johnrengelman.shadow") version "8.1.1"
}

group = "com.expedia.levelup"
version = "1.0-SNAPSHOT"

dependencies {
    implementation(project(":spi"))
    implementation(project(":3rd-party-plugins"))
    implementation("com.github.kotlin-inquirer:kotlin-inquirer:0.1.0")
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
