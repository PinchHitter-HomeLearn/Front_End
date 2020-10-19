package com.example.pinch_hitter_homelearn.auth

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Checkable
import android.widget.Toast
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.ApiService
import com.example.pinch_hitter_homelearn.`interface`.SignUpClass
import com.google.gson.Gson
import com.google.gson.JsonObject
import kotlinx.android.synthetic.main.activity_sign_up2.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import kotlin.collections.HashMap

class SignUpActivity2 : AppCompatActivity() {

    var user_email = ""
    var user_password = ""
    var user_question = ""
    var user_answer = ""
    var user_name_flag = false
    var user_phone_flag = false
    var gender = ""

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)


        user_email = intent.getStringExtra("email").toString()
        user_password = intent.getStringExtra("pw").toString()
        user_question = intent.getStringExtra("question").toString()
        user_answer = intent.getStringExtra("findAnswer").toString()

        Gender_male.setOnClickListener {
            Gender_male.setBackgroundResource(R.drawable.gender_check)
            Gender_male.setTextColor(Color.parseColor("#EB5757"))

            Gender_female.setBackgroundResource(R.drawable.gender_uncheck)
            Gender_female.setTextColor(Color.parseColor("#C4C4C4"))

            gender = "male"
        }

        Gender_female.setOnClickListener {
            Gender_male.setBackgroundResource(R.drawable.gender_uncheck)
            Gender_male.setTextColor(Color.parseColor("#C4C4C4"))

            Gender_female.setBackgroundResource(R.drawable.gender_check)
            Gender_female.setTextColor(Color.parseColor("#EB5757"))

            gender = "female"
        }

        user_name_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, count: Int) {
                if (count == 0) {
                    user_name_flag = false
                } else if (count > 0) {
                    user_name_flag = true
                }
            }
        })

        user_phone_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, count: Int) {
                if (count == 0) {
                    user_phone_flag = false
                } else if (count > 0) {
                    user_phone_flag = true
                }
            }
        })

        user_useinfo_checkbox.setOnClickListener {
            if (user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag) {
                sign_up_last.setBackgroundResource(R.drawable.sign_up_button2)
            } else {
                sign_up_last.setBackgroundResource(R.drawable.sign_up_button)
            }
        }

        sign_back_btn2.setOnClickListener {
            var back = Intent(this@SignUpActivity2, SignUpActivity::class.java)
            startActivity(back)
        }


        sign_up_last.setOnClickListener {
            if (user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag) {
                var username = user_name_input.text.toString()
                var phone = user_phone_input.text.toString()
                var user_question_num = user_question.toInt()


//                val data = HashMap<String, String>()
//
//                data["loginId"] = user_email
//                data["passWord"] = user_password
//                data["sns"] = "None"
//                data["name"] = username
//                data["birthDay"] = "950701"
//                data["sex"] = gender
//                data["phone"] = phone
//                data["branchId"] = "10"
//                data["roleName"] = "employee"
//                data["hintId"] = user_question_num.toString()
//                data["answer"] = user_answer

                var userSignUpData = JSONObject()

                userSignUpData.put("loginId", user_email)
                userSignUpData.put("passWord", user_password)
                userSignUpData.put("sns", "None")
                userSignUpData.put("name", username)
                userSignUpData.put("birthDay", "950701")
                userSignUpData.put("sex", gender)
                userSignUpData.put("phone", phone)
                userSignUpData.put("branchId", 10)
                userSignUpData.put("roleName", "employee")
                userSignUpData.put("hintId", user_question_num)
                userSignUpData.put("answer", user_answer)

                println(userSignUpData)
//                 user_email, user_password, "None", username, "950701", gender, phone, 10, "employee", user_question_num, user_answer
                apiconnect.signUpApi(userSignUpData).enqueue(object : Callback<SignUpClass> {
                    override fun onFailure(call: Call<SignUpClass>, t: Throwable) {
                        t.message?.let { it1 -> Log.d("DEBUG", it1) }
                        println("여기로 타는중")
                        Toast.makeText(applicationContext, "서버 통신 오류", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<SignUpClass>, response: Response<SignUpClass>) {
                        val result = response.body()

                        println("여기로 탐" + result)
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

//    val retrofit = Retrofit.Builder()
//        .baseUrl("http://3.35.40.128:8080")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()

    // Connect Service
    val apiconnect = retrofit.create(ApiService::class.java)
}