package com.example.pinch_hitter_homelearn.main

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
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
                tabView.tab_logo.setImageResource(R.drawable.ic_home_btn)
                return tabView
            }
            "지역" -> {
                tabView.tab_logo.setImageResource(R.drawable.ic_position_btn)
                return tabView
            }
            "" -> {
                tabView.tab_logo.setImageResource(R.drawable.ic_fab_btn)
                return tabView
            }
            "채팅·알림" -> {
                tabView.tab_logo.setImageResource(R.drawable.ic_alarm_btn)
                return tabView
            }
            "히스토리" -> {
                tabView.tab_logo.setImageResource(R.drawable.ic_history_btn)
                return tabView
            }
            else -> {
                return tabView
            }
        }
    }

    private fun initViewPager() {
        val homeFragment = FragmentTab()
        homeFragment.name = "홈런"
        val positionFragment = FragmentTab()
        positionFragment.name = "지역"
        val findpersonFragment = FragmentTab()
        findpersonFragment.name = ""
        val chatandalarmFragment = FragmentTab()
        chatandalarmFragment.name = "채팅·알림"
        val historyFragment = FragmentTab()
        historyFragment.name = "히스토리"

        val adapter = PageAdapter(supportFragmentManager)
        adapter.addItems(homeFragment)
        adapter.addItems(positionFragment)
        adapter.addItems(findpersonFragment)
        adapter.addItems(chatandalarmFragment)
        adapter.addItems(historyFragment)

        main_viewPager.adapter = adapter
        main_tablayout.setupWithViewPager(main_viewPager)

        main_tablayout.getTabAt(0)?.setCustomView(createView("홈런"))
        main_tablayout.getTabAt(1)?.setCustomView(createView("지역"))
        main_tablayout.getTabAt(2)?.setCustomView(createView(""))
        main_tablayout.getTabAt(3)?.setCustomView(createView("채팅·알림"))
        main_tablayout.getTabAt(4)?.setCustomView(createView("히스토리"))
    }
}