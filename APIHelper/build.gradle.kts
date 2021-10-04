import org.jetbrains.compose.compose

plugins {
    kotlin("multiplatform")
    id("org.jetbrains.compose") version Versions.jetbrains_compose
    id("org.jetbrains.kotlin.plugin.serialization") version Versions.kotlinVersion
    id("com.android.library")
}

group = "com.vimal.base"
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
                implementation("io.ktor:ktor-client-core:${Versions.ktorVersion}")
                implementation("io.ktor:ktor-client-json:${Versions.ktorVersion}")
                implementation("io.ktor:ktor-client-serialization:${Versions.ktorVersion}")
                implementation("io.ktor:ktor-client-logging:${Versions.ktorVersion}")
                implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx_serialization_json}")
                implementation("io.insert-koin:koin-core:${Versions.koin_version}")
            }
        }
        val commonTest by getting {
            dependencies {
                implementation(kotlin("test"))
            }
        }
        val androidMain by getting {
            dependencies {
                implementation("androidx.core:core-ktx:${Versions.core_ktx}")
                implementation("io.ktor:ktor-client-okhttp:${Versions.ktorVersion}")
            }
        }
        val androidTest by getting {
            dependencies {
                implementation("junit:junit:${Versions.junit}")
                implementation("androidx.test.ext:junit:${Versions.test_ext_junit}")
                implementation("androidx.test.espresso:espresso-core:${Versions.espresso_core}")
            }
        }
        val desktopMain by getting {
            dependencies {
                api(compose.preview)
                implementation("io.ktor:ktor-client-apache:${Versions.ktorVersion}")
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