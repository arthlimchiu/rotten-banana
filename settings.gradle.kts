pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}
rootProject.name = "RottenBanana"
include(":app")
include(":core:model")
include(":core:network")
include(":core:common")
include(":core:database")
include(":core:data")
include(":core:work")
