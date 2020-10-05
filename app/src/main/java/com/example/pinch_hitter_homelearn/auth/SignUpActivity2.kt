package com.example.pinch_hitter_homelearn.auth

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.SignUpClass
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class SignUpActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up2)


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