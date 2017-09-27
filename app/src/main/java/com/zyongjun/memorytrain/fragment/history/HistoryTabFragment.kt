package com.zyongjun.memorytrain.fragment.history

import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R

/**
 * author:gzzyj on 2017/9/12 0012.
 * email:zhyongjun@windhike.cn
 */
class HistoryTabFragment() : BaseFragment() {
    companion object {
        val TAG:String = "HistoryTabFragment"
    }

    override fun isSubPage(): Boolean {
        return true;
    }

    override fun initView() {
        super.initView()
        toolbarBuilder.showLeft(false)
                .showRight(false)
                .withTitle(getString(R.string.title_history))
                .show()
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_tab_history
    }

}