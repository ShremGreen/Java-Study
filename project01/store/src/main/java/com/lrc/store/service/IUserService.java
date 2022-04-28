package com.lrc.store.service;

import com.lrc.store.entity.User;

//用户模块 业务层 接口
//方便解耦
public interface IUserService {
    /***
     * 用户注册方法
     * @param user 用户数据类型
     */
    void reg(User user);

    /**
     * 用户登录方法
     * @param username 用户名
     * @param password 密码
     * @return 返回用户信息，没有则为null
     */
    User login(String username, String password);
}
