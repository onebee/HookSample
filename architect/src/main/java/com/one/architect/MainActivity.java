package com.one.architect;

import android.os.Bundle;
import android.util.Log;

import com.one.architect.bean.UserInfo;
import com.one.architect.factory.SampleFactory;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        Api api = new ApiImp();
//
//        api.create();

        // 简单工厂
        Api api = SampleFactory.createApi();

        UserInfo info = api.create();

        Log.d("info :",  info.toString());

        // 拓展 根据参数来产生不同的实现

        // 根据配置文件产生不同的实现

    }
}
