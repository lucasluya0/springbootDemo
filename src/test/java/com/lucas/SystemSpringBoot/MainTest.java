package com.lucas.SystemSpringBoot;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

import java.util.UUID;

public class MainTest {
    public static void main(String[] args) {
//        String uuidStr=UUID.randomUUID().toString().replaceAll("-","");
//        System.out.println(uuidStr);
        String hashAlgorithmName = "MD5";
        String credentials = "123456";
        int hashIterations = 1024;
        ByteSource credentialsSalt = ByteSource.Util.bytes("user");
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        System.out.println(obj);
    }

}
