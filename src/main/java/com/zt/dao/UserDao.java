package com.zt.dao;

import com.zt.domain.User;

import java.io.IOException;

/**
 * Created by zt on 2017/7/4.
 */
public interface UserDao {
    void add(User user) throws IOException;

    User find(String username, String password);

    //查找该用户是否注册
    boolean find(String username);
}
