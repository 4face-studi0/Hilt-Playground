import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.api.artifacts.dsl.RepositoryHandler
import org.gradle.kotlin.dsl.ScriptHandlerScope
import org.gradle.kotlin.dsl.maven
import studio.forface.easygradle.dsl.*
import studio.forface.easygradle.dsl.android.*

val repos: RepositoryHandler.() -> Unit = {
    google()
    jcenter()
    maven(url = "http://dl.bintray.com/kotlin/kotlin-eap")
}

val ScriptHandlerScope.classpathDependencies: DependencyHandler.() -> Unit get() = {
    classpath(`kotlin-gradle-plugin`)
    classpath(`hilt-android-gradle-plugin`)
}
