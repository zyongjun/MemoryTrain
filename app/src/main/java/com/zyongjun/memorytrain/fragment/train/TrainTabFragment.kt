package com.zyongjun.memorytrain.fragment.train

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.adapter.TrainAdapter
import com.zyongjun.memorytrain.adapter.TrainModel
import kotlinx.android.synthetic.main.fragment_tab_train.*

/**
 * author:gzzyj on 2017/9/12 0012.
 * email:zhyongjun@windhike.cn
 */
class TrainTabFragment() : BaseFragment() {

    companion object {
        val TAG:String = "TrainTabFragment"
    }

    override fun isSubPage(): Boolean {
        return true
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_tab_train
    }

    override fun initView() {
        super.initView()
        toolbarBuilder.showLeft(false)
                .showRight(false)
                .withTitle(getString(R.string.title_train))
                .show()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        val trainList = arrayListOf(TrainModel(0, "扑克训练"),
                TrainModel(1, "数字训练"),
                TrainModel(2, "电话号码训练"),
                TrainModel(3,"数字计时")
        )
        recyclerView.adapter = TrainAdapter(trainList)
    }
}