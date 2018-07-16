package es.elhaso.gradha.bottomsheetbehaviouranimation

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class FragmentActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment)

        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.fl_container, ProblematicFragment(), "TAG")
        fragmentTransaction.commit()
    }
}
