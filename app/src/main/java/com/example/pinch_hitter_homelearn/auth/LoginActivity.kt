package com.example.pinch_hitter_homelearn.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.ApiService
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        
        
        
        sign_up_btn.setOnClickListener {
            val signUpIntent = Intent(this@LoginActivity, SignUpActivity::class.java)
            startActivity(signUpIntent)
        }
    }

    // Declare an Retrofit object
    val retrofit = Retrofit.Builder()
            .baseUrl("")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    // Connect Service
    val apiconnect = retrofit.create(ApiService::class.java)
}