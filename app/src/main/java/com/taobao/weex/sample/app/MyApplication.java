package com.taobao.weex.sample.app;

import android.app.Application;
import com.taobao.weex.WXSDKEngine;

/**
 * Created by sospartan on 6/7/16.
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        WXSDKEngine.init(this,null,null,new MyImageAdapter(),null);//设置自定义的adadpter实现图片显示、http请求等能力
    }
}
