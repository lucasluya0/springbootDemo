package com.lucas.SystemSpringBoot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucas.SystemSpringBoot.entity.User;
import com.lucas.SystemSpringBoot.extra.HelloService;
import com.lucas.SystemSpringBoot.mapper.UserMapper;
import com.lucas.base.constants.ResponseCode;
import com.lucas.base.constants.ReturnType;
import com.lucas.base.utils.EncryptionPwd;
import com.lucas.base.utils.ResponseMsg;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Controller
public class Test {
    private static final Logger logger = LoggerFactory.getLogger(Test.class);
    @Autowired
    private HelloService helloService;
    @Autowired
    private UserMapper userMapper;
    @RequestMapping("/demo")
    @ResponseBody
    public JSON getData(@RequestParam(value = "str",required = false) String str){
        logger.info("这个是{}",str);
        List<User> userlist=userMapper.queryAll();
        JSON json=new JSONObject();
        ((JSONObject) json).put("status","error");
        return json;
    }
    @GetMapping("/index")
    public String index(@RequestParam(value = "str",required = false) String str){
        return "index";
    }
    @RequestMapping("/download")
    public ResponseEntity<FileSystemResource> download(){
        logger.info("执行中");
        File file=new File("J:\\武汉市421202咸安区.xls");
        if (file == null) {
            return null;
        }
        HttpHeaders headers = new HttpHeaders();
        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
        headers.add("Content-Disposition", "attachment; filename=" + System.currentTimeMillis() + ".xls");
        headers.add("Pragma", "no-cache");
        headers.add("Expires", "0");
        headers.add("Last-Modified", new Date().toString());
        headers.add("ETag", String.valueOf(System.currentTimeMillis()));
        ResponseEntity<FileSystemResource> tempSource=ResponseEntity
                .ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/octet-stream"))
                .body(new FileSystemResource(file));
        return  tempSource;
    }
    @PostMapping("/testAop")
    @ResponseBody
    public String testAop(){
//        ResponseMsg rm=new ResponseMsg();
//        rm.setCode(ResponseCode.SUCCESS_CODE);
//        rm.setHintInformation("返回视图");
//        rm.setReturnType(ReturnType.VIEWS);
//        rm.addData("url","index");
        return "ok";
    }
    @RequestMapping("/testException")
    @ResponseBody
    public String testException(){
        User user=null;
        String head=user.getHead();
        return "head";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    @ResponseBody
    public String login(
            @RequestParam(value = "username", required = true) String userName,
            @RequestParam(value = "password", required = true) String password,
            @RequestParam(value = "rememberMe", required = false, defaultValue = "false") boolean rememberMe
    ) {
        logger.info("==========" + userName + password + rememberMe);
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName, password);
        token.setRememberMe(rememberMe);
        try {
            subject.login(token);
        } catch (AuthenticationException e) {
            e.printStackTrace();
//            rediect.addFlashAttribute("errorText", "您的账号或密码输入错误!");
            return "{\"Msg\":\"您的账号或密码输入错误\",\"state\":\"failed\"}";
        }
        return "{\"Msg\":\"登陆成功\",\"state\":\"success\"}";
    }
    @RequestMapping(value = "/user/test")
    public String redirectTestShiro(){
        logger.info("==========" + "进入测试");

        return "test";
    }
    @RequestMapping("/addUser")
    @ResponseBody
    public String CreateUser(@RequestParam(value = "username",required = false) String username,@RequestParam(value = "pwd",required = false)String  pwd ){

        User user=new User();
        String uuid=UUID.randomUUID().toString().replaceAll("-","");
        user.setId(uuid);
        user.setName(username);
        String password=EncryptionPwd.getEncryptionPwdByMd5(uuid,pwd);
        user.setPassword(password);
        userMapper.create(user);
        return "{\"Msg\":\"登陆成功\",\"state\":\"success\"}";
    }
    @RequestMapping("/loginout")
    @ResponseBody
    public String loginoutUser(){
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
        return "{\"Msg\":\"退出成功\",\"state\":\"success\"}";
    }
}
