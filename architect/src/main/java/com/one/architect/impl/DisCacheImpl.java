package com.one.architect.impl;

import android.graphics.Bitmap;

import com.one.architect.thing.DiskCache;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public class DisCacheImpl implements DiskCache {
    @Override
    public Bitmap findByDisk(String url) {
        System.out.println("通过图片url ,寻找磁盘中缓存图片");

        return null;
    }
}
