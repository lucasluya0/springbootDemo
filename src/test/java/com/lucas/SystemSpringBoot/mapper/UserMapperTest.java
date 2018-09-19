package com.lucas.SystemSpringBoot.mapper;

import com.lucas.SystemSpringBoot.SystemSpringBootApplication;
import com.lucas.SystemSpringBoot.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = SystemSpringBootApplication.class)
public class UserMapperTest {

    @Autowired
    private  UserMapper userMapper;

    @Test
    public void queryAllTest(){
        List<User> userlist=userMapper.queryAll();
        for (User user:userlist){
            System.out.println(user.getHead());
        }
    }
}
