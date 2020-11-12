package com.example.pinch_hitter_homelearn.`interface`

import com.google.gson.JsonObject
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import java.sql.Timestamp


// Get Data Class
data class LoginClass(
//    var msg : String,
//    var token : String
        var id : String,
        var loginId : String,
        var passWord : String,
        var sns : String,
        var name : String,
        var birthDay : String,
        var sex : String,
        var phone: String,
        var branchId : Int,
        var role : JSONObject,
        var profileImage : String,
        var lastLoginDate : Timestamp,
        var createdDate : Timestamp,
        var updatedDate : Timestamp,
        var deletedDate : Timestamp
)

data class SignUpClass(
//        @SerializedName("msg")
        val result : JSONObject
)