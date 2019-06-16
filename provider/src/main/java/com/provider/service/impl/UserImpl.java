package com.provider.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.common.domain.User;
import com.common.service.UserService;
import com.provider.mapper.UserMapper;
import com.provider.util.RedisUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xkx on 2019/5/12.
 */
@Service(version = "1.0.0")
class UserImpl extends ServiceImpl<UserMapper,User> implements UserService {
    @Autowired
    protected UserMapper userMapper;

    @Override
    @Cacheable(value = "findAll")
    public List<User> findUser() {
        System.out.println("服务端访问成功！");
        List<User> users = new ArrayList<User>();
        System.out.println("查询数据库...");
        users = userMapper.selectList(null);
        return users;
    }
}
