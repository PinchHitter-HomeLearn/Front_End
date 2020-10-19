package com.example.pinch_hitter_homelearn.`interface`

import com.google.gson.JsonObject
import com.google.gson.annotations.SerializedName
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.*
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.Map as Map


interface ApiService {

    @FormUrlEncoded
    @POST("/members/{id}")
    fun loginApi(
        // Input Data
        @Path("id") id:String,
        @Field("passWord") passWord:String
    ) : Call<LoginClass> // Get Data

    //    @FormUrlEncoded
    @POST("/api/question/members")
    fun signUpApi(
        @Body data :JSONObject
//        @Field("loginId") member : String,
//        @Field("passWord") passWord : String,
//        @Field("sns") sns : String,
//        @Field("name") name : String,
//        @Field("birthDay") birthDay : String,
//        @Field("sex") sex : String,
//        @Field("phone") phone : String,
//        @Field("branchId") branchId : Int,
//        @Field("roleName") roleName : String,
//        @Field("hintId") hintId : Int,
//        @Field("answer") answer : String
    ) : Call<SignUpClass> // Get Data
}