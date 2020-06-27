package studio.forface.hiltplayground

import javax.inject.Inject

interface Repository {
    fun greeting(): String
}

internal class RepositoryImpl @Inject constructor() : Repository {
    override fun greeting() = "Hello!"
}
