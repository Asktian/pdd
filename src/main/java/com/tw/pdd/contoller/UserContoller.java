package com.tw.pdd.contoller;

import com.tw.pdd.pojo.User;
import com.tw.pdd.service.UserService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@Api(tags = "用户模块")
@RestController
public class UserContoller {
    @Autowired
    private UserService userService;

    @ApiOperation(value = "获取验证码", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "电话号码(11位)", paramType = "query")
    })
    @RequestMapping("/getCode")
    public String getCode(String mobile) {
        String code = userService.getCode(mobile);
        return code;
    }

    @ApiOperation(value = "用户登录", httpMethod = "GET")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "userPhone", value = "电话号码(11位)", paramType = "query")
    })
    @RequestMapping("/login")
    public User login(@ApiIgnore User user){
        User user1 = userService.login(user);
        return user1;
    }


    @ApiOperation(value = "更新用户个人信息", httpMethod = "POST")
    @RequestMapping("/updateUser")
    public User updateUser(@RequestBody @ApiParam(name = "更新用户信息", value = "用时沟通") User user){
        User user1 = userService.updateUser(user);
        System.out.println(user1);
        return user1;
    }
}
