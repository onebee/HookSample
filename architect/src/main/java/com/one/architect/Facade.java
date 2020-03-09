package com.one.architect;

import com.one.architect.impl.DisCacheImpl;
import com.one.architect.impl.MemoryCacheImpl;
import com.one.architect.impl.NetWordLoaderImpl;
import com.one.architect.thing.DiskCache;
import com.one.architect.thing.MemoryCache;
import com.one.architect.thing.NetWorkLoader;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public class Facade {
    private String url;
    private MemoryCache mMemoryCache;
    private DiskCache mDiskCache;
    private NetWorkLoader mNetWorkLoader;


    public Facade(String url) {
        this.url = url;
        mMemoryCache = new MemoryCacheImpl();
        mDiskCache = new DisCacheImpl();
        mNetWorkLoader = new NetWordLoaderImpl();
    }

    void loader() {
        mMemoryCache.findByMemory(url);
        mDiskCache.findByDisk(url);
        mNetWorkLoader.loaderImageFromNet(url);
    }
}
