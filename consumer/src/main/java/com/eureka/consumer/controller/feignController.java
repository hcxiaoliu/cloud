package com.eureka.consumer.controller;

import com.eureka.consumer.client.Feignservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Author: lx
 * Date: 2019/8/22 11:45
 * Content:
 */
@RestController
public class feignController {


    @Autowired
    private Feignservice feignservice;

    @RequestMapping("/feignController")
    public Map<String, Object> getUser(@RequestParam Integer id) {
        return feignservice.getUser(id);
    }

}
