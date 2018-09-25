package com.lucas.SystemSpringBoot.mapper;

import com.lucas.SystemSpringBoot.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

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

    List<User> getByMap(Map<String, Object> map);

    User getById(Integer id);

    Integer create(User user);

    int update(User user);

    int delete(Integer id);

    User getByUserName(String userName);
}
