package studio.forface.hiltplayground

import androidx.activity.ComponentActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelLazy
import androidx.lifecycle.ViewModelProvider
import com.squareup.inject.assisted.dagger2.AssistedModule
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@Module(includes = [DomainModule::class])
@InstallIn(ApplicationComponent::class)
abstract class AppModule

@AssistedModule
@Module(includes = [AssistedInject_ViewModelModule::class])
@InstallIn(ApplicationComponent::class)
abstract class ViewModelModule

inline fun <reified VM : ViewModel> ComponentActivity.assistedViewModel(
    crossinline create: () -> VM
): Lazy<VM> {
    val factoryPromise = {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T {
                @Suppress("UNCHECKED_CAST")
                return create() as T
            }
        }
    }

    return ViewModelLazy(VM::class, { viewModelStore }, factoryPromise)
}
