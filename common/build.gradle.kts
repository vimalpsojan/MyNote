import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Versions.jetbrains_compose
    id("com.android.library")
}

group = "com.vimal.mynote.common"
version = "1.0.0"

kotlin {
    android()
    jvm("desktop") {
        compilations.all {
            kotlinOptions.jvmTarget = DesktopConfig.jvmTarget
        }
        testRuns["test"].executionTask.configure {
            useJUnitPlatform()
        }
    }
    sourceSets {
        val commonMain by getting {
            dependencies {
                api(compose.runtime)
                api(compose.foundation)
                api(compose.material)
                api(project(":UIUtils"))
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.appcompat:appcompat:${Versions.app_compat}")
                implementation("androidx.core:core-ktx:${Versions.core_ktx}")
                implementation("androidx.navigation:navigation-compose:${Versions.navigation_compose}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:${Versions.junit}")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
            }
        }
        val desktopTest by getting
    }
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
    }
    compileOptions {
        sourceCompatibility = AndroidConfig.sourceCompatibility
        targetCompatibility = AndroidConfig.targetCompatibility
    }
}