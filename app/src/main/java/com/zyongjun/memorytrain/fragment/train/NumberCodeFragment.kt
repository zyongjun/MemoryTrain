package com.zyongjun.memorytrain.fragment.train

import android.content.Context
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.windhike.fastcoding.CommonFragmentActivity
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.adapter.NumberCodeAdapter
import kotlinx.android.synthetic.main.fragment_number_code.*

class NumberCodeFragment : BaseFragment() {

    companion object {
        fun start(context: Context, rememberType:Int = 0) {
            val bundle = Bundle()
            CommonFragmentActivity.start(context, NumberCodeFragment::class.java.name, bundle)
        }
    }
    override fun getLayouId(): Int {
        return R.layout.fragment_number_code
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarBuilder.showLeft(true)
                .withTitle("编码记忆")
                .show()
        rvCode.layoutManager = GridLayoutManager(activity,3)
        val adapter = NumberCodeAdapter()
        adapter.initData()
        rvCode.adapter = adapter
    }

}