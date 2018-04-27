package com.zyongjun.memorytrain.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zyongjun.memorytrain.R
import kotlinx.android.synthetic.main.item_number_code.view.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */

class NumberCodeAdapter()
    : RecyclerView.Adapter<NumberCodeAdapter.CardHolder>(){
    val mCodeList = arrayListOf<String>()

    override fun getItemCount(): Int = mCodeList.size

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CardHolder {
        return CardHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_number_code, parent, false))
    }


    override fun onBindViewHolder(holder: CardHolder, position: Int) {
        holder.bindData(mCodeList[position])
    }

    class CardHolder(view: View): RecyclerView.ViewHolder(view){
        fun bindData(poker: String) {
            itemView.tvNumberCode.setText(poker)
        }
    }

    fun initData() {
        mCodeList.add("00\n鸡蛋")
        mCodeList.add("01\n鸡蛋")
        mCodeList.add("02\n鸡蛋")
        mCodeList.add("03\n鸡蛋")
        mCodeList.add("04\n鸡蛋")
        mCodeList.add("05\n鸡蛋")
        mCodeList.add("06\n鸡蛋")
        mCodeList.add("07\n鸡蛋")
        mCodeList.add("08\n鸡蛋")
        mCodeList.add("09\n鸡蛋")
        mCodeList.add("10\n鸡蛋")
        mCodeList.add("11\n鸡蛋")
        mCodeList.add("12\n鸡蛋")
        mCodeList.add("13\n鸡蛋")
        mCodeList.add("14\n鸡蛋")
        mCodeList.add("15\n鸡蛋")
        mCodeList.add("16\n鸡蛋")
        mCodeList.add("17\n鸡蛋")
        mCodeList.add("19\n鸡蛋")
        mCodeList.add("20\n鸡蛋")
        mCodeList.add("21\n鸡蛋")
        mCodeList.add("22\n鸡蛋")
        mCodeList.add("23\n鸡蛋")
        mCodeList.add("24\n鸡蛋")
        mCodeList.add("25\n鸡蛋")
        mCodeList.add("26\n鸡蛋")
        mCodeList.add("27\n鸡蛋")
        mCodeList.add("28\n鸡蛋")
        mCodeList.add("29\n鸡蛋")
        mCodeList.add("30\n鸡蛋")
        mCodeList.add("31\n鸡蛋")
        mCodeList.add("32\n鸡蛋")
        mCodeList.add("33\n鸡蛋")
        mCodeList.add("34\n鸡蛋")
        mCodeList.add("35\n鸡蛋")
        mCodeList.add("36\n鸡蛋")
        mCodeList.add("37\n鸡蛋")
        mCodeList.add("38\n鸡蛋")
        mCodeList.add("39\n鸡蛋")
        mCodeList.add("40\n鸡蛋")
        mCodeList.add("41\n鸡蛋")
        mCodeList.add("42\n鸡蛋")
        mCodeList.add("43\n鸡蛋")
        mCodeList.add("44\n鸡蛋")
        mCodeList.add("45\n鸡蛋")
        mCodeList.add("46\n鸡蛋")
        mCodeList.add("47\n鸡蛋")
        mCodeList.add("48\n鸡蛋")
        mCodeList.add("49\n鸡蛋")
        mCodeList.add("50\n鸡蛋")
        mCodeList.add("51\n鸡蛋")
        mCodeList.add("52\n鸡蛋")
        mCodeList.add("53\n鸡蛋")
        mCodeList.add("54\n鸡蛋")
        mCodeList.add("55\n鸡蛋")
        mCodeList.add("56\n鸡蛋")
        mCodeList.add("57\n鸡蛋")
        mCodeList.add("58\n鸡蛋")
        mCodeList.add("59\n鸡蛋")
        mCodeList.add("60\n鸡蛋")
        mCodeList.add("61\n鸡蛋")
        mCodeList.add("62\n鸡蛋")
        mCodeList.add("63\n鸡蛋")
        mCodeList.add("64\n鸡蛋")
        mCodeList.add("65\n鸡蛋")
        mCodeList.add("66\n鸡蛋")
        mCodeList.add("67\n鸡蛋")
        mCodeList.add("68\n鸡蛋")
        mCodeList.add("69\n鸡蛋")
        mCodeList.add("70\n鸡蛋")
        mCodeList.add("71\n鸡蛋")
        mCodeList.add("72\n鸡蛋")
        mCodeList.add("73\n鸡蛋")
        mCodeList.add("74\n鸡蛋")
        mCodeList.add("75\n鸡蛋")
        mCodeList.add("76\n鸡蛋")
        mCodeList.add("77\n鸡蛋")
        mCodeList.add("78\n鸡蛋")
        mCodeList.add("79\n鸡蛋")
        mCodeList.add("80\n鸡蛋")
        mCodeList.add("81\n鸡蛋")
        mCodeList.add("82\n鸡蛋")
        mCodeList.add("83\n鸡蛋")
        mCodeList.add("84\n鸡蛋")
        mCodeList.add("85\n鸡蛋")
        mCodeList.add("86\n鸡蛋")
        mCodeList.add("87\n鸡蛋")
        mCodeList.add("88\n鸡蛋")
        mCodeList.add("89\n鸡蛋")
        mCodeList.add("90\n鸡蛋")
        mCodeList.add("91\n鸡蛋")
        mCodeList.add("92\n鸡蛋")
        mCodeList.add("93\n鸡蛋")
        mCodeList.add("94\n鸡蛋")
        mCodeList.add("95\n鸡蛋")
        mCodeList.add("96\n鸡蛋")
        mCodeList.add("97\n鸡蛋")
        mCodeList.add("98\n鸡蛋")
        mCodeList.add("99\n鸡蛋")
        mCodeList.add("0\n鸡蛋")
        mCodeList.add("1\n鸡蛋")
        mCodeList.add("2\n鸡蛋")
        mCodeList.add("3\n鸡蛋")
        mCodeList.add("4\n鸡蛋")
        mCodeList.add("5\n鸡蛋")
        mCodeList.add("6\n鸡蛋")
        mCodeList.add("7\n鸡蛋")
        mCodeList.add("8\n鸡蛋")
        mCodeList.add("9\n鸡蛋")
    }
}