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
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "0.5.0"
}

val projectNameSlug = "examples"
rootProject.name = "multi-module-springboot-example"

include("domain")
includeModules("apps", withBasePath = false)
includeModules("infrastructures", withProjectName = false, withBasePath = false)

fun includeModules(basePath: String, withProjectName: Boolean = true, withBasePath: Boolean = true) {
    files("$rootDir/$basePath").files
        .filter { it.isDirectory }
        .forEach { moduleDir ->
            moduleDir.listFiles()
                ?.filter { it.isDirectory }
                ?.forEach { dir ->
                    val path = basePath.replace("/","-")
                    val projectName = when {
                        !withProjectName && !withBasePath   -> dir.name
                        withProjectName && !withBasePath    -> projectNameSlug + "-" + dir.name
                        withProjectName                     -> projectNameSlug + "-" + path + "-" + dir.name
                        else                                -> path + "-" + dir.name
                    }
                    include(projectName)
                    project(":$projectName").projectDir = dir
                }
        }
}
