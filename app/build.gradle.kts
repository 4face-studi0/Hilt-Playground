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
        applicationId = "com.example.studio.forface.hiltplayground"
        minSdkVersion(23)
        targetSdkVersion(29)
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"

        javaCompileOptions {
            annotationProcessorOptions {
                // To disable checking for the InstallIn annotation in some modules, you need to enable the compiler
                // option in your build.gradle file like this:
                arguments["dagger.hilt.disableModulesHaveInstallInCheck"] = "true"
            }
        }
    }

    buildTypes {
        getByName("release") {
//            minifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions.jvmTarget = JavaVersion.VERSION_1_8.toString()

}

dependencies {
    implementation(
        project(":domain"),

        `kotlin-jdk7`,

        `appcompat`,
        `android-ktx`,
        `fragment`,
        `lifecycle-liveData`,
        `lifecycle-viewModel`,

        `hilt-android`,
        `hilt-androidx-annotations`,
        `hilt-androidx-viewModel`,
        `hilt-androidx-workManager`
    )
    kapt(
        `assistedInject-processor-dagger`,
        `hilt-android-compiler`,
        `hilt-androidx-compiler`
    )
    compileOnly(`assistedInject-annotations-dagger`)

    testImplementation(`hilt-android-testing`)

//    implementation fileTree(dir: "libs", include: ["*.jar"])
//    implementation "org.jetbrains.kotlin:kotlin-stdlib:$kotlin_version"
//    implementation 'androidx.core:core-ktx:1.1.0'
//    implementation 'androidx.appcompat:appcompat:1.1.0'
//    testImplementation 'junit:junit:4.12'
//    androidTestImplementation 'androidx.test.ext:junit:1.1.1'
//    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'

}
