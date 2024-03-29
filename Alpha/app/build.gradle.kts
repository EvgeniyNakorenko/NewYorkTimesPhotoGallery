plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("dagger.hilt.android.plugin")
}

android {
    namespace = "com.example.alpha"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.alpha"
        minSdk = 24
        targetSdk = 33
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
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures{
        viewBinding = true
    }

}

dependencies {

    implementation("com.google.android.material:material:1.11.0")
    implementation ("com.airbnb.android:lottie:4.2.1")
    implementation ("com.github.bumptech.glide:glide:4.14.2")
    implementation("androidx.recyclerview:recyclerview:1.3.2")
    implementation("com.google.dagger:hilt-android:2.49")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.6")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.6")
//    annotationProcessor ("com.google.dagger:dagger-compiler:2.41")
    kapt("com.google.dagger:hilt-compiler:2.49")

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    implementation("com.squareup.retrofit2:retrofit:2.9.0")

    implementation("com.google.code.gson:gson:2.9.0")

    implementation("androidx.fragment:fragment-ktx:1.6.2")
//    implementation("com.squareup.retrofit2:converter-moshi:2.4.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.moshi:moshi:1.8.0")
    kapt("com.squareup.moshi:moshi-kotlin-codegen:1.8.0")
    implementation("io.coil-kt:coil:0.13.0")

    implementation("androidx.lifecycle:lifecycle-livedata-ktx:2.6.2")
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.6.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}