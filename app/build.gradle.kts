import buildtype.AndroidBuildType.debug
import buildtype.AndroidBuildType.release
import config.AndroidConfig
import dependencies.Dependencies
import dependencies.Dependencies.UiLib.shimmer

plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
    id("kotlin-parcelize")
}

@Suppress("UnstableApiUsage")
android {
    compileSdk = AndroidConfig.compileSdk

    defaultConfig {
        namespace = AndroidConfig.appNameSpace
        minSdk = AndroidConfig.minSdk
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
        testInstrumentationRunner = AndroidConfig.testInstrumentRunner
    }

    buildTypes {
        named(debug) {
            isMinifyEnabled = false
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "socketUrl", "\"http://192.168.1.13:3000\"")
            buildConfigField("String", "baseUrl", "\"http://192.168.1.13:3033/\"")
        }

        named(release) {
            isMinifyEnabled = true
            proguardFiles (getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
            buildConfigField("String", "socketUrl", "\"http://192.168.1.13:3000\"")
            buildConfigField("String", "baseUrl", "\"http://192.168.1.13:3033/\"")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_17
        targetCompatibility = JavaVersion.VERSION_17
    }

    buildFeatures {
        buildConfig = true
        viewBinding = true
    }

    testOptions {
        unitTests.isIncludeAndroidResources = true
    }
}

dependencies {
    Dependencies.AndroidLib.apply {
        implementation(core)
        implementation(appCompat)
        implementation(navigationIu)
        implementation(navigationFragment)
        implementation(constraintLayout)
        implementation(securityCrypto)
        implementation(shimmer)
    }

    Dependencies.UiLib.apply {
        implementation(material)
        implementation(pretty)
    }

    Dependencies.NetworkingLib.apply {
        implementation(retrofit2)
        implementation(rxJava)
        implementation(converterGson)
        implementation(okhttp)
        implementation(okhttpInterceptor)
        debugImplementation(chucker)
        releaseImplementation(chuckerNoop)
    }

    Dependencies.DependencyInjectionLib.apply {
        implementation(hilt)
        kapt(hiltCompiler)
        kapt(hiltAndroidCompiler)
    }

    Dependencies.ReactiveLib.apply {
        implementation(rxAndroid)
        implementation(rxJava)
        implementation(rxBinding)
    }

    Dependencies.TestingLib.apply {
        testImplementation(robolectric)
        testImplementation(mockito)
        testImplementation(androidJunit)
        androidTestImplementation(espresso)
        androidTestImplementation(junit)
    }
}
