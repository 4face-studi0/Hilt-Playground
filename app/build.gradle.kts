import studio.forface.easygradle.dsl.*
import studio.forface.easygradle.dsl.android.*

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(29)
    buildToolsVersion = "29.0.3"

    defaultConfig {
        applicationId = "com.example.hiltplayground"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
//            minifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {
    implementation(
        `kotlin-jdk7`,

        `appcompat`,
        `android-ktx`,
        `lifecycle-viewModel`,

        `hilt-android`,
        `hilt-androidx-annotations`,
        `hilt-androidx-viewModel`,
        `hilt-androidx-workManager`
    )
    kapt(
        `hilt-android-compiler`,
        `hilt-androidx-compiler`
    )

    testImplementation(`hilt-android-testing`)

//    implementation fileTree(dir: "libs", include: ["*.jar"])
//    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
//    implementation 'androidx.core:core-ktx:1.1.0'
//    implementation 'androidx.appcompat:appcompat:1.1.0'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

}
