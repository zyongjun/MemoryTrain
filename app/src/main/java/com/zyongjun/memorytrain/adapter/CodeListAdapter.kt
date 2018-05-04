package com.zyongjun.memorytrain.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.fragment.train.NumberCodeFragment
import kotlinx.android.synthetic.main.item_train.view.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
class CodeListAdapter(): RecyclerView.Adapter<CodeListAdapter.CodeListHolder>() {
    companion object {
        val codeList by lazy{
            arrayListOf("数字编码","扑克编码")
        }
    }
    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): CodeListHolder {
        return CodeListHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.item_train, parent, false))
    }

    override fun onBindViewHolder(holder: CodeListHolder?, position: Int) {
        holder!!.bindData(position,codeList[position])
    }

    override fun getItemCount(): Int = codeList.size


    class CodeListHolder(view: View) : RecyclerView.ViewHolder(view) {
        fun bindData(position:Int,model: String){
            itemView.tvName.text = model
            itemView.setOnClickListener {
                when(position){
                    0-> NumberCodeFragment.start(it.context)
                    else-> {}
                }
            }
        }
    }

}