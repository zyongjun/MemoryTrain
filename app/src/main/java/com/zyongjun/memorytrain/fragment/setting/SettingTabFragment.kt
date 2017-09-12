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
    override fun getLayouId(): Int {
        return R.layout.fragment_content
    }

}