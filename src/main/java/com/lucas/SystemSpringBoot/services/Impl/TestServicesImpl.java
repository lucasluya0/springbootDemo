package com.lucas.SystemSpringBoot.services.Impl;

import com.lucas.SystemSpringBoot.entity.User;
import com.lucas.SystemSpringBoot.mapper.UserMapper;
import com.lucas.SystemSpringBoot.services.TestServices;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TestServicesImpl implements TestServices {
    @Autowired
    UserMapper userMapper;
    @Override
    public List<User> queryAll() {
        return  userMapper.queryAll();
    }
}
