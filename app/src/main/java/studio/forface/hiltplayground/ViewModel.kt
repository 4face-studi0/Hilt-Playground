package studio.forface.hiltplayground

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData

class GreetingsViewModel @ViewModelInject constructor(
    private val getGreeting: GetGreeting
) : ViewModel() {

    val greeting = liveData {
        emit(getGreeting())
    }
}
