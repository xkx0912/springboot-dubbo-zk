package com.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.common.domain.User;
import com.common.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * Created by xkx on 2019/5/12.
 */
@RequestMapping("/user")
@RestController
public class UserController {
    @Resource
    @Reference(version = "/1.0.0")
    private UserService userService;

    @ApiOperation(value="用户列表", notes="用户列表")
    @GetMapping("/list")
    public List<User> user(){
        System.out.println("消费端访问成功");
        return userService.findUser();
    }
}
