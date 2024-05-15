object Versions {
    const val kotlin = "1.9.20"
    const val spring_boot = Plugins.Versions.spring_boot
}

object Libs {
    const val spring_boot_dependencies = "org.springframework.boot:spring-boot-dependencies:${Versions.spring_boot}"


    fun springBoot(module: String) = "org.springframework.boot:spring-boot-$module:"
    fun springBootStarter(module: String) = "org.springframework.boot:spring-boot-starter-$module"
}