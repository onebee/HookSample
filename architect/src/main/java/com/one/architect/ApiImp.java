package com.one.architect;

import com.one.architect.bean.UserInfo;

/**
 * @author diaokaibin@gmail.com on 2020/3/9.
 */
public class ApiImp implements Api {
    @Override
    public UserInfo create() {
        UserInfo info = new UserInfo();
        return info;
    }
}
