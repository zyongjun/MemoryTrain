package com.zyongjun.memorytrain.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.fragment.train.NumberCodeFragment
import com.zyongjun.memorytrain.fragment.train.NumberTrainFragment
import com.zyongjun.memorytrain.fragment.train.PhoneTrainFragment
import com.zyongjun.memorytrain.fragment.train.PokerTrainFragment
import kotlinx.android.synthetic.main.item_train.view.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
data class TrainModel(val id:Int,val name:String)
class TrainAdapter(val trainList:List<TrainModel>): RecyclerView.Adapter<TrainAdapter.TrainHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): TrainHolder {
        return TrainHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_train, parent, false))
    }

    override fun onBindViewHolder(holder: TrainHolder?, position: Int) {
        holder!!.bindData(trainList[position])
    }

    override fun getItemCount(): Int = trainList.size


    class TrainHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(model: TrainModel){
            itemView.tvName.text = model.name
            itemView.setOnClickListener {
                when(model.id){
                    0-> PokerTrainFragment.start(it.context)
                    1-> NumberTrainFragment.start(it.context, 32)
                    2-> PhoneTrainFragment.start(it.context,15)
                    3-> NumberCodeFragment.start(it.context)
                    else-> PokerTrainFragment.start(it.context)
                }
            }
        }
    }

}