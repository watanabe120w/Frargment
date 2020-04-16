package sample.android.example.frargment

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import java.lang.RuntimeException

class ButtonFragment : Fragment() {
    override fun onAttach(context: Context) {
        super.onAttach(context)
        if(context !is OnButtonClickListener)
            throw RuntimeException("リスナーを実装してください")
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.button_fragment,container,false)
        view.findViewById<Button>(R.id.button)
            .setOnClickListener {
                val listener = context as? OnButtonClickListener
                listener?.onButtonClicked()
        }
        return view
    }

    interface  OnButtonClickListener{
        fun onButtonClicked()
    }

}