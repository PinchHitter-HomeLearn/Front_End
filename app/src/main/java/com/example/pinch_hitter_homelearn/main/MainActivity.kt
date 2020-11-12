package com.example.pinch_hitter_homelearn.main

import android.annotation.SuppressLint
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnTouchListener
import androidx.appcompat.app.AppCompatActivity
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.adapter.PageAdapter
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.custom_tab_button.view.*


class MainActivity : AppCompatActivity() {

    private lateinit var mContext: Context

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mContext = applicationContext
        initViewPager()

    }

    private fun createView(tabName: String): View {
        var tabView = LayoutInflater.from(mContext).inflate(R.layout.custom_tab_button, null)

        tabView.tab_text.text = tabName
        when (tabName) {
            "홈런" -> {
                tabView.tab_logo.setImageResource(R.drawable.tabbar_home_btn)
                return tabView
            }
            "지역" -> {
                tabView.tab_logo.setImageResource(R.drawable.tabbar_position_btn)
                return tabView
            }
            "게시판" -> {
                tabView.tab_logo.setImageResource(R.drawable.tabbar_board_btn)
                return tabView
            }
            "채팅" -> {
                tabView.tab_logo.setImageResource(R.drawable.tabbar_chat_btn)
                return tabView
            }
            "내정보" -> {
                tabView.tab_logo.setImageResource(R.drawable.tabbar_myinfo_btn)
                return tabView
            }
            else -> {
                return tabView
            }
        }
    }

    @SuppressLint("ClickableViewAccessibility")
    private fun initViewPager() {

        val adapter = PageAdapter(supportFragmentManager)
        main_viewPager.adapter = adapter

        main_tablayout.setupWithViewPager(main_viewPager)

        main_viewPager.setOnTouchListener(OnTouchListener { arg0, arg1 -> true })

        main_tablayout.getTabAt(0)?.setCustomView(createView("홈런"))
        main_tablayout.getTabAt(1)?.setCustomView(createView("지역"))
        main_tablayout.getTabAt(2)?.setCustomView(createView("게시판"))
        main_tablayout.getTabAt(3)?.setCustomView(createView("채팅"))
        main_tablayout.getTabAt(4)?.setCustomView(createView("내정보"))
    }
}