package com.taobao.weex.sample.app;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import com.taobao.weex.IWXRenderListener;
import com.taobao.weex.WXSDKInstance;
import com.taobao.weex.common.WXRenderStrategy;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements IWXRenderListener {
    public static final String TAG = "MainActivity";
    WXSDKInstance mInstance;
    ViewGroup mContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mContainer = (ViewGroup) findViewById(R.id.container);
        mInstance = new WXSDKInstance(this); //create weex instance
        mInstance.registerRenderListener(this); //SimpleRenderListener需要开发者来实现

        //sample直接使用Weex命令转化后的js代码,也可以从文件加载或者从服务端下载的方式
        mInstance.render(TAG,
                "define(\"@weex-component/localtest\",function(t,e,o){o.exports={data:function(){return{img:\"//gw.alicdn.com/tps/i2/TB1DpsmMpXXXXabaXXX20ySQVXX-512-512.png_400x400.jpg\"}}},o.exports.style={title:{fontSize:20,color:\"#0000FF\"},img:{width:200,height:100}},o.exports.template={type:\"scroller\",children:[{type:\"text\",classList:[\"title\"],attr:{value:\"Hello,Weex!\"}},{type:\"image\",classList:[\"img\"],attr:{src:function(){return this.img}}}]}}),bootstrap(\"@weex-component/localtest\",{transformerVersion:\"0.1.8\"});",
                new HashMap<String, Object>(),
                null,
                ScreenUtil.getDisplayWidth(this),
                ScreenUtil.getDisplayHeight(this),
                WXRenderStrategy.APPEND_ASYNC);
    }

    @Override
    public void onStart() {
        super.onStart();
        if (mInstance != null) {
            mInstance.onActivityStart();
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        if (mInstance != null) {
            mInstance.onActivityResume();
        }
    }

    @Override
    public void onPause() {
        super.onPause();
        if (mInstance != null) {
            mInstance.onActivityPause();
        }
    }

    @Override
    public void onStop() {
        super.onStop();
        if (mInstance != null) {
            mInstance.onActivityStop();
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (mInstance != null) {
            mInstance.onActivityDestroy();
        }
    }

    @Override
    public void onViewCreated(WXSDKInstance wxsdkInstance, View view) {
        if (mContainer != null) {
            mContainer.addView(view);
        }
    }

    @Override
    public void onRenderSuccess(WXSDKInstance wxsdkInstance, int i, int i1) {

    }

    @Override
    public void onRefreshSuccess(WXSDKInstance wxsdkInstance, int i, int i1) {

    }

    @Override
    public void onException(WXSDKInstance wxsdkInstance, String s, String s1) {

    }
}
