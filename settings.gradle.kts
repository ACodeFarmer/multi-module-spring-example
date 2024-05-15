pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
    }
    plugins {
        id("org.gradle.toolchains.foojay-resolver-conventions") version ("0.7.0")
    }
}

rootProject.name = "buildSrc-example"
