package com.lrc.store.mapper;

import com.lrc.store.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

//测试User
@SpringBootTest//标注当前类是测试类，不会随项目一同打包
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;//直接创建后会报错，因为接口是不能直接创建bean的。然而这里使用了mybatis动态代理，解决了这一问题，报错可设置解决。

    /*
     * 单元测试方法：可以单独独立运行，不用启动整个项目，做单元测试。
     * 1.必须被@Test修饰
     * 2.返回值类型必须是void
     * 3.参数列表为空
     * 4.访问修饰符必须是public
     * */

    @Test
    public void insert() {
        User user = new User();
        user.setUsername("Dr.White");
        user.setPassword("dr.white");
        Integer insert = userMapper.insert(user);
        System.out.println(insert);
    }

    @Test
    public void findByUsername() {
        User cow = userMapper.findByUsername("Dr.White");
        System.out.println(cow);
    }
}
