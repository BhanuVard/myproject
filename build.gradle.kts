// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        google()  // Ensure this is present
        mavenCentral()
    }
    dependencies {
        classpath("com.google.gms:google-services:4.3.15") // Updated version
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0") // Use latest version
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.kotlin.android) apply false
}