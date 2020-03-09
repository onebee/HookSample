package com.one.architect.impl;

import android.graphics.Bitmap;

import com.one.architect.thing.MemoryCache;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public class MemoryCacheImpl implements MemoryCache {


    @Override
    public Bitmap findByMemory(String url) {
        System.out.println("通过图片url ,寻找内存中缓存图片");
        return null;
    }
}
