// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version = "1.6.10"
    val nav_version = "2.4.1"

    repositories {
        mavenCentral()
        maven ("https://maven.aliyun.com/repository/public")
        maven ("https://maven.aliyun.com/repository/google")
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:7.1.2")
        classpath (kotlin("gradle-plugin",kotlin_version))
        classpath ("androidx.navigation:navigation-safe-args-gradle-plugin:$nav_version")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter() // Warning: this repository is going to shut down soon
    }
}

tasks {
    val clean by registering(Delete::class) {
        delete(buildDir)
    }
}