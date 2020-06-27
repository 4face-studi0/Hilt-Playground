package studio.forface.hiltplayground

import javax.inject.Inject

class GetGreeting @Inject internal constructor(
    private val repository: Repository
) {
    operator fun invoke() = repository.greeting()
}
