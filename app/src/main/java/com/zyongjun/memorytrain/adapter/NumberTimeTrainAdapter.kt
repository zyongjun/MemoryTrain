package com.zyongjun.memorytrain.adapter

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zyongjun.memorytrain.R
import kotlinx.android.synthetic.main.item_number_time_mode.view.*
import java.util.*

class NumberTimeTrainAdapter(val context:Context):RecyclerView.Adapter<NumberTimeTrainAdapter.Holder>(){
    val datas = arrayListOf<String>()
    var restoreList = mutableSetOf<String>()
    var rememberCount = 15

    init {
        for(i in 0.. rememberCount-1){
            datas.add(String.format("%02d",Random().nextInt(100)))
        }
        shuffle()
//        restoreList.addAll(datas)
    }

    fun shuffle() {
        val endIndex = datas.size - 1
        for (i in 0..endIndex) {
            if (endIndex == i) {
                break
            }
            val randomExchangeIndex = i + Random().nextInt(endIndex - i)
            val tmp = datas[i]
            datas[i] = datas[randomExchangeIndex]
            datas[randomExchangeIndex] = tmp
        }
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.bindData(datas[position],restoreList)
        holder.itemView.setOnClickListener{
            restoreList.add(datas[position])
            notifyItemChanged(position)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        return Holder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_number_time_mode,parent,false))
    }


    class Holder(itemView:View):RecyclerView.ViewHolder(itemView){

        fun bindData(number:String,unRememberSet:MutableSet<String>) {
            itemView.tvCard.setText(number)
            itemView.ivCuo.visibility = if(unRememberSet.contains(number)) View.VISIBLE else View.GONE
        }
    }
}