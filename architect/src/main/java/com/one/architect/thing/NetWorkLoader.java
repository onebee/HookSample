package com.one.architect.thing;

import java.io.InputStream;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public interface NetWorkLoader {
    // 本地文件中没有找到,从网络加载
    InputStream loaderImageFromNet(String url);
}
