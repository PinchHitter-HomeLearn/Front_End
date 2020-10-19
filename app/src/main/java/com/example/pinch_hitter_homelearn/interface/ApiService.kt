package com.example.pinch_hitter_homelearn.`interface`
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.*


interface ApiService {

    @FormUrlEncoded
    @POST("/members/{id}")
    fun loginApi(
            // Input Data
            @Path("id") id:String,
            @Field("passWord") passWord:String
    ) : Call<LoginClass> // Get Data

//    @FormUrlEncoded
    @POST("/members/")
    fun signUpApi(
            @Body body: JSONObject
//            @Field("member") member:JSONObject,
//            @Field("hintId") hintId:Int,
//            @Field("answer") answer:String
    ) : Call<SignUpClass> // Get Data
}