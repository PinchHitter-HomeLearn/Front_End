package com.example.pinch_hitter_homelearn.auth

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.widget.Checkable
import android.widget.Toast
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.SignUpClass
import kotlinx.android.synthetic.main.activity_sign_up2.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

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

        user_name_input.addTextChangedListener(object : TextWatcher{
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

        user_phone_input.addTextChangedListener(object : TextWatcher{
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
            if(user_useinfo_checkbox.isChecked && user_name_flag && user_phone_flag) {
                sign_up_last.setBackgroundResource(R.drawable.sign_up_button2)
            } else {
                sign_up_last.setBackgroundResource(R.drawable.sign_up_button)
            }
        }

//        var role = JSONObject()
//        role.put("id", 1)
//
//        if(user_email != null && id_check == true && user_password != null && pw_find_answer != null && user_name != null && birth_day != null && sex != null) {
//            var gender = resources.getResourceEntryName(sex)
//
//            val memberObject = JSONObject()
//            memberObject.put("loginId", email)
//            memberObject.put("passWord", pw)
//            memberObject.put("sns", "None")
//            memberObject.put("name", name)
//            memberObject.put("birthDay", birth)
//            memberObject.put("sex", gender)
//            memberObject.put("phone", phoneNum)
//            memberObject.put("branchId", branch)
//            memberObject.put("role", role)
//
//            println(memberObject)
//
//            apiconnect.signUpApi(memberObject, 1, pw_find_answer.text.toString()).enqueue(object : Callback<SignUpClass> {
//                override fun onFailure(call: Call<SignUpClass>, t: Throwable) {
//                    t.message?.let { it1 -> Log.d("DEBUG", it1)}
//                    println("여기로 타는중")
//                    Toast.makeText(applicationContext, "서버 통신 오류", Toast.LENGTH_SHORT).show()
//                }
//
//                override fun onResponse(call: Call<SignUpClass>, response: Response<SignUpClass>) {
//                    val result = response.body();
//                    println("여기로 탐" + result)
//                }
//
//            })
//        }
    }
}