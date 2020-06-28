package studio.forface.hiltplayground

import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GreetingsActivity: AppCompatActivity() {

    private val greetingsViewModel: GreetingsViewModel by viewModels()
    @Inject lateinit var namedFactory: NamedGreetingsViewModel.AssistedFactory
    private val namedGreetingsViewModel by assistedViewModel { namedFactory.create("Davide") }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(ContentView())

        greetingsViewModel.greeting.observe(this) {
            textView.text = it
        }

        namedGreetingsViewModel.greeting.observe(this) {
            namedTextView.text = it
        }
    }

    private lateinit var textView: TextView
    private lateinit var namedTextView: TextView
    private fun ContentView(): View {
        return LinearLayout(this).apply {
            textView = TextView(context).also { addView(it) }
            namedTextView = TextView(context).also { addView(it) }

            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
        }
    }
}
