package sample.android.example.frargment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity(),ButtonFragment.OnButtonClickListener {

    override fun onButtonClicked() {
        val fragment = supportFragmentManager.findFragmentByTag(
            "labelFragment") as LabelFragment
        fragment.update()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if(supportFragmentManager.findFragmentByTag("labelFragment") == null){
            supportFragmentManager.beginTransaction()
                .add(R.id.counter,newLabelFragment(0),"labelFragment")
                .commit()
        }
    }

}
