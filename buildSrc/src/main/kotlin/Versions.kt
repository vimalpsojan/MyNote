import org.gradle.api.JavaVersion

object Versions {

    const val jetbrains_compose = "1.0.0-alpha3"

    const val jvmTarget = "1.8"
    const val kotlinVersion = "1.5.21"
    const val core_ktx = "1.6.0"
    const val app_compat = "1.3.1"
    const val material = "1.4.0"
    const val compose_version = "1.0.2"
    const val accompanist_version = "0.18.0"
    const val navigation_compose = "2.4.0-alpha09"
    const val activity_compose = "1.3.1"
    const val lifecycle_version = "2.3.1"
    const val lifecycle_viewmodel_compose = "1.0.0-alpha07"
    const val hilt_versiom = "2.38.1"
    const val hilt_view_model = "1.0.0"
    const val hilt_navigation_compose = "1.0.0-alpha03"
    const val preference_version = "1.1.1"
    const val ktorVersion = "1.6.3"
    const val kotlinx_serialization_json = "1.3.0"
    const val constraintlayout_compose = "1.0.0-rc01"
    const val koin_version = "3.1.0"

    const val junit = "4.13.2"
    const val test_ext_junit = "1.1.3"
    const val espresso_core = "3.4.0"
}

object Configs{
    const val group = "com.vimal.mynote"
    const val version = "com.vimal.mynote"
}

object AndroidConfig{
    const val compileSdkVersion = 31
    const val minSdkVersion = 21
    const val targetSdkVersion = 31
    val sourceCompatibility = JavaVersion.VERSION_1_8
    val targetCompatibility = JavaVersion.VERSION_1_8
}

object DesktopConfig{
    const val jvmTarget = "11"
}