package studio.forface.hiltplayground

import dagger.Binds
import dagger.Module

@Module
abstract class DomainModule {

    @Binds
    internal abstract fun RepositoryImpl.bind() : Repository
}
