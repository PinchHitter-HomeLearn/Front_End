package com.example.pinch_hitter_homelearn.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.pinch_hitter_homelearn.R
import com.example.pinch_hitter_homelearn.`interface`.AlbaCard
import com.example.pinch_hitter_homelearn.main.HomeFragment
import kotlinx.android.synthetic.main.main_list_item_custom.view.*

class AlbaCardAdapter(val context : Context, val albaCard: ArrayList<AlbaCard>
//                      , var clickListener: ItemClickListener
)
    :RecyclerView.Adapter<AlbaCardAdapter.AlbaListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, type: Int): AlbaListViewHolder {
        val viewGroup = LayoutInflater.from(parent.context).inflate(R.layout.main_list_item_custom, parent, false)
        return AlbaListViewHolder(viewGroup)
    }

    override fun getItemCount(): Int {
        return albaCard.size
    }

    override fun onBindViewHolder(holder: AlbaListViewHolder, position: Int) {

        holder.init(albaCard.get(position)
//            , clickListener
        )
    }


    class AlbaListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val alba_condition : TextView = itemView.albaCondition
        val alba_region : TextView = itemView.main_list_region
        val alba_like : ImageView = itemView.main_board_like
        val alba_title : TextView = itemView.main_list_title
        val alba_date : TextView = itemView.main_list_date
        val alba_time: TextView = itemView.main_list_time
        val alba_money_type : TextView = itemView.main_list_money_type
        val alba_money : TextView = itemView.main_list_money

        fun init( item : AlbaCard
//                  ,action: ItemClickListener
        ) {

            alba_condition.text = item.alba_condition
            alba_region.text = item.alba_region
            alba_like.setImageResource(item.alba_like)
            alba_title.text = item.alba_title
            alba_date.text = item.alba_date
            alba_time.text = item.alba_time
            alba_money_type.text= item.alba_money_type
            alba_money.text =item.alba_money

//            itemView.setOnClickListener{
//                action.onClick(item, adapterPosition)
//            }
        }
    }

//    interface ItemClickListener {
//        fun onClick(view: AlbaCard, position: Int)
//    }
}