plugins {
    id("org.jetbrains.compose") version "1.0.0-alpha3"
    id("com.android.application")
    kotlin("android")
}

group = "com.vimal.mynote"
version = "1.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":common"))
    implementation( "androidx.compose.ui:ui:${Versions.compose_version}")
    implementation ("androidx.compose.material:material:${Versions.compose_version}")
    implementation ("androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}")
    debugImplementation ("androidx.compose.ui:ui-tooling:${Versions.compose_version}")
    implementation ("androidx.activity:activity-compose:${Versions.activity_compose}")
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