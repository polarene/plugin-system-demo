plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.8.0"
}
rootProject.name = "plugin-system-demo"
include("spi", "application", "3rd-party-plugins")
