package com.example.pinch_hitter_homelearn.main

import IndicatorAdapter
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.LinearSnapHelper
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.AlbaCard
import com.example.pinch_hitter_homelearn.adapter.AlbaCardAdapter
import kotlinx.android.synthetic.main.activity_home_fragment.*


class HomeFragment : Fragment() {

    val albaList : ArrayList<AlbaCard> = ArrayList()
    lateinit var recyclerView : RecyclerView
    lateinit var indexAdapter : RecyclerView
    private val snapHelper: PagerSnapHelper? = null

    override fun onCreateView(
            Inflater: LayoutInflater, container: ViewGroup?,
            savedInstanceState: Bundle?
    ) : View? {

        var rootView = Inflater.inflate(R.layout.activity_home_fragment, container, false)
        albaList.add(AlbaCard("대기중", "투썸플레이스 마포구청점", R.drawable.board_like, "다음주 금요일 오후 8시간 대타해주실 분", "10월 07일~ 10월 08일", "12:00~20:00", "시급", "8,600원"))
        albaList.add(AlbaCard("매칭중", "투썸플레이스 구로구청점", R.drawable.board_unlike, "이번주 대타좀 해주실분", "10월 07일~ 10월 08일", "12:00~20:00", "시급", "5,600원"))

        recyclerView = rootView.findViewById(R.id.albaRecyclerView) as RecyclerView
        recyclerView.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        recyclerView.adapter = AlbaCardAdapter(requireContext(), albaList)

        val indexAdapter = IndicatorAdapter(requireContext(), albaList)
        albaRecyclerView_indicator.adapter = indexAdapter // 어댑터 설정
        albaRecyclerView_indicator.layoutManager = LinearLayoutManager(
            this.context, LinearLayoutManager.HORIZONTAL, false
        )

        val snapHelper = PagerSnapHelper()
        snapHelper.attachToRecyclerView(recyclerView)
        recyclerView.onFlingListener = snapHelper

        // 카드 리스트에 indicator 추가
        recyclerView.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                super.onScrollStateChanged(recyclerView, newState)

                indexAdapter.setItemIndex(
                    (recyclerView.layoutManager as LinearLayoutManager)
                        .findFirstVisibleItemPosition()
                )
            }
        })

        // indicator 터치시 해당 위치로 이동
//        albaRecyclerView_indicator.addOnItemTouchListener(
//            RecyclerItemClickListener(applicationContext, albaRecyclerView_indicator,
//                object : RecyclerItemClickListener.OnItemClickListener {
//                    override fun onItemClick(view: View, position: Int) {
//                        albaRecyclerView.smoothScrollToPosition(position)
//                    }
//                })
//        )

        fun onClick(view: AlbaCard, position: Int) {
            println(position)
        }

        return rootView
    }
}