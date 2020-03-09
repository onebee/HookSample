package com.one.architect.factory;

import com.one.architect.Api;
import com.one.architect.ApiImp;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public class SampleFactory {

    public static Api createApi() {
        return new ApiImp();
    }

}
