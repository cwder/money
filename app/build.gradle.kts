val kotlin_version = "1.5.21"
val kotlin_coroutines_version = "1.5.0"
val datastore = "1.0.0"
val nav_version = "2.3.5"
val fragment_version = "1.3.6"
val retrofit_version = "2.9.0"

plugins {
    id ("com.android.application")
    kotlin("android")
    id("androidx.navigation.safeargs.kotlin")
    id ("kotlin-kapt")
    id("kotlin-parcelize")

}

android {
    compileSdkVersion (31)
    buildToolsVersion ("30.0.3")

    defaultConfig {
        applicationId  = "com.cwd.money"
        minSdkVersion(21)
        targetSdkVersion(31)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release"){
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

    viewBinding {
        isEnabled = true
    }

    dataBinding {
        isEnabled =  true
    }

    buildFeatures{
        compose = true
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.1.1"
    }


}

dependencies {


    implementation(files("lib/mysql-connector-java-5.1.46.jar"))
    val kotlin_version = "1.5.21"
    val kotlin_coroutines_version = "1.5.0"
    val datastore = "1.0.0"
    val nav_version = "2.3.5"
    val fragment_version = "1.3.6"
    val retrofit_version = "2.9.0"
    val compose_version = "1.1.1"
    val lifecycle_version = "2.4.0"
    val moshi_version = "1.13.0"
    val ktorm_version = "3.2.0"

    // implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_coroutines_version"
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:$kotlin_version")
    implementation ("androidx.datastore:datastore-preferences:$datastore")
    implementation ("androidx.core:core-ktx:1.3.1")
    // 1.3.0以下 java.lang.IllegalStateException: ViewTreeLifecycleOwner not found
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("com.google.android.material:material:1.2.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.1")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")
    implementation("androidx.fragment:fragment-ktx:$fragment_version")
    implementation ("com.squareup.retrofit2:retrofit:$retrofit_version")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:$retrofit_version")
    implementation ("androidx.compose.runtime:runtime:$compose_version")
    implementation ("androidx.compose.ui:ui:$compose_version")
    implementation  ("androidx.compose.material:material:$compose_version")
    implementation ("androidx.compose.ui:ui-tooling-preview:$compose_version")
    implementation ("androidx.compose.ui:ui-tooling:$compose_version")

    implementation ("androidx.activity:activity-compose:1.3.1")
    implementation ("androidx.compose.runtime:runtime-livedata:$compose_version")
    implementation ("androidx.navigation:navigation-compose:2.4.0-alpha08")

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")

    // Saved state module for ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-savedstate:$lifecycle_version")

    // Annotation processor
    kapt("androidx.lifecycle:lifecycle-compiler:$lifecycle_version")
    // alternately - if using Java8, use the following instead of lifecycle-compiler
    implementation("androidx.lifecycle:lifecycle-common-java8:$lifecycle_version")

    // optional - helpers for implementing LifecycleOwner in a Service
    implementation("androidx.lifecycle:lifecycle-service:$lifecycle_version")

    // optional - ProcessLifecycleOwner provides a lifecycle for the whole application process
    implementation("androidx.lifecycle:lifecycle-process:$lifecycle_version")

    // optional - ReactiveStreams support for LiveData
    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:$lifecycle_version")





    implementation ("com.squareup.retrofit2:converter-moshi:$retrofit_version")
    implementation ("com.squareup.moshi:moshi:$moshi_version")
    kapt ("com.squareup.moshi:moshi-kotlin-codegen:$moshi_version")

    implementation ("org.ktorm:ktorm-core:${ktorm_version}")

}