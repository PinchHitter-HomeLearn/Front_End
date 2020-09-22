package com.example.pinch_hitter_homelearn.`interface`
import retrofit2.Call
import retrofit2.http.FormUrlEncoded
import retrofit2.http.*


interface ApiService {

    @FormUrlEncoded
    @POST("/api/login")
    fun loginApi(
            // Input Data
            @Field("id") id:String,
            @Field("password") password:String
    ) : Call<LoginClass> // Get Data




}