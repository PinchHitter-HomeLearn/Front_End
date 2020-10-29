package com.example.pinch_hitter_homelearn.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.pinch_hitter_homelearn.auth.MyinfoFragment
import com.example.pinch_hitter_homelearn.main.*

class PageAdapter(fm : FragmentManager) : FragmentStatePagerAdapter(fm){

    override fun getItem(position: Int): Fragment {
        return when(position) {
            0 -> {HomeFragment()}
            1 -> {PositionFragment()}
            2 -> {BoardFragment()}
            3 -> {ChattingFragment()}
            else -> {MyinfoFragment()}
        }
    }

    override fun getCount(): Int {
        return 5
    }
}