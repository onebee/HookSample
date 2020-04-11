package com.one.hook;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import androidx.appcompat.app.AppCompatActivity;
import okhttp3.OkHttpClient;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        TextView tv = (TextView) findViewById(R.id.tv);
        tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, ""+ ((TextView)v).getText(), Toast.LENGTH_SHORT).show();

            }
        });

        try {
            hook(tv);
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(this, "hook 失败", Toast.LENGTH_SHORT).show();

        }



//        try {

            OkHttpClient okHttpClient = new OkHttpClient.Builder().build();


//            Response response = okHttpClient.newCall(request).execute();



//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }

    private void hook(View view) throws Exception {



        // 为了
        Class mViewClass = Class.forName("android.view.View");
        Method getListenerInfoMethod = mViewClass.getDeclaredMethod("getListenerInfo");
        getListenerInfoMethod.setAccessible(true);

        Object mListenerInfo = getListenerInfoMethod.invoke(view);


        // 替换 mListenerInfoClass
        Class mListenerInfoClass = Class.forName("android.view.View$ListenerInfo");

        Field mOnClickListenerFiled = mListenerInfoClass.getField("mOnClickListener");

        final Object mOnClickListenerObj = mListenerInfoClass.getField("mOnClickListener").get(mListenerInfo);




//        1. 监听 onClick , 当用户点击按钮的时候 -->onClick  我们自己要先拦截这个事件
        // 动态代理
        // mOnClickListener 本质是 OnClickListener
        Object mOnClickListenerProxy = Proxy.newProxyInstance(
                MainActivity.class.getClassLoader(),   // 1. 加载器
                new Class[]{View.OnClickListener.class}, // 2. 要监听的接口,监听什么接口,就返回什么接口
                new InvocationHandler() {   // 3. 监听接口方法里面的回调
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        // 加入自己的逻辑
                        Log.d("hook", "hook 拦截到了");

                        TextView textView = new TextView(MainActivity.this);

                        textView.setText("我是 hook 钩子方法");

                        // 让系统程序片段 -- 正常执行下去
                        return method.invoke(mOnClickListenerObj,textView);
                    }
                }

        );




        // 替换成 我们自己写的 动态代理
        mOnClickListenerFiled.set(mListenerInfo,mOnClickListenerProxy);


    }
}
