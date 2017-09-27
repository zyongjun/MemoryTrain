package com.zyongjun.memorytrain;

import android.app.Application;
import com.umeng.analytics.MobclickAgent;
import com.windhike.fastcoding.BaseApplication;
//import com.facebook.stetho.Stetho;

/**
 * author: zyongjun on 2017/6/30 0030.
 * email: zhyongjun@windhike.cn
 */
public class TrainApplication extends BaseApplication {
    private static TrainApplication INSTANCE;
    public static TrainApplication getInstance(){
        return INSTANCE;
    }


    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
//        Stetho.initializeWithDefaults(this);
        configUmeng();
        registerWX(this);
    }
    private void registerWX(Application context) {
//        final IWXAPI api = WXAPIFactory.createWXAPI(context, null);
//        api.registerApp(getString(R.string.wx_appid));
    }

    private void configUmeng() {
//        MobclickAgent.setDebugMode( true );
//        String channel =  "test";;
//        MobclickAgent.UMAnalyticsConfig config = new MobclickAgent.UMAnalyticsConfig(this,
//                "5966e53caed1793fed000288",channel,
//                 MobclickAgent.EScenarioType.E_UM_ANALYTICS_OEM,true);
//
//        MobclickAgent. startWithConfigure(config);
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
    }
}
