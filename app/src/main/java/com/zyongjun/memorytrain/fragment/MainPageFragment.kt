package com.zyongjun.memorytrain.fragment

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.fragment.discovery.DiscoveryTabFragment
import com.zyongjun.memorytrain.fragment.history.HistoryTabFragment
import com.zyongjun.memorytrain.fragment.setting.SettingTabFragment
import com.zyongjun.memorytrain.fragment.train.TrainTabFragment
import kotlinx.android.synthetic.main.fragment_main.*
//import kotlinx.android.synthetic.main.tab_button.*

/**
 * author:gzzyj on 2017/9/12 0012.
 * email:zhyongjun@windhike.cn
 */
data class TabInfo(val tabTextResourceId: Int, val tabIconResourceId: Int, val tabTag: String, val baseTabFragment: Class<out Fragment>)

class MainPageFragment():BaseFragment(){

    companion object {
        val mTabInfos = arrayOf<TabInfo>(TabInfo(R.string.tab_train, R.drawable.selector_tab_home, TrainTabFragment.TAG, TrainTabFragment::class.java),
                TabInfo(R.string.tab_history, R.drawable.selector_tab_category, HistoryTabFragment.TAG, HistoryTabFragment::class.java),
                TabInfo(R.string.tab_discovery, R.drawable.selector_tab_cart, DiscoveryTabFragment.TAG, DiscoveryTabFragment::class.java),
                TabInfo(R.string.tab_edit, R.drawable.selector_tab_personal, SettingTabFragment.TAG, SettingTabFragment::class.java))
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tabhost.setup(context,childFragmentManager,R.id.realtabcontent)
        val tabLength = mTabInfos.size-1
        val inflater = LayoutInflater.from(context)
        for(i in 0..tabLength){
            val view = inflater.inflate(R.layout.tab_button,tabhost.tabWidget,false)
            val tabInfo:TabInfo = mTabInfos[i]
            (view.findViewById(R.id.tab_icon) as ImageView).setImageResource(tabInfo.tabIconResourceId)
            (view.findViewById(R.id.tab_text) as TextView).setText(tabInfo.tabTextResourceId)
            tabhost.addTab(tabhost.newTabSpec(tabInfo.tabTag).setIndicator(view),tabInfo.baseTabFragment,null)
        }
    }

    override fun initView() {
        super.initView()

    }

    override fun getLayouId(): Int {
        return R.layout.fragment_main;
    }
}