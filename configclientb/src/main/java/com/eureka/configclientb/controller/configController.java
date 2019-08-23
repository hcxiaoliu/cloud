package com.eureka.configclientb.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Author: lx
 * Date: 2019/8/23 10:31
 * Content:
 */
@RestController
public class configController {
    @Value("${neo.hello}")
    private String hello;

    @RequestMapping("/hello")
    public String getConfig(){
        System.out.println(hello.toString());
        return this.hello;
    }
}
