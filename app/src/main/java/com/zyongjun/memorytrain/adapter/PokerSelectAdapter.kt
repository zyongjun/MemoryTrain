package com.zyongjun.memorytrain.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.zyongjun.memorytrain.R
import kotlinx.android.synthetic.main.item_poker.view.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
class PokerSelectAdapter(val pokerList:List<Poker>):RecyclerView.Adapter<PokerSelectAdapter.CardHolder>(){
    var selectIndex:Int = -1;
    override fun getItemCount(): Int = pokerList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_poker, parent, false))
    }

    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bindData(pokerList[position])
        holder.itemView.setTag(position)
        holder.itemView.ivPoker.alpha = if (selectIndex == position) 0.2f else 1f
        holder.itemView.setOnClickListener {
            selectIndex = it.tag as Int
            notifyDataSetChanged()
        }
    }

    class CardHolder(view: View):RecyclerView.ViewHolder(view){
        fun bindData(poker: Poker) {
            Glide.with(itemView.getContext()).load(poker.pokerImg).into(itemView.ivPoker)
        }
    }
}