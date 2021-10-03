pluginManagement {
    repositories {
        google()
        gradlePluginPortal()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
    
}
rootProject.name = "MyNote"


include(":android")
include(":desktop")
include(":common")
include(":UIUtils")
include(":Base")
include(":Core")
include(":APIHelper")
include(":Login")
include(":Resources")
