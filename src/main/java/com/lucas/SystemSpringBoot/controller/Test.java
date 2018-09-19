package com.lucas.SystemSpringBoot.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.lucas.SystemSpringBoot.entity.User;
import com.lucas.SystemSpringBoot.extra.HelloService;
import com.lucas.SystemSpringBoot.mapper.UserMapper;
import com.lucas.base.constants.ResponseCode;
import com.lucas.base.constants.ReturnType;
import com.lucas.base.utils.ResponseMsg;
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

@RestController
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
}
