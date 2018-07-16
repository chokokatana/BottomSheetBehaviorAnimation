package es.elhaso.gradha.bottomsheetbehaviouranimation

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View

val titles = arrayOf(
    "This is the first title",
    "The second title is a little bit longer and doesn't fit a single line",
    "Nothing to say"
)

val texts = arrayOf(
    "A sweet and short description",
    "A more long description with details about not very interesting stuff to waste some time",
    "I lied when I said I had nothing to say, I'm really liking this so far and wish to continue"
)

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onStartNonFragmentActivity(view: View) {
        startActivity(Intent(this, NonFragmentActivity::class.java))
    }

    fun onStartFragmentActivity(view: View) {
        startActivity(Intent(this, FragmentActivity::class.java))
    }
}
