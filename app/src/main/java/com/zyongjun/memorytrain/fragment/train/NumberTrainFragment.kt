package com.zyongjun.memorytrain.fragment.train

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import com.windhike.fastcoding.CommonFragmentActivity
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.adapter.NumberTrainAdapter
import com.zyongjun.memorytrain.widget.HorizontalPageLayoutManager
import kotlinx.android.synthetic.main.fragment_poker_train.*
import com.zyongjun.memorytrain.widget.PagingItemDecoration
import com.zyongjun.memorytrain.widget.PagingScrollHelper

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
class NumberTrainFragment : BaseFragment() {

    val mAdapter by lazy {
        NumberTrainAdapter() {  s: String ->
            btnRestore.setText(s)
        }
    }

    companion object {
        var numberCount = 32
        val REQUEST_SELECT_POKER = 101
        val KEY_REMEMBER_TYPE ="KEY_REMEMBER_TYPE"
        fun start(context: Context, numberCount:Int = 32) {
            val bundle = Bundle()
            bundle.putInt(KEY_REMEMBER_TYPE,numberCount)
            CommonFragmentActivity.start(context, NumberTrainFragment::class.java.name, bundle)
        }
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_poker_train
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        numberCount = arguments.getInt(KEY_REMEMBER_TYPE)
        mAdapter.rememberCount = numberCount
        mAdapter.initData()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarBuilder.showLeft(true)
                .withTitle("数字训练")
                .showRight(false)
                .show()

        val layoutManager= HorizontalPageLayoutManager(1,3)
        val pagingItemDecoration = PagingItemDecoration(activity, layoutManager)
        val scrollHelper = PagingScrollHelper()
        scrollHelper.setUpRecycleView(rvPoker)
        //设置页面滚动监听
        scrollHelper.setOnPageChangeListener{

        }
        rvPoker.addItemDecoration(pagingItemDecoration)
        rvPoker.layoutManager = layoutManager
        rvPoker.adapter = mAdapter
        chronTimmer.start()
        btnRestore.setOnClickListener {
            chronTimmer.stop()
            mAdapter.seeResult()
        }

        btnFinished.setOnClickListener {
            chronTimmer.stop()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_CANCELED) {
            return
        }
        if (requestCode == REQUEST_SELECT_POKER) {

        }
    }

}



