plugins {
    alias(libs.plugins.android.application)
    alias(libs.plugins.kotlin.android)
    alias(libs.plugins.kotlin.compose)

    id("com.google.gms.google-services")


    //for dagger Hilt
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")

    //For Parcelizing
    id("kotlin-parcelize")
}

android {
    namespace = "com.amrhishammahmoud.rahhal"
    compileSdk = 35

    defaultConfig {
        applicationId = "com.amrhishammahmoud.rahhal"
        minSdk = 26
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
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    kotlinOptions {
        jvmTarget = "11"
    }
    buildFeatures {
        compose = true
        viewBinding = true
    }
}

dependencies {


    implementation(libs.androidx.core.ktx)
    implementation(libs.androidx.lifecycle.runtime.ktx)
    implementation(libs.androidx.activity.compose)
    implementation(platform(libs.androidx.compose.bom))
    implementation(libs.androidx.ui)
    implementation(libs.androidx.ui.graphics)
    implementation(libs.androidx.ui.tooling.preview)
    implementation(libs.androidx.material3)
    testImplementation(libs.junit)
    androidTestImplementation(libs.androidx.junit)
    androidTestImplementation(libs.androidx.espresso.core)
    androidTestImplementation(platform(libs.androidx.compose.bom))
    androidTestImplementation(libs.androidx.ui.test.junit4)
    debugImplementation(libs.androidx.ui.tooling)
    debugImplementation(libs.androidx.ui.test.manifest)


    //for navigation with compose
    implementation(libs.androidx.navigation.compose)
    implementation (libs.androidx.runtime)

    //for dagger hilt
    implementation(libs.hilt.android)
    kapt(libs.hilt.android.compiler)
    // For Hilt and Jetpack ViewModel integration
    implementation(libs.androidx.hilt.navigation.compose)

    //for firebase
    implementation(libs.firebase.auth)
    implementation(libs.firebase.database)
    implementation(libs.firebase.firestore.ktx)
    implementation(libs.androidx.activity)
    implementation(libs.firebase.ui.auth)
    //for firebase (google)
    implementation(libs.google.firebase.auth.ktx)
    // Import the BoM for the Firebase platform
    implementation(platform(libs.firebase.bom))
    // Add the dependency for the Firebase Authentication library
    implementation(libs.firebase.auth.ktx)

    //for auth google
    // Import the Firebase BoM
    implementation(platform(libs.firebase.bom))

    // TODO: Add the dependencies for Firebase products you want to use
    // When using the BoM, don't specify versions in Firebase dependencies
    implementation(libs.firebase.analytics.ktx)

// Room components
    implementation(libs.androidx.room.runtime)
    //noinspection KaptUsageInsteadOfKsp
    kapt(libs.androidx.room.compiler)
    implementation(libs.androidx.room.ktx)
    androidTestImplementation(libs.androidx.room.testing)

// Serialization (GSON or Kotlinx)
    implementation(libs.gson)
// OR for Kotlinx Serialization
    implementation(libs.kotlinx.serialization.json)


// Kotlin coroutines
    implementation(libs.kotlinx.coroutines.core)
    implementation(libs.kotlinx.coroutines.android)
    implementation(libs.retrofit2.kotlin.coroutines.adapter)


    implementation (libs.androidx.runtime.livedata)

    // Download and parse data
    implementation(libs.moshi)
    implementation(libs.moshi.kotlin)
    implementation(libs.retrofit)
    implementation(libs.converter.moshi)
    implementation(libs.converter.scalars)


    //for coil for pictures
    implementation("io.coil-kt:coil-compose:2.4.0")
}