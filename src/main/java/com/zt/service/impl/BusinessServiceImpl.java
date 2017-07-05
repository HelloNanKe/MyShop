package com.zt.service.impl;

import com.zt.Exception.UserExistExcetion;
import com.zt.Utils.ServiceUtils;
import com.zt.dao.UserDao;
import com.zt.dao.impl.UserDaoImpl;
import com.zt.domain.User;

import java.io.IOException;

/**
 * Created by zt on 2017/7/4.
 */
//对web层提供所有的服务
public class BusinessServiceImpl {

    private UserDao userDao=new UserDaoImpl();
    //用户注册
    public void register(User user) throws UserExistExcetion, IOException {
        //判断当前要注册的用户是否存在
     boolean b=   userDao.find(user.getUsername());

           if(b){
                throw new UserExistExcetion();//要注册的用户已经存在，给web层抛出一个编译时异常
           }else{
               user.setPassword(ServiceUtils.md5(user.getPassword()));
                userDao.add(user);
           }

    }
    //用户登录
    public User login(String username,String password){

        password=ServiceUtils.md5(password);
       return userDao.find(username,password);
    }
}
