package studio.forface.hiltplayground

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.squareup.inject.assisted.Assisted
import com.squareup.inject.assisted.AssistedInject

class GreetingsViewModel @ViewModelInject constructor(
    private val getGreeting: GetGreeting
) : ViewModel() {

    val greeting = liveData {
        emit(getGreeting())
    }
}

class NamedGreetingsViewModel @AssistedInject constructor(
    private val getGreeting: GetGreeting,
    @Assisted private val username: String
) : ViewModel() {

    val greeting = liveData {
        emit("${getGreeting()} $username")
    }

    @AssistedInject.Factory
    interface AssistedFactory {
        fun create(username: String): NamedGreetingsViewModel
    }
}
