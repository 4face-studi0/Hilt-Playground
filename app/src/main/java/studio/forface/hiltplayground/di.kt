package studio.forface.hiltplayground

import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [DomainModule::class])
@InstallIn(ApplicationComponent::class)
abstract class AppModule
