package com.one.architect.thing;

import android.graphics.Bitmap;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public interface MemoryCache {
    // 从内存中寻找缓存图片
    Bitmap findByMemory(String url);



}
