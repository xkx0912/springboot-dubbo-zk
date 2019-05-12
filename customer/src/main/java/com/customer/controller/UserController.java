package com.customer.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.common.domain.User;
import com.common.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * Created by xkx on 2019/5/12.
 */
@RestController
public class UserController {
    @Resource
    @Reference(version = "1.0.0")
    private UserService userService;

    @GetMapping("getUser")
    public User user(){
        System.out.println("消费端访问成功");
        return userService.findUser();
    }
}
