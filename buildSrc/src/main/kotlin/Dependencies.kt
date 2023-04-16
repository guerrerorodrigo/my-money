object Dependencies {
    object Versions {
        const val androidJUnit = "1.1.5"
        const val dateTime = "0.4.0"
        const val espresso = "3.5.1"
        const val gradleAndroid = "8.0.0"
        const val gradleKotlinPlugin = "1.8.10"
        const val jUnit = "4.13.2"
        const val lottie = "5.2.0"
        const val mockk = "1.13.4"
        const val strikt = "0.34.1"
        const val versionCheck = "0.46.0"
    }

    object Gradle {
        const val androidAppGradle = "com.android.application"
        const val androidLibraryGradle = "com.android.library"
        const val hilt = "com.google.dagger.hilt.android"
        const val kotlinGradle = "org.jetbrains.kotlin.android"
        const val versionCheck = "com.github.ben-manes.versions"
    }

    object Kotlin {
        const val datetime = "org.jetbrains.kotlinx:kotlinx-datetime:${Versions.dateTime}"
    }

    object Lottie {
        const val lottie = "com.airbnb.android:lottie-compose:${Versions.lottie}"
    }

    object Testing {
        const val androidJUnit = "androidx.test.ext:junit:${Versions.androidJUnit}"
        const val composeJUnit = "androidx.compose.ui:ui-test-junit4:${Android.Versions.composeUiTestJunit4}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val jUnit = "junit:junit:${Versions.jUnit}"
        const val mockk = "io.mockk:mockk:${Versions.mockk}"
        const val strikt = "io.strikt:strikt-core:${Versions.strikt}"
    }

    fun isNonStable(version: String): Boolean {
        val stableKeyword = listOf("RELEASE", "FINAL", "GA").any { version.toUpperCase().contains(it) }
        val regex = "^[0-9,.v-]+(-r)?$".toRegex()
        val isStable = stableKeyword || regex.matches(version)
        return isStable.not()
    }
}
