package com.zyongjun.memorytrain.fragment.train

import android.content.Context
import android.os.Bundle
import android.view.View
import com.windhike.fastcoding.CommonFragmentActivity
import com.windhike.fastcoding.base.BaseFragment
import com.zyongjun.memorytrain.R
import kotlinx.android.synthetic.main.fragment_number_time_mode.*

class CodeTrainTimeModeFragment:BaseFragment(){
    companion object {
        fun start(context: Context) {
            val bundle = Bundle()
            CommonFragmentActivity.start(context,CodeTrainTimeModeFragment::class.java.name,bundle)
        }
    }
    override fun getLayouId(): Int {
       return R.layout.fragment_number_time_mode
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        tvSix.setOnClickListener{
            navigateToTimeTrainPage(60)
        }
        tvFive.setOnClickListener{
            navigateToTimeTrainPage(50)
        }
        tvFour.setOnClickListener{
            navigateToTimeTrainPage(40)
        }
    }

    fun navigateToTimeTrainPage(time: Int) {
        NumberTimeTrainFragment.start(activity,time)
    }

}