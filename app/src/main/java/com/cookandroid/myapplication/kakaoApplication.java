package com.cookandroid.myapplication;

import android.app.Application;

import com.kakao.sdk.common.KakaoSdk;

public class kakaoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        KakaoSdk.init(this,"63f0cbae7322c2ade3938e1ef162f9bd");
    }
}