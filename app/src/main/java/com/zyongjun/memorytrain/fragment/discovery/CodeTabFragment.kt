package com.zyongjun.memorytrain.fragment.discovery

import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import com.zyongjun.memorytrain.adapter.CodeListAdapter
import kotlinx.android.synthetic.main.fragment_tab_code.*

/**
 * author:gzzyj on 2017/9/12 0012.
 * email:zhyongjun@windhike.cn
 */
class CodeTabFragment() : BaseFragment() {

    companion object {
        val TAG:String = "CodeTabFragment"
    }

    override fun isSubPage(): Boolean {
        return true
    }

    override fun initView() {
        super.initView()
        toolbarBuilder.showLeft(false)
                .showRight(false)
                .withTitle(getString(R.string.title_code_list))
                .show()
    }

    override fun getLayouId(): Int {
        return R.layout.fragment_tab_code
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recyclerView.layoutManager = LinearLayoutManager(activity)
        recyclerView.adapter = CodeListAdapter()
    }
}