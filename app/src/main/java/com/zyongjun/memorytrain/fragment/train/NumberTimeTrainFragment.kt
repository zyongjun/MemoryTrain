package com.zyongjun.memorytrain.fragment.train

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.PagerSnapHelper
import android.view.View
import com.windhike.fastcoding.CommonFragmentActivity
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.adapter.NumberTimeTrainAdapter
import kotlinx.android.synthetic.main.fragment_number_code.*

class NumberTimeTrainFragment : BaseFragment() {
    companion object {
        fun start(context: Context,time:Int = 60) {
            val bundle = Bundle()
            CommonFragmentActivity.start(context,NumberTimeTrainFragment::class.java.name,bundle)
        }
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_number_time_train
    }

    override fun initView() {
        super.initView()
        toolbarBuilder.showLeft(true)
                .withTitle("数字记忆")
                .show()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val layoutManager = LinearLayoutManager(activity)
        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
        rvCode.layoutManager = layoutManager
        PagerSnapHelper().attachToRecyclerView(rvCode)
        rvCode.adapter = NumberTimeTrainAdapter(activity)
    }

}