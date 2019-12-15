import org.gradle.api.JavaVersion

object Config {
    const val minSdk = 16
    const val compileSdk = 29
    const val targetSdk = 29
    const val buildTools = "29.0.2"
}

object Versions {
    // <editor-fold desc="google">
    const val androidx_core = "1.1.0"
    const val androidx_recyclerview = "1.0.0"
    const val androidx_lifecycle = "2.1.0"
    const val androidx_constraintLayout = "1.1.3"
    const val material = "1.1.0-alpha04"
    // </editor-fold>

    // <editor-fold desc="testing">
    const val junit = "4.12"
    const val androidx_espresso = "3.1.0"
    const val androidx_testing = "1.1.1"
    //</editor-fold>

    // <editor-fold desc="tools">
    const val gradleandroid = "3.5.2"
    const val kotlin = "1.3.60"
    const val gradleversions = "0.27.0"
    // </editor-fold>

    // <editor-fold desc="3d libraries">
    const val dagger = "2.25.2"
    const val rx_java = "2.2.15"
    const val rx_android = "2.1.1"
    const val cicerone = "5.0.0"
    const val mockk = "1.9"
    const val inject = "1"
    // </editor-fold>
}

object Deps {
    const val kotlin_stdlib = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"

    const val androidx_core = "androidx.core:core-ktx:${Versions.androidx_core}"
    const val androidx_appcompat = "androidx.appcompat:appcompat:${Versions.androidx_core}"
    const val androidx_constraintlayout = "androidx.constraintlayout:constraintlayout:${Versions.androidx_constraintLayout}"
    const val androidx_material = "com.google.android.material:material:${Versions.material}"
    const val androidx_lifecycle = "androidx.lifecycle:lifecycle-extensions:${Versions.androidx_lifecycle}"
    const val androidx_lifecycle_streams = "androidx.lifecycle:lifecycle-reactivestreams:${Versions.androidx_lifecycle}"
    const val androidx_recyclerview = "androidx.recyclerview:recyclerview:${Versions.androidx_recyclerview}"

    const val testlib_junit = "junit:junit:${Versions.junit}"
    const val testlib_mockk = "io.mockk:mockk:${Versions.mockk}"

    const val testandroidx_rules = "androidx.test:rules:${Versions.androidx_testing}"
    const val testandroidx_runner = "androidx.test:runner:${Versions.androidx_testing}"
    const val testandroidx_espressocore = "androidx.test.espresso:espresso-core:${Versions.androidx_espresso}"

    const val dagger_lib = "com.google.dagger:dagger:${Versions.dagger}"
    const val dagger_compiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val rx_java = "io.reactivex.rxjava2:rxjava:${Versions.rx_java}"
    const val rx_android = "io.reactivex.rxjava2:rxandroid:${Versions.rx_android}"
    const val cicerone = "ru.terrakok.cicerone:cicerone:${Versions.cicerone}"
    const val java_inject = "javax.inject:javax.inject:${Versions.inject}"

    const val gradle_android = "com.android.tools.build:gradle:${Versions.gradleandroid}"
    const val kotlin_gradle_plugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val tools_gradleversions = "com.github.ben-manes:gradle-versions-plugin:${Versions.gradleversions}"
}
