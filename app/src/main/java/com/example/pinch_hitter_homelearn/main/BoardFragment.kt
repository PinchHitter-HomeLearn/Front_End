package com.example.pinch_hitter_homelearn.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.pinch_hitter_homelearn.R

class BoardFragment : Fragment() {
    override fun onCreateView(
        Inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ) : View? {
        return Inflater.inflate(R.layout.activity_board_fragment, container, false)
    }
}