import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Versions.jetbrains_compose
    id("com.android.library")
}

group = "com.vimal.uiutils"
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
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:${Versions.core_ktx}")
                implementation("androidx.compose.ui:ui-tooling:${Versions.compose_version}")
                implementation("androidx.compose.ui:ui-tooling:${Versions.compose_version}")
                implementation("androidx.constraintlayout:constraintlayout-compose:${Versions.constraintlayout_compose}")
                implementation("com.google.accompanist:accompanist-insets:${Versions.accompanist_version}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
    }
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    sourceSets["main"].manifest.srcFile("src/androidMain/AndroidManifest.xml")
    defaultConfig {
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = AndroidConfig.sourceCompatibility
        targetCompatibility = AndroidConfig.targetCompatibility
    }
    buildFeatures{
        compose = true
    }
    composeOptions{
        kotlinCompilerExtensionVersion = Versions.compose_version
        kotlinCompilerVersion = Versions.kotlinVersion
    }
    packagingOptions{
        resources{
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }
}