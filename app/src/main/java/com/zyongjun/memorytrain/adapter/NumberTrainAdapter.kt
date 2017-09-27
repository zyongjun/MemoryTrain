package com.zyongjun.memorytrain.adapter

import android.os.SystemClock
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.fragment.train.RememberRecord
import kotlinx.android.synthetic.main.item_number.view.*
import java.util.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */

class NumberTrainAdapter(var callback:(postion:Int)->Unit)
    : RecyclerView.Adapter<NumberTrainAdapter.CardHolder>(){
    val mOrderedPokerList = arrayListOf<String>()
    var isRememberMode:Boolean = true
    var indexRequestSelect = 0
    var restorePokerList:MutableList<String> = mutableListOf()
    var rememberCount = 0

    fun initData() {
        for(i in 0.. rememberCount-1){
            mOrderedPokerList.add(String.format("%02d",Random().nextInt(100)))
        }
        shuffle()
        restorePokerList.clear()
        mOrderedPokerList.forEach {
            restorePokerList.add("-1")
        }
    }

    fun shuffle() {
        val endIndex = mOrderedPokerList.size - 1
        for (i in 0..endIndex) {
            if (endIndex == i) {
                break
            }
            val randomExchangeIndex = i + Random().nextInt(endIndex - i)
            val tmp = mOrderedPokerList[i]
            mOrderedPokerList[i] = mOrderedPokerList[randomExchangeIndex]
            mOrderedPokerList[randomExchangeIndex] = tmp
        }
    }

    fun obtainGridSpanCount(): Int {
        return 8
    }

    fun restore(restoreItem: String) {
        restorePokerList[indexRequestSelect] = restoreItem
        notifyDataSetChanged()
    }

    fun checkResult(chronTimmer: Chronometer): RememberRecord {
        var rightCount = 0
        restorePokerList.forEachIndexed { index, card ->
            if (!card .equals("-1") && mOrderedPokerList[index].equals(card)) {
                rightCount++
            }
        }
        val time = (SystemClock.elapsedRealtime() - chronTimmer.base) / 1000
        val rememberRecord = RememberRecord(chronTimmer.text.toString(), time, rightCount, mOrderedPokerList.size)
        return rememberRecord
    }

    override fun getItemCount(): Int = mOrderedPokerList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_number, parent, false))
    }

    fun switchMode() {
        isRememberMode = !isRememberMode
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        if(isRememberMode){
            holder.bindData(mOrderedPokerList[position])
            holder.itemView.setOnClickListener(null)
        }else{
            holder.bindData(restorePokerList[position])
            holder.itemView.setOnClickListener {
                indexRequestSelect = position
                callback(position)
            }
        }
    }

    class CardHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindData(poker: String) {
            if(poker.equals("-1")){
                itemView.tvCard.visibility = View.GONE
                itemView.rlAdd.visibility = View.VISIBLE
            }else{
                itemView.rlAdd.visibility = View.GONE
                itemView.tvCard.visibility = View.VISIBLE
                itemView.tvCard.setText(poker)
            }
        }
    }
}