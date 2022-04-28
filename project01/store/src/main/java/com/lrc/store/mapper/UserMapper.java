package com.lrc.store.mapper;

import com.lrc.store.entity.User;

//用户模块的持久化模型
public interface UserMapper {
    /**
     * 插入用户注册信息
     * @param user 用户
     * @return 受影响的行数
     */
    Integer insert(User user);

    /**
     * 根据用户名查询用户信息
     * @param username 用户名
     * @return 查询到则返回用户信息，没查到则放回null
     */
    User findByUsername(String username);
}
