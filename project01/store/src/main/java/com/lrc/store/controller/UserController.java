package com.lrc.store.controller;

import com.lrc.store.entity.User;
import com.lrc.store.service.IUserService;
import com.lrc.store.util.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
/*@RestController = @Controller + @ResponseBody，
@ResponseBody：表示此方法响应结果以json格式进行数据响应给前端*/
@RequestMapping("StoreUsers")//将请求和处理请求的控制器方法关联起来，建立映射关系。
public class UserController extends BaseController {
    @Autowired
    private IUserService userService;

    @RequestMapping("reg")
    public JsonResult<Void> reg(User user) {
        userService.reg(user);
        return new JsonResult<Void>(FINISH);
    }

    @RequestMapping("login")
    public JsonResult<User> login(String username,String password) {
        User data = userService.login(username, password);
        return new JsonResult<User>(FINISH, data);
    }
}
