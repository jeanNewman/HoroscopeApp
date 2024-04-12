plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.dagger.hilt.android")
    id("kotlin-kapt")
    id("androidx.navigation.safeargs.kotlin")//que hace safe args? es un plugin que se encarga de generar clases de kotlin que contienen argumentos seguros para la navegacion
}

android {
    namespace = "com.jeandarwinnewmanrios.horoscapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.jeandarwinnewmanrios.horoscapp"
        minSdk = 24
        targetSdk = 33
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            isDebuggable = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )

            resValue("string", "app_name", "HoroscApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
        }

        getByName("debug") {
            isDebuggable = true
            resValue("string", "app_name", "[DEBUG] HoroscApp")
            buildConfigField("String", "BASE_URL", "\"https://newastro.vercel.app/\"")
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
        buildConfig = true
    }
    kotlin {
        jvmToolchain(8)
    }
}

dependencies {

    val navVersion = "2.7.7"
    val camVersion = "1.2.3"
    implementation("androidx.core:core-ktx:1.9.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.11.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    //Navigation Components
    implementation("androidx.navigation:navigation-fragment-ktx:$navVersion")
    implementation("androidx.navigation:navigation-ui-ktx:$navVersion")

    //Dagger Hilt esto es? es una libreria que se encarga de inyectar dependencias en una aplicacion
    implementation("com.google.dagger:hilt-android:2.48")
    kapt("com.google.dagger:hilt-compiler:2.48")

    //retrofit
    implementation("com.squareup.retrofit2:retrofit:2.9.0")
    implementation("com.squareup.retrofit2:converter-gson:2.9.0")
    implementation("com.squareup.okhttp3:logging-interceptor:4.9.1")

    //camera x
    implementation("androidx.camera:camera-camera2:$camVersion")
    implementation("androidx.camera:camera-lifecycle:$camVersion")
    implementation("androidx.camera:camera-view:$camVersion")
    implementation("androidx.camera:camera-core:$camVersion")
    implementation("androidx.camera:camera-extensions:$camVersion")


    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")
}