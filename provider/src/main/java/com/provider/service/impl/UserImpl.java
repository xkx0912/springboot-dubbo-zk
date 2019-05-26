package com.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.domain.User;
import com.common.service.UserService;
import com.provider.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by xkx on 2019/5/12.
 */
@Service(version = "1.0.0")
class UserImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    protected UserMapper userMapper;

    @Override
    public List<User> findUser() {
        System.out.println("服务端访问成功！");
        //return userMapper.listAll();
        return userMapper.selectList(null);
    }
}
