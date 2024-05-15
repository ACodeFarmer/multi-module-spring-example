plugins {
    base
    `maven-publish`
    jacoco
    kotlin("jvm") version Versions.kotlin
}

val projectGroup: String by project
val baseVersion: String by project
val snapshotVersion: String by project

allprojects {
    group = projectGroup
    repositories {
        mavenCentral()
        google()
    }
}

subprojects {

}

