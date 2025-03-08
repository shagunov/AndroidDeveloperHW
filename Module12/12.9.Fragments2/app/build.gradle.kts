plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    kotlin("plugin.serialization") version "2.0.21"
    id("com.google.devtools.ksp") version "2.1.0-1.0.29"
    id("androidx.navigation.safeargs.kotlin") version "2.8.8"
    id("com.google.dagger.hilt.android") version "2.55"
}

buildscript {
    repositories{
        google()
    }
    dependencies{
        classpath(libs.androidx.navigation.safe.args.gradle.plugin)
        classpath (libs.hilt.android.gradle.plugin)
    }
}

android {
    namespace = "com.example.fragments2"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.example.fragments2"
        minSdk = 24
        targetSdk = 35
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
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
    buildFeatures {
        viewBinding = true
    }

    ksp {
        arg("dagger.hilt.android.internal.disableAndroidSuperclassValidation", "true")
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
}

ksp {
    arg("dagger.hilt.android.internal.disableAndroidSuperclassValidation", "true")
}

hilt {
    enableAggregatingTask = false
}

dependencies {
    implementation(libs.androidx.room.runtime)

    // If this project uses any Kotlin source, use Kotlin Symbol Processing (KSP)
    // See Add the KSP plugin to your project
    ksp(libs.androidx.room.compiler)

    // optional - Kotlin Extensions and Coroutines support for Room
    implementation(libs.androidx.room.ktx)

    // optional - RxJava2 support for Room
    implementation(libs.androidx.room.rxjava2)

    // optional - RxJava3 support for Room
    implementation(libs.androidx.room.rxjava3)

    // optional - Guava support for Room, including Optional and ListenableFuture
    implementation(libs.androidx.room.guava)

    // optional - Test helpers
    testImplementation(libs.androidx.room.testing)

    // optional - Paging 3 Integration
    implementation(libs.androidx.room.paging)


    implementation(libs.hilt.android)
    ksp(libs.hilt.compiler)
    // Для тестирования (необязательно)
    testImplementation(libs.hilt.android.testing)
    kspAndroidTest(libs.hilt.compiler)
    // recyclerView
    implementation(libs.androidx.recyclerview)
    implementation(libs.androidx.fragment.ktx)
    // navigation
    implementation(libs.androidx.navigation.fragment.ktx)
    implementation(libs.androidx.navigation.ui.ktx)
    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.appcompat)
    implementation(libs.material)
    implementation(libs.androidx.activity)
    implementation(libs.androidx.constraintlayout)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
}