package com.one.architect.thing;


import android.graphics.Bitmap;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public interface DiskCache {

    // 内存中没有找到,从本地文件中寻找缓存图片
    Bitmap findByDisk(String url);
}
