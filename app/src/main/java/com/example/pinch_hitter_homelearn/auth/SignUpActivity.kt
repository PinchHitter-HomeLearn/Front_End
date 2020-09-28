package com.example.pinch_hitter_homelearn.auth

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.ApiService
import com.example.pinch_hitter_homelearn.`interface`.SignUpClass
import kotlinx.android.synthetic.main.activity_login.*
import kotlinx.android.synthetic.main.activity_signup.*
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*

class SignUpActivity : AppCompatActivity() {

    var id_check = true
    var hint_id = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)

        val items = resources.getStringArray(R.array.pw_find_array)

        val spinnerAdapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items)

        pw_find_question_choice.adapter = spinnerAdapter
        hint_id = pw_find_question_choice.selectedItemPosition.toString()
        hint_id = hint_id +1
        signUpBtn.setOnClickListener {

            var email = user_email.text.toString()
            var pw = user_password.text.toString()
            var find_asnwer = pw_find_answer.text.toString()
            var birth = birth_day.text.toString()
            var name = user_name.text.toString()
            var sex = Sex_Group.checkedRadioButtonId
            var phoneNum = "01084802790"
            var branch = user_sign_point.text.toString()

            var role = JSONObject()
            role.put("id", 1)

            if(user_email != null && id_check == true && user_password != null && pw_find_answer != null && user_name != null && birth_day != null && sex != null) {
//                var sex2 = resources.getResourceEntryName(sex)

                val memberObject = JSONObject()
                memberObject.put("loginId", email)
                memberObject.put("passWord", pw)
                memberObject.put("sns", "None")
                memberObject.put("name", name)
                memberObject.put("birthDay", birth)
                memberObject.put("sex", "male")
                memberObject.put("phone", phoneNum)
                memberObject.put("branchId", 1)
                memberObject.put("role", role)

                println(memberObject)

                apiconnect.signUpApi(memberObject, 1, pw_find_answer.text.toString()).enqueue(object : Callback<SignUpClass> {
                    override fun onFailure(call: Call<SignUpClass>, t: Throwable) {
                        t.message?.let { it1 -> Log.d("DEBUG", it1)}
                        println("여기로 타는중")
                        Toast.makeText(applicationContext, "서버 통신 오류", Toast.LENGTH_SHORT).show()
                    }

                    override fun onResponse(call: Call<SignUpClass>, response: Response<SignUpClass>) {
                        val result = response.body();
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

    // Connect Service
    val apiconnect = retrofit.create(ApiService::class.java)
}