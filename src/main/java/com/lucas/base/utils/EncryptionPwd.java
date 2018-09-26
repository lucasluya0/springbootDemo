package com.lucas.base.utils;

import org.apache.shiro.crypto.hash.SimpleHash;
import org.apache.shiro.util.ByteSource;

public class EncryptionPwd {

    public static final int ENCRPTIONTIMES=1024;//加密次数

    public static final String TYPE="MD5";
    /**
     * 通过md5 加密
     * @param pwd
     * @return
     */
    public static String getEncryptionPwdByMd5(String salt,String pwd){
        String hashAlgorithmName = TYPE;
        String credentials = pwd;
        int hashIterations = ENCRPTIONTIMES;
        ByteSource credentialsSalt = ByteSource.Util.bytes(salt);
        Object obj = new SimpleHash(hashAlgorithmName, credentials, credentialsSalt, hashIterations);
        return  obj+"";
    }
}
