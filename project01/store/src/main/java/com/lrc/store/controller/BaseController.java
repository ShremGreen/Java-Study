package com.lrc.store.controller;

import com.lrc.store.service.ex.*;
import com.lrc.store.util.JsonResult;
import org.springframework.web.bind.annotation.ExceptionHandler;

//控制层类的基类
public class BaseController {
    //操作成功状态码
    public static final int FINISH = 200;

    //请求处理方法，这个方法返回值就是需要传递给前端的数据
    /*用于统一处理抛出的异常
    @ExceptionHandler自动将异常对象传递给此方法的参数列表
    若项目产生异常，会被直接拦截到此方法中，该方法作为请求处理方法，返回值直接给到前端
    */
    @ExceptionHandler(ServiceException.class)
    public JsonResult<Void> handleException(Throwable e) {
        JsonResult<Void> result  = new JsonResult<>(e);

        if(e instanceof UsernameDuplicatedException) {
            result.setState(4000);
            result.setMessage("用户名已存在");
        } else if(e instanceof InsertException) {
            result.setState(5000);
            result.setMessage("注册时未知异常");
        } else if(e instanceof UserNotFoundException) {
            result.setState(5001);
            result.setMessage("该用户不存在");
        } else if(e instanceof PasswordNotMatchException) {
            result.setState(5002);
            result.setMessage("密码错误");
        }
        return result;
    }
}
