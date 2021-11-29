import org.jetbrains.kotlin.kapt3.base.Kapt.kapt

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
        useIR = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.0.1"
        kotlinCompilerVersion="1.5.21"
    }


}

dependencies {

    ext{
        set("kotlin_version","1.5.21")
        set("kotlin_coroutines_version","1.5.0")
        set("datastore","1.0.0")
        set("nav_version","2.3.5")
        set("fragment_version","1.3.6")
        set("retrofit_version","2.9.0")
        set("retrofit_version","2.9.0")
        set("compose_version","1.0.1")
    }

    val lifecycle_version = "2.4.0"

    // implementation "org.jetbrains.kotlinx:kotlinx-coroutines-android:$kotlin_coroutines_version"
    implementation ("org.jetbrains.kotlin:kotlin-stdlib-jdk8:${ext["kotlin_version"]}")
    implementation ("androidx.datastore:datastore-preferences:${ext["datastore"]}")
    implementation ("androidx.core:core-ktx:1.3.1")
    // 1.3.0以下 java.lang.IllegalStateException: ViewTreeLifecycleOwner not found
    implementation ("androidx.appcompat:appcompat:1.3.0")
    implementation ("com.google.android.material:material:1.2.1")
    implementation ("androidx.constraintlayout:constraintlayout:2.0.1")
    testImplementation ("junit:junit:4.+")
    androidTestImplementation ("androidx.test.ext:junit:1.1.2")
    androidTestImplementation ("androidx.test.espresso:espresso-core:3.3.0")
    implementation("androidx.navigation:navigation-fragment-ktx:${ext["nav_version"]}")
    implementation("androidx.navigation:navigation-ui-ktx:${ext["nav_version"]}")
    implementation("androidx.fragment:fragment-ktx:${ext["fragment_version"]}")
    implementation ("com.squareup.retrofit2:retrofit:${ext["retrofit_version"]}")
    implementation ("com.squareup.okhttp3:logging-interceptor:4.9.0")
    implementation ("com.squareup.retrofit2:converter-gson:${ext["retrofit_version"]}")
    implementation ("androidx.compose.runtime:runtime:${ext["compose_version"]}")
    implementation ("androidx.compose.ui:ui:${ext["compose_version"]}")
    implementation  ("androidx.compose.material:material:${ext["compose_version"]}")
    implementation ("androidx.compose.ui:ui-tooling-preview:${ext["compose_version"]}")
    implementation ("androidx.activity:activity-compose:1.3.0-alpha06")
    implementation ("androidx.compose.runtime:runtime-livedata:${ext["compose_version"]}")
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






    implementation ("com.squareup.moshi:moshi:1.12.0")
    kapt ("com.squareup.moshi:moshi-kotlin-codegen:1.12.0")

}