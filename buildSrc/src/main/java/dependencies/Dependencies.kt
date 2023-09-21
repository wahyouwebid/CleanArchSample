package dependencies

import versions.Versions

object Dependencies {

    object AndroidLib {
        const val core = "androidx.core:core-ktx:${Versions.core}"
        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val navigationIu = "androidx.navigation:navigation-ui-ktx:${Versions.navigation}"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:${Versions.navigation}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val securityCrypto = "androidx.security:security-crypto:${Versions.securityCrypto}"
    }

    object NetworkingLib {
        const val retrofit2 = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val rxJava = "com.squareup.retrofit2:adapter-rxjava3:${Versions.retrofit}"
        const val converterGson = "com.squareup.retrofit2:converter-gson:${Versions.gsonConverter}"
        const val okhttp = "com.squareup.okhttp3:okhttp:${Versions.okhttp}"
        const val okhttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okhttpInterceptor}"
        const val chucker = "com.github.chuckerteam.chucker:library:${Versions.chucker}"
        const val chuckerNoop = "com.github.chuckerteam.chucker:library-no-op:${Versions.chucker}"

    }

    object DependencyInjectionLib {
        const val hilt = "com.google.dagger:hilt-android:${Versions.dagger}"
        const val hiltCompiler = "com.google.dagger:hilt-android-compiler:${Versions.dagger}"
        const val hiltAndroidCompiler = "androidx.hilt:hilt-compiler:${Versions.hilt}"
    }

    object UiLib {
        const val material = "com.google.android.material:material:${Versions.materialUi}"
        const val pretty = "org.ocpsoft.prettytime:prettytime:${Versions.prettyTime}"
        const val shimmer = "com.facebook.shimmer:shimmer:${Versions.shimmer}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"
        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val photoView = "com.github.chrisbanes:PhotoView:${Versions.photoView}"
    }

    object ReactiveLib {
        const val rxAndroid = "io.reactivex.rxjava3:rxandroid:${Versions.rxAndroid}"
        const val rxJava = "io.reactivex.rxjava3:rxjava:${Versions.rxJava}"
        const val rxBinding = "com.jakewharton.rxbinding3:rxbinding:${Versions.rxBinding}"
    }

    object TestingLib {
        const val robolectric = "org.robolectric:robolectric:${Versions.robolectric}"
        const val mockito = "org.mockito:mockito-core:${Versions.mockito}"
        const val androidJunit = "androidx.test.ext:junit:${Versions.androidJunit}"
        const val espresso = "androidx.test.espresso:espresso-core:${Versions.espresso}"
        const val junit = "junit:junit:${Versions.testJunit}"
    }
}