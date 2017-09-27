package com.windhike.fastcoding.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import butterknife.ButterKnife;
import butterknife.Unbinder;

/**
 * author:gzzyj on 2017/7/14 0014.
 * email:zhyongjun@windhike.cn
 */

public abstract class BaseFragment extends Fragment{
    protected View mRootView;
    private Unbinder unbinder;
    private ToolbarBuilder mToolbarBuilder;

    public String getTransactionTag() {
        return getClass().getSimpleName();
    }

    public ToolbarBuilder getToolbarBuilder() {
        return mToolbarBuilder;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mRootView == null) {
            mRootView = inflater.inflate(getLayouId(),container,false);
            unbinder = ButterKnife.bind(this, mRootView);
            mToolbarBuilder = new ToolbarBuilder((ViewGroup) mRootView);
            mToolbarBuilder.withLeftClick(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onBackPressed();
                }
            });
            initView();
        }else if(!isSubPage()){
            ViewGroup parent = (ViewGroup) mRootView.getParent();
            parent.removeAllViews();
        }
        return mRootView;
    }



    protected boolean isSubPage() {
        return false;
    }

    public void initView() {

    }

    public abstract int getLayouId();

    public boolean onBackPressed() {
        if (getActivity() != null) {
            getActivity().finish();
            return true;
        }
        return false;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
    }
}
