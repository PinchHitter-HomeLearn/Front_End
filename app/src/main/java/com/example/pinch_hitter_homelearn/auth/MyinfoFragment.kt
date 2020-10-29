package com.example.pinch_hitter_homelearn.auth

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.adapter.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab_button.view.*

class MyinfoFragment : Fragment() {
    override fun onCreateView(
        Inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?

    ) : View? {
        return Inflater.inflate(R.layout.activity_my_info, container, false)
    }
}
