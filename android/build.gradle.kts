plugins {
    id("org.jetbrains.compose") version Versions.jetbrains_compose
    id("com.android.application")
    kotlin("android")
}

group = "com.vimal.mynote"
version = "1.0.0"

dependencies {
    implementation(project(":common"))
    implementation("androidx.core:core-ktx:${Versions.core_ktx}")
    implementation("androidx.appcompat:appcompat:${Versions.app_compat}")
//    implementation("com.google.android.material:material:${Versions.material}")
//
//    implementation("androidx.compose.ui:ui:${Versions.compose_version}")
//    implementation("androidx.compose.material:material:${Versions.compose_version}")
//    implementation("androidx.compose.ui:ui-tooling-preview:${Versions.compose_version}")
//    debugImplementation("androidx.compose.ui:ui-tooling:${Versions.compose_version}")
    implementation("androidx.activity:activity-compose:${Versions.activity_compose}")
//    implementation("com.google.accompanist:accompanist-insets:${Versions.accompanist_version}")
//    implementation("com.google.accompanist:accompanist-systemuicontroller:${Versions.accompanist_version}")
//    implementation("androidx.navigation:navigation-compose:${Versions.navigation_compose}")
//    implementation("io.insert-koin:koin-androidx-compose:${Versions.koin_version}")
//    implementation("io.ktor:ktor-client-okhttp:${Versions.ktorVersion}")
//    implementation("io.ktor:ktor-client-json:${Versions.ktorVersion}")
//    implementation("io.ktor:ktor-client-serialization-jvm:${Versions.ktorVersion}")
//    implementation("io.ktor:ktor-client-logging-jvm:${Versions.ktorVersion}")
//    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:${Versions.kotlinx_serialization_json}")
//    testImplementation("junit:junit:${Versions.junit}")
//    androidTestImplementation("androidx.test.ext:junit:${Versions.test_ext_junit}")
//    androidTestImplementation("androidx.test.espresso:espresso-core:${Versions.espresso_core}")
//    androidTestImplementation("androidx.compose.ui:ui-test-junit4:${Versions.compose_version}")
//    // Koin Test for Kotlin Multiplatform
//    testImplementation("io.insert-koin:koin-test:${Versions.koin_version}")
}

android {
    compileSdkVersion(AndroidConfig.compileSdkVersion)
    defaultConfig {
        applicationId = "com.vimal.mynote"
        minSdkVersion(AndroidConfig.minSdkVersion)
        targetSdkVersion(AndroidConfig.targetSdkVersion)
        versionCode = 1
        versionName = "1.0"
    }
    compileOptions {
        sourceCompatibility = AndroidConfig.sourceCompatibility
        targetCompatibility = AndroidConfig.targetCompatibility
    }
    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"),"proguard-rules.pro")
        }
    }
    buildFeatures {
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