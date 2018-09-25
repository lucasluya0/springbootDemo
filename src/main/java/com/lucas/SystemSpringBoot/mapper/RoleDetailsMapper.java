package com.lucas.SystemSpringBoot.mapper;

import com.lucas.SystemSpringBoot.entity.RoleDetails;
import com.lucas.SystemSpringBoot.entity.User;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

/**
 * @author lucas
 */
@Component
public interface RoleDetailsMapper {

    List<RoleDetails > getByMap(Map<String, Object> map);
    RoleDetails  getById(Integer id);
    Integer create(RoleDetails  role);
    int update(RoleDetails  role);
    int delete(Integer id);
}
