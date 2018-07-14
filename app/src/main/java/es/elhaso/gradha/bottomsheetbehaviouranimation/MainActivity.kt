package es.elhaso.gradha.bottomsheetbehaviouranimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED
import android.view.View
import kotlinx.android.synthetic.main.activity_main.*

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

        BottomSheetBehavior.from(llBottomSheet).let { behavior ->
            behavior.state = STATE_EXPANDED
        }
    }

    fun onButtonClick(view: View) {
        onButtonClick(when (view) {
            button2 -> 1
            button3 -> 2
            else -> 0
        })
    }

    private fun onButtonClick(pos: Int) {
        tvInfo.text = titles[pos]
        tvSubtitle.text = texts[pos]
        tvAnimated.text = texts[pos]
    }
}
