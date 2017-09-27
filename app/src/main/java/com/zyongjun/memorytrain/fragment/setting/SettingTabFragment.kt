package com.zyongjun.memorytrain.fragment.setting

import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R

/**
 * author:gzzyj on 2017/9/12 0012.
 * email:zhyongjun@windhike.cn
 */
class SettingTabFragment() : BaseFragment() {

    companion object {
        val TAG:String = "SettingTabFragment"
    }

    override fun isSubPage(): Boolean {
        return true
    }

    override fun initView() {
        super.initView()
        toolbarBuilder.showLeft(false)
                .showRight(false)
                .withTitle(getString(R.string.title_setting))
                .show()
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_tab_setting
    }

}