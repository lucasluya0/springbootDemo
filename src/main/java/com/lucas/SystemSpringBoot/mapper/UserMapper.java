package com.lucas.SystemSpringBoot.mapper;

import com.lucas.SystemSpringBoot.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author lucas
 */
@Component
public interface UserMapper {
    /**
     * 查询所有
     *
     * @return
     */
    public List<User> queryAll();
}
