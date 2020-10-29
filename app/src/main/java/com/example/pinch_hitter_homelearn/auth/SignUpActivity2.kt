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

    var userEmail = ""
    var userPassword = ""
    var userQuestion = ""
    var userAnswer = ""
    var user_name_flag = false
    var user_phone_flag = false
    var user_birth_flag = false

    @SuppressLint("ResourceAsColor")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)


        userEmail = intent.getStringExtra("email").toString()
        userPassword = intent.getStringExtra("pw").toString()
        userQuestion = intent.getStringExtra("question").toString()
        userAnswer = intent.getStringExtra("findAnswer").toString()


        user_name_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString()?.length == 0) {
                    user_name_flag = false
                } else if (p0.toString()?.length > 0 ) {
                    user_name_flag = true
                }

                if(user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag && user_birth_flag) {
                    sign_up_last.setBackgroundResource(R.drawable.sign_up_button2)
                } else {
                    sign_up_last.setBackgroundResource(R.drawable.sign_up_button)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, count: Int) {}
        })

        user_phone_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString()?.length == 0) {
                    user_phone_flag = false
                } else if (p0.toString()?.length > 0 ) {
                    user_phone_flag = true
                }

                if(user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag && user_birth_flag) {
                    sign_up_last.setBackgroundResource(R.drawable.sign_up_button2)
                } else {
                    sign_up_last.setBackgroundResource(R.drawable.sign_up_button)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, count: Int) {}
        })

        user_birth_input.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(p0: Editable?) {
                if (p0.toString()?.length == 0) {
                    user_birth_flag = false
                } else if (p0.toString()?.length > 0 ) {
                    user_birth_flag = true
                }

                if(user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag && user_birth_flag) {
                    sign_up_last.setBackgroundResource(R.drawable.sign_up_button2)
                } else {
                    sign_up_last.setBackgroundResource(R.drawable.sign_up_button)
                }
            }

            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, count: Int) {}
        })

        user_useinfo_checkbox.setOnClickListener {
            if (user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag && user_birth_flag) {
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
            if (user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag && user_birth_flag) {
                var userName = user_name_input.text.toString()
                var userPhone = user_phone_input.text.toString()
                var userQuestionNum = userQuestion.toInt()
                var userBirth = user_birth_input.text.toString()
                var getGender = gender_group.checkedRadioButtonId
                var gender = resources.getResourceEntryName(getGender)

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

                userSignUpData.put("loginId", userEmail)
                userSignUpData.put("passWord", userPassword)
                userSignUpData.put("sns", "None")
                userSignUpData.put("name", userName)
                userSignUpData.put("birthDay", userBirth)
                userSignUpData.put("sex", gender)
                userSignUpData.put("phone", userPhone)
                userSignUpData.put("branchId", 10)
                userSignUpData.put("roleName", "employee")
                userSignUpData.put("hintId", userQuestionNum)
                userSignUpData.put("answer", userAnswer)


//                SignUpData.put("member", userSignUpData)
//                SignUpData.put("hintId", user_question_num)
//                SignUpData.put("answer", user_answer)

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
//            .baseUrl("http://3.35.40.128:8080")
//            .addConverterFactory(GsonConverterFactory.create())
//            .build()

    // Connect Service
    val apiconnect = retrofit.create(ApiService::class.java)
}