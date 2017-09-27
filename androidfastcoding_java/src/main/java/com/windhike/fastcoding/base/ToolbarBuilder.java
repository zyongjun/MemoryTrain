package com.windhike.fastcoding.base;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.windhike.fastcoding.R;


/**
 * author:gzzyj on 2017/8/24 0024.
 * email:zhyongjun@windhike.cn
 */
public class ToolbarBuilder {
    private ViewGroup mRootView;
    private boolean mIsLeftVisible,mIsRightVisible;
    private String mTitle,mRightText;
    private View mBackView;
    private TextView mTvTitle,mTvRight;
    private View.OnClickListener mLeftClickListener,mRightClickListener;

    public ToolbarBuilder(ViewGroup viewGroup) {
        mRootView = viewGroup;
    }

    public ToolbarBuilder showLeft(boolean isVisible) {
        mIsLeftVisible = isVisible;
        return this;
    }

    public ToolbarBuilder withLeftClick(View.OnClickListener leftClick) {
        mLeftClickListener = leftClick;
        return this;
    }

    public ToolbarBuilder withTitle(String title) {
        mTitle = title;
        return this;
    }

    public ToolbarBuilder showRight(boolean isRightVisible) {
        mIsRightVisible = isRightVisible;
        return this;
    }

    public ToolbarBuilder withRight(String rightText){
        mRightText = rightText;
        return this;
    }

    public ToolbarBuilder withRightClick(View.OnClickListener rightClick) {
        mRightClickListener = rightClick;
        return this;
    }

    public void show() {
        if (mRootView == null) {
            return;
        }
        mBackView = mRootView.findViewById(R.id.ll_back);
        mTvTitle = (TextView) mRootView.findViewById(R.id.title);
        mTvRight = (TextView)mRootView.findViewById(R.id.tvRight);
        if (mTitle != null) {
            mTvTitle.setText(mTitle);
        }
        mBackView.setVisibility(mIsLeftVisible?View.VISIBLE:View.GONE);
        if (mIsLeftVisible&&mLeftClickListener!=null) {
            mBackView.setOnClickListener(mLeftClickListener);
        }
        mTvRight.setVisibility(mIsRightVisible?View.VISIBLE:View.GONE);
        if (mIsRightVisible && mRightText != null) {
            mTvRight.setText(mRightText);
            if (mRightClickListener != null) {
                mTvRight.setOnClickListener(mRightClickListener);
            }
        }
    }
}
