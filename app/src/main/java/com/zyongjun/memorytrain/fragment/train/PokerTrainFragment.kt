package com.zyongjun.memorytrain.fragment.train

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.view.View
import com.windhike.fastcoding.CommonFragmentActivity
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.adapter.PokerTrainAdapter
import kotlinx.android.synthetic.main.fragment_poker_train.*

/**
 * author:gzzyj on 2017/9/13 0013.
 * email:zhyongjun@windhike.cn
 */
class PokerTrainFragment : BaseFragment() {
    val mAdapter by lazy {
        PokerTrainAdapter() {
            startActivityForResult(PokerSelectFragment.obtainStartIntent(activity), REQUEST_SELECT_POKER)
        }
    }

    companion object {
        val REQUEST_SELECT_POKER = 101
        val KEY_REMEMBER_TYPE ="KEY_REMEMBER_TYPE"
        fun start(context: Context,rememberType:Int = 0) {
            val bundle = Bundle()
            bundle.putInt(KEY_REMEMBER_TYPE,rememberType)
            CommonFragmentActivity.start(context, PokerTrainFragment::class.java.name, bundle)
//            CommonFragmentActivity.start(context, PokerTrainFragment::javaClass.name,null)
        }
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_poker_train
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        numberCount = arguments.getInt(KEY_REMEMBER_TYPE)
        mAdapter.initData()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        toolbarBuilder.showLeft(true)
                .withTitle("扑克训练")
                .showRight(true)
                .withRight(getString(R.string.see_record))
                .show()
        rvPoker.layoutManager = GridLayoutManager(activity, mAdapter.obtainGridSpanCount())
        rvPoker.adapter = mAdapter
        chronTimmer.start()
        btnRestore.setOnClickListener {
            btnFinished.isEnabled = true
            it.isEnabled = false
            mAdapter.switchMode()
        }

        btnFinished.setOnClickListener {
            if (!btnFinished.isSelected) {
                chronTimmer.stop()
                mAdapter.checkResult(chronTimmer)
            }
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (resultCode == Activity.RESULT_CANCELED) {
            return
        }
        if (requestCode == REQUEST_SELECT_POKER) {
            val selectIndex = data?.getIntExtra(Intent.EXTRA_RETURN_RESULT, 0)
            mAdapter.restore(selectIndex!!)
        }
    }

}

data class RememberRecord(val timeStr: String, val time: Long, val rightCount: Int, val totalCount: Int)