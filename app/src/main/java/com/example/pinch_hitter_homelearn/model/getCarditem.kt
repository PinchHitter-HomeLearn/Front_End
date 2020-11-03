package com.example.pinch_hitter_homelearn.model

import android.content.Context
import com.example.pinch_hitter_homelearn.R

class getCarditem (val context: Context) {
    val like = "like"
    val unlike = "unlike"


    fun getlikeIcon(type : String) : Int =
        when (type) {
            like -> R.drawable.board_like
            unlike -> R.drawable.board_unlike
            else -> R.drawable.board_unlike
        }
}