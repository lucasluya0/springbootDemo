package com.lucas.SystemSpringBoot;

import java.util.UUID;

public class MainTest {
    public static void main(String[] args) {
        String uuidStr=UUID.randomUUID().toString().replaceAll("-","");
        System.out.println(uuidStr);
    }

}
