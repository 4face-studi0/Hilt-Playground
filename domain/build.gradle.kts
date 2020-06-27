import studio.forface.easygradle.dsl.*

plugins {
    id("java-library")
    kotlin("jvm")
}

dependencies {
    implementation(
        `kotlin-jdk8`,

        `dagger`
    )
}
