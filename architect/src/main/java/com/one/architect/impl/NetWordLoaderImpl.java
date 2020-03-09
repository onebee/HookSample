package com.one.architect.impl;

import com.one.architect.thing.NetWorkLoader;

import java.io.InputStream;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public class NetWordLoaderImpl implements NetWorkLoader {
    @Override
    public InputStream loaderImageFromNet(String url) {
        System.out.println("通过图片url ,从网络里加载图片");

        return null;
    }
}
