package com.lucas.SystemSpringBoot.shiro;

import com.lucas.SystemSpringBoot.entity.RoleDetails;
import com.lucas.SystemSpringBoot.entity.User;
import com.lucas.SystemSpringBoot.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.Permission;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

public class ShiroRealm extends AuthorizingRealm {
    private Logger logger =  LoggerFactory.getLogger(this.getClass());
    @Autowired
    private UserMapper userMapper;

    //为用户授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        logger.info("doGetAuthorizationInfo+"+principalCollection.toString());
        User user = userMapper.getByUserName((String) principalCollection.getPrimaryPrincipal());


        //把principals放session中 key=userId value=principals
        SecurityUtils.getSubject().getSession().setAttribute(String.valueOf(user.getId()),SecurityUtils.getSubject().getPrincipals());

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
        //赋予角色
        for(RoleDetails userRole:user.getRoles()){
            info.addRole(userRole.getRoleName());
        }
//        //赋予权限
//        for(Permission permission:permissionService.getByUserId(user.getId())){
//            if(StringUtils.isNotBlank(permission.getPermCode()))
//            info.addStringPermission(permission.getName());
//        }

        //设置登录次数、时间
//        userMapper.updateUserLogin(user);
        return info;
    }

    //认证登录
    @Override
       protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        logger.info("doGetAuthenticationInfo +"  + authenticationToken.toString());

        UsernamePasswordToken token = (UsernamePasswordToken) authenticationToken;
        String userName=token.getUsername();
        logger.info(userName+token.getPassword());

        User user = userMapper.getByUserName(token.getUsername());
        String realname=getName();
        ByteSource bs=ByteSource.Util.bytes(user.getId());
        AuthenticationInfo authcInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                bs, realname);
        return authcInfo;

    }
}
