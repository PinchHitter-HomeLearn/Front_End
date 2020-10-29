package com.example.pinch_hitter_homelearn.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pinch_hitter_homelearn.main.MainActivity
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.ApiService
import com.example.pinch_hitter_homelearn.`interface`.LoginClass
import com.example.pinch_hitter_homelearn.`interface`.SignUpClass
import kotlinx.android.synthetic.main.activity_login.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
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

        find_id_btn.setOnClickListener {
            val signUpIntent = Intent(this@LoginActivity, Find_PW_Activity::class.java)
            startActivity(signUpIntent)
        }

        login_btn.setOnClickListener {
            var user_email = input_id.text.toString()
            var user_password = input_pw.text.toString()

            if(user_email != null && user_password != null) {
                apiconnect.loginApi(user_email, user_password).enqueue(object : Callback<LoginClass> {
                    override fun onFailure(call: Call<LoginClass>, t: Throwable) {
                        t.message?.let { it1 -> Log.d("DEBUG", it1) }
                        println("여기로 타는중")
                        println(t)

                        Toast.makeText(applicationContext, "서버 통신 오류", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<LoginClass>, response: Response<LoginClass>) {
                        val result = response.body();

                        println(result)
//                        if(result?.msg == "success") {
//                            var Intent = Intent(this@LoginActivity, MainActivity::class.java)
//                            intent.putExtra("name", "아이디")
//                            startActivity(Intent)
//                        } else {
//                            Toast.makeText(applicationContext, "로그인 또는 비밀번호가 틀립니다.", Toast.LENGTH_SHORT).show()
//                        }
                    }
                })
            }
        }
    }

    // Declare an Retrofit object
    val retrofit = Retrofit.Builder()
            .baseUrl("http://54.180.187.111:7777")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    // Connect Service
    val apiconnect = retrofit.create(ApiService::class.java)
}