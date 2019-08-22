package com.eureka.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Author: lx
 * Date: 2019/8/22 11:34
 * Content:
 */
@FeignClient(value = "service-provider",fallback = FeignserviceImpl.class)
public interface Feignservice {

    @RequestMapping("/getUser")
     Map<String, Object> getUser(@RequestParam("id") Integer id);
}
