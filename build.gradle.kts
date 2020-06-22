buildscript {
    initVersions()

    repositories(repos)
    dependencies(classpathDependencies)
}

allprojects {
    repositories(repos)
}

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
