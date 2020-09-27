package com.example.pinch_hitter_homelearn.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import com.example.pinch_hitter_homelearn.R
import kotlinx.android.synthetic.main.activity_signup.*

class Find_PW_Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find__p_w_)

        val items = resources.getStringArray(R.array.pw_find_array)

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        pw_find_question_choice.adapter = spinnerAdapter

        pw_find_question_choice.onItemSelectedListener = object: AdapterView.OnItemSelectedListener{
            override fun onNothingSelected(p0: AdapterView<*>?) {
                pw_find_question_choice.setSelection(0)
            }

            override fun onItemSelected(p0: AdapterView<*>?, view: View, position: Int, id: Long) {

                when(position) {
                    0 -> {

                    }
                    1 -> {

                    }
                    3 -> {

                    }
                    4 -> {

                    }
                    5 -> {

                    }
                    else -> {

                    }
                }
            }
        }
    }
}