package com.zyongjun.memorytrain.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zyongjun.memorytrain.R
import kotlinx.android.synthetic.main.item_number.view.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
class NumberSelectAdapter(): RecyclerView.Adapter<NumberSelectAdapter.CardHolder>(){
    val mNumberDataList = arrayListOf<String>()
    var selectItem:String = "-1";

    fun initData() {
        mNumberDataList.clear()
        for(i in 0..10){
            mNumberDataList.add("$i")
        }
        for (i in 0..100) {
            mNumberDataList.add(String.format("%02d",i))
        }

    }

    override fun getItemCount(): Int = mNumberDataList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_number, parent, false))
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bindData(mNumberDataList[position])
        holder.itemView.setTag(mNumberDataList[position])
        holder.itemView.tvCard.alpha = if (selectItem.equals(mNumberDataList[position])) 0.2f else 1f
        holder.itemView.setOnClickListener {
            selectItem = it.tag as String
            notifyDataSetChanged()
        }
    }

    class CardHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindData(card: String) {
            itemView.tvCard.setText(card)
        }
    }
}