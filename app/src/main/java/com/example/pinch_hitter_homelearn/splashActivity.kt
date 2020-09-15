package com.example.pinch_hitter_homelearn

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.example.pinch_hitter_homelearn.auth.LoginActivity

class splashActivity : AppCompatActivity() {

    // 스플레쉬 화면 딜레이 길이 설정
    val splashTime : Long = 1000

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        //딜레이 선언
        Handler().postDelayed({
            startActivity(Intent(this, LoginActivity::class.java)) // 화면 넘기기 Intent
            finish()
        }, splashTime)
    }
}