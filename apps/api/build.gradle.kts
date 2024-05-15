plugins {
    kotlin("kapt")
    kotlin("plugin.spring")
    id(Plugins.spring_boot)
}

springBoot {
    mainClass.set("com.appscroft.example.api.ApiApplicationKt")
}

dependencies {
    implementation(Libs.springBoot("autoconfigure"))
    implementation(Libs.springBootStarter("web"))
}