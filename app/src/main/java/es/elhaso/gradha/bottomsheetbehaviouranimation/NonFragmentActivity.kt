package es.elhaso.gradha.bottomsheetbehaviouranimation

import android.animation.LayoutTransition
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetBehavior.STATE_EXPANDED
import android.view.View
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.activity_non_fragment.*

class NonFragmentActivity : AppCompatActivity() {

    lateinit var behavior: BottomSheetBehavior<LinearLayout>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_fragment)

        // https://proandroiddev.com/the-little-secret-of-android-animatelayoutchanges-e4caab2fddec
        fLMainContent.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        llBottomSheet.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        behavior = BottomSheetBehavior.from(llBottomSheet)
        behavior.peekHeight = 50
        behavior.state = STATE_EXPANDED
    }

    fun onButtonClick(view: View) {
        onButtonClick(when (view) {
            button2 -> 1
            button3 -> 2
            else -> 0
        })
    }

    private fun onButtonClick(pos: Int) {
        println("Behavior state is ${behavior.state}")
        tvInfo.text = titles[pos]
        tvSubtitle.text = texts[pos]
        tvAnimated.text = texts[pos]
    }
}
