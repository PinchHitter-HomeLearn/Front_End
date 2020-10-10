package com.example.pinch_hitter_homelearn.`interface`
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.*


interface ApiService {

    @FormUrlEncoded
    @POST("/members/")
    fun loginApi(
            // Input Data
            @Query("id") id:String,
            @Field("password") password:String
    ) : Call<LoginClass> // Get Data

    @FormUrlEncoded
    @POST("/members")
    fun signUpApi(
            @Field("member{}") member:JSONObject,
            @Field("hintId") hintId:Int,
            @Field("answer") answer:String
    ) : Call<SignUpClass> // Get Data


}