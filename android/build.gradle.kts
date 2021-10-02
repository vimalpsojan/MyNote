plugins {
    id("org.jetbrains.compose") version "1.0.0-alpha3"
    id("com.android.application")
    kotlin("android")
}

group = "com.vimal.mynote"
version = "1.0"

repositories {
    jcenter()
}

val compose_version = "1.0.2"
val activity_compose = "1.3.1"
dependencies {
    implementation(project(":common"))
    implementation( "androidx.compose.ui:ui:$compose_version")
    implementation ("androidx.compose.material:material:$compose_version")
    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_version")
    debugImplementation ("androidx.compose.ui:ui-tooling:$compose_version")
    implementation ("androidx.activity:activity-compose:$activity_compose")
}

android {
    compileSdkVersion(31)
    defaultConfig {
        applicationId = "com.vimal.mynote"
        minSdkVersion(21)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
        }
    }
}