rootProject.name = "Setaria"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        mavenCentral()
        gradlePluginPortal()
    }
}

dependencyResolutionManagement {
    repositories {
        google {
            mavenContent {
                includeGroupAndSubgroups("androidx")
                includeGroupAndSubgroups("com.android")
                includeGroupAndSubgroups("com.google")
            }
        }
        maven("https://maven.pkg.jetbrains.space/kotlin/p/wasm/experimental")
        mavenCentral()
    }
}

include(":composeApp")
//
include(":core:global")
include(":core:data")
include(":core:network")
include(":core:resources")
include(":core:routers")
//
include(":shared:orbit-viewmodel")
include(":shared:orbit-compose")
//
include(":feature:index")
include(":feature:login")
include(":feature:computing")
