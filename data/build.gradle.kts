plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.android")
    kotlin("kapt")
    id("com.google.dagger.hilt.android")
}

android {
    namespace = AppConfig.dataPackage
    compileSdk = AppConfig.compileSdk

    defaultConfig {
        minSdk = AppConfig.minSdk
        targetSdk = AppConfig.targetSdk

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }
    kotlinOptions {
        jvmTarget = "17"
    }
}

dependencies {

    implementation(Android.coreKtx)

    implementation(Android.Room.room)
    implementation(Android.Room.roomKtx)
    kapt(Android.Room.roomKapt)

    implementation(Android.Hilt.android)
    kapt(Android.Hilt.androidCompiler)
    kapt(Android.Hilt.compiler)

    testImplementation(Dependencies.Testing.jUnit)

    androidTestImplementation(Dependencies.Testing.androidJUnit)
    androidTestImplementation(Dependencies.Testing.espresso)
}