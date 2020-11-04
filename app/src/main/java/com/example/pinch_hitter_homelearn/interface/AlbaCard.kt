package com.example.pinch_hitter_homelearn.`interface`

import android.graphics.drawable.Drawable
import com.google.gson.annotations.SerializedName

data class AlbaCard (
    @SerializedName("alba_condition")
    val alba_condition : String,
    @SerializedName("alba_region")
    val alba_region : String,
    @SerializedName("alba_like")
    val alba_like : Int,
    @SerializedName("alba_title")
    val alba_title : String,
    @SerializedName("alba_date")
    val alba_date : String,
    @SerializedName("alba_time")
    val alba_time : String,
    @SerializedName("alba_money_type")
    val alba_money_type : String,
    @SerializedName("alba_money")
    val alba_money : String
)