package es.elhaso.gradha.bottomsheetbehaviouranimation

import android.animation.LayoutTransition
import android.os.Bundle
import android.support.design.widget.BottomSheetBehavior
import android.support.design.widget.BottomSheetBehavior.*
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import kotlinx.android.synthetic.main.fragment_problematic.*


class ProblematicFragment : Fragment() {

    lateinit var behavior: BottomSheetBehavior<LinearLayout>

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_problematic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // https://proandroiddev.com/the-little-secret-of-android-animatelayoutchanges-e4caab2fddec
        fLMainContent.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)
        llBottomSheet.layoutTransition.enableTransitionType(LayoutTransition.CHANGING)

        behavior = BottomSheetBehavior.from(llBottomSheet)
        behavior.peekHeight = 100
        tvState.text = getStateText(behavior)

        val listener = View.OnClickListener{
            onButtonClick(it)
            tvState.text = getStateText(behavior)
        }

        button1.setOnClickListener(listener)
        button2.setOnClickListener(listener)
        button3.setOnClickListener(listener)
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

fun getStateText(behavior: BottomSheetBehavior<LinearLayout>): String {
    return when (behavior.state) {
        STATE_EXPANDED -> "Expanded"
        STATE_COLLAPSED -> "Collapsed"
        else -> "Unknown"
    }
}
