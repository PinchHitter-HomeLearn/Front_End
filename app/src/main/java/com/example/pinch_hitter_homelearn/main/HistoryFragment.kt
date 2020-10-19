package com.example.pinch_hitter_homelearn.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pinch_hitter_homelearn.R
import kotlinx.android.synthetic.main.activity_fragment_tab.view.*

class HistoryFragment : Fragment() {
    var name = ""
    override fun onCreateView(
            Inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ) : View? {
        val view = Inflater.inflate(R.layout.activity_history_fragment, container, false)
        view.textView.text = name

        return view
    }
}