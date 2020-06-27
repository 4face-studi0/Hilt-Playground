package studio.forface.hiltplayground

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GreetingsActivity: AppCompatActivity() {

    private val greetingsViewModel: GreetingsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContentView())

        greetingsViewModel.greeting.observe(this) {
            textView.text = it
        }
    }

    private lateinit var textView: TextView
    private fun ContentView(): View {
        return TextView(this).also { textView = it }.apply {
            gravity = Gravity.CENTER
        }
    }
}
