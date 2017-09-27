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
import com.zyongjun.memorytrain.adapter.NumberSelectAdapter
import kotlinx.android.synthetic.main.fragment_poker_select.*

/**
 * author:gzzyj on 2017/9/14 0014.
 * email:zhyongjun@windhike.cn
 */
class NumberSelectFragment : BaseFragment() {
    var cardType = 0
    val mAdapter: NumberSelectAdapter  by lazy{
        NumberSelectAdapter()
    }
    companion object {
        val KEY_REMEMBER_TYPE ="KEY_REMEMBER_TYPE"
        fun obtainStartIntent(context: Context): Intent {
            val bundle = Bundle()
            return CommonFragmentActivity.obtainStartIntent(context, NumberSelectFragment::class.java.name, bundle)
        }
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_poker_select
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        cardType = arguments.getInt(KEY_REMEMBER_TYPE)
        mAdapter.initData()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPokerSelect.layoutManager = GridLayoutManager(activity, 4)
        rvPokerSelect.adapter = mAdapter
        btnSelect.setOnClickListener {
                val intent = Intent()
                intent.putExtra(Intent.EXTRA_RETURN_RESULT,mAdapter.selectItem)
                activity.setResult(Activity.RESULT_OK,intent)
                activity.finish()
            }
    }

}