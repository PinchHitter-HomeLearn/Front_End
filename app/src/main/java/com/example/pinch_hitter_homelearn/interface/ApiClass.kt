package com.example.pinch_hitter_homelearn.`interface`

import com.google.gson.JsonObject
import org.json.JSONObject


// Get Data Class
data class LoginClass(
    var msg : String,
    var token : String
)

data class SignUpClass(
    var id : String,
    var loginId : String,
    var passWord : String,
    var sns : String,
    var name : String,
    var birthDay : String,
    var sex : String,
    var phone: String,
    var branchId : String,
    var role : JSONObject,
    var profileImage : String,
    var lastLoginDate : String,
    var createdDate : String,
    var updatedDate : String,
    var deletedDate : String
)