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
import com.zyongjun.memorytrain.adapter.Poker
import com.zyongjun.memorytrain.adapter.PokerSelectAdapter
import kotlinx.android.synthetic.main.fragment_poker_select.*

/**
 * author:gzzyj on 2017/9/14 0014.
 * email:zhyongjun@windhike.cn
 */
class PokerSelectFragment : BaseFragment() {
    val mAdapter: PokerSelectAdapter  by lazy{
        PokerSelectAdapter(mPokerList)
    }
    companion object {
        val KEY_REMEMBER_TYPE ="KEY_REMEMBER_TYPE"
        fun obtainStartIntent(context:Context,rememberType:Int = 0):Intent{
            val bundle = Bundle()
            bundle.putInt(KEY_REMEMBER_TYPE,rememberType)
            val intent = CommonFragmentActivity.obtainStartIntent(context,PokerSelectFragment::class.java.name,bundle)
            return intent
        }
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_poker_select
    }

    val mPokerList = arrayListOf<Poker>()
    fun initPokers() {
        mPokerList.clear()
        val attr = resources.obtainTypedArray(R.array.poker_img)
        val endIndex = attr.length()-1
        for (i in 0..endIndex) {
            val drawablePoker:Int = attr.getResourceId(i, 0)
            val poker: Poker = Poker(drawablePoker)
            mPokerList.add(poker)
        }
        attr.recycle()
    }

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        initPokers()
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        rvPokerSelect.layoutManager = GridLayoutManager(activity,4)
        rvPokerSelect.adapter = mAdapter
        btnSelect.setOnClickListener {
                val intent = Intent()
                intent.putExtra(Intent.EXTRA_RETURN_RESULT,mAdapter.selectIndex)
                activity.setResult(Activity.RESULT_OK,intent)
                activity.finish()
            }
    }

}