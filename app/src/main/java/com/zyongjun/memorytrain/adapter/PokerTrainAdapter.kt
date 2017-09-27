package com.zyongjun.memorytrain.adapter

import android.os.SystemClock
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Chronometer
import com.bumptech.glide.Glide
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.TrainApplication
import com.zyongjun.memorytrain.fragment.train.RememberRecord
import kotlinx.android.synthetic.main.item_poker.view.*
import java.util.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
data class Poker(var pokerImg:Int)
class PokerTrainAdapter(var callback:(postion:Int)->Unit)
    : RecyclerView.Adapter<PokerTrainAdapter.CardHolder>(){
    val mOriginPokerList = arrayListOf<Poker>()
    val mOrderedPokerList = arrayListOf<Poker>()
    var isRememberMode:Boolean = true
    var indexRequestSelect = 0
    var restorePokerList:MutableList<Poker> = mutableListOf()

    fun initData() {
        mOriginPokerList.clear()
        val attr = TrainApplication.getInstance().resources.obtainTypedArray(R.array.poker_img)
        val endIndex = attr.length() - 1
        for (i in 0..endIndex) {
            val drawablePoker: Int = attr.getResourceId(i, 0)
            val poker = Poker(drawablePoker)
            mOriginPokerList.add(poker)
        }
        mOrderedPokerList.addAll(mOriginPokerList)
        attr.recycle()
        shuffle()
        restorePokerList.clear()
        mOrderedPokerList.forEach {
            restorePokerList.add(Poker(-1))
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
        return 4
    }

    fun restore(restoreIndex: Int) {
        val poker = if(restoreIndex==-1) Poker(-1) else mOriginPokerList[indexRequestSelect]
        restorePokerList[indexRequestSelect] = poker
        notifyDataSetChanged()
    }

    fun checkResult(chronTimmer:Chronometer): RememberRecord {
        var rightCount = 0
        restorePokerList.forEachIndexed { index, poker ->
            if (poker.pokerImg != -1 && mOrderedPokerList[index].pokerImg == poker.pokerImg) {
                rightCount++
            }
        }
        val time = (SystemClock.elapsedRealtime() - chronTimmer.base) / 1000
        val rememberRecord = RememberRecord(chronTimmer.text.toString(), time, rightCount, mOrderedPokerList.size)
        return rememberRecord
    }

    override fun getItemCount(): Int = mOrderedPokerList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_poker, parent, false))
    }

    fun switchMode() {
        isRememberMode = !isRememberMode
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        if(isRememberMode){
            holder.bindData(mOrderedPokerList[position], position)
            holder.itemView.setOnClickListener(null)
        }else{
            holder.bindData(restorePokerList[position],position)
            holder.itemView.setOnClickListener {
                indexRequestSelect=position
                callback(position)
            }
        }
    }

    class CardHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindData(poker: Poker, position: Int) {
            if(poker.pokerImg==-1){
                itemView.ivPoker.visibility = View.GONE
                itemView.rlAdd.visibility = View.VISIBLE
            }else{
                itemView.rlAdd.visibility = View.GONE
                itemView.ivPoker.visibility = View.VISIBLE
                Glide.with(itemView.getContext()).load(poker.pokerImg).into(itemView.ivPoker)
            }
        }
    }
}