plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
}

android {
    namespace = "com.example.testsimplepredi"
    compileSdk = 34

    android.buildFeatures.buildConfig = true

    defaultConfig {
        applicationId = "com.example.testsimplepredi"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    val buildConfigStringType = "String"
    val buildConfigFieldBuildType = "BUILD_TYPE"

    buildTypes {
        release {
            buildConfigField(buildConfigStringType, buildConfigFieldBuildType, "\"release\"")
        }
        debug {
            buildConfigField(buildConfigStringType, buildConfigFieldBuildType, "\"debug\"")
        }
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
    buildFeatures {
        viewBinding = true
    }
    buildToolsVersion = "34.0.0"

    val filesToExclude = listOf(
        "META-INF/NOTICE",
        "META-INF/LICENSE",
        "META-INF/LICENSE.md",
        "META-INF/LICENSE-notice.md",
        "META-INF/notice",
        "META-INF/notice.txt",
        "META-INF/license",
        "META-INF/license.txt",
        "/META-INF/{AL2.0,LGPL2.1}",
        "META-INF/licenses/ASM",
        "META-INF/DEPENDENCIES",
    )

    packagingOptions {
        resources {
            excludes.addAll(filesToExclude)
        }
    }

    testOptions.unitTests.isIncludeAndroidResources = true

}

dependencies {

    // TODO need to improve build.gradle + dependencies + use version catalog universally

    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.9.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")
    implementation("androidx.navigation:navigation-fragment-ktx:2.7.2")
    implementation("androidx.navigation:navigation-ui-ktx:2.7.2")
    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    val lifecycle_version = "2.6.2"
    val arch_version = "2.2.0"

    // ViewModel
    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:$lifecycle_version")
    // ViewModel utilities for Compose
    implementation("androidx.lifecycle:lifecycle-viewmodel-compose:$lifecycle_version")
    // LiveData
    implementation("androidx.lifecycle:lifecycle-livedata-ktx:$lifecycle_version")
    // Lifecycles only (without ViewModel or LiveData)
    implementation("androidx.lifecycle:lifecycle-runtime-ktx:$lifecycle_version")
    // Lifecycle utilities for Compose
    implementation("androidx.lifecycle:lifecycle-runtime-compose:$lifecycle_version")

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

    // optional - Test helpers for LiveData
    testImplementation("androidx.arch.core:core-testing:$arch_version")

    // optional - Test helpers for Lifecycle runtime
    testImplementation("androidx.lifecycle:lifecycle-runtime-testing:$lifecycle_version")

    testImplementation(libs.test.robolectric)

    implementation(libs.timber)

    // TODO need to cleanup and not all be API
    api(libs.test.junit4)
    api(libs.test.mockk)
    api(libs.test.androidx.core)
    api(libs.test.androidx.coreKtx)
    api(libs.test.kotlinxCoroutines)

    api(libs.test.kaspresso)
    api(libs.test.kaspresso.compose)
    api(libs.test.androidx.compose.ui)

    api(libs.test.androidx.espressoCore)
    api(libs.test.androidx.coreTesting)
    api(libs.test.androidx.ext)
    api(libs.test.androidx.runner)
    api(libs.test.androidx.rules)

}