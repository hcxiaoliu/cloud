package com.eureka.consumer.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Author: lx
 * Date: 2019/8/22 11:34
 * Content: service-provider 是服务提供者的名称  FeignserviceImpl是callback的降级之后调用的实现类
 */
@FeignClient(value = "service-provider", fallback = FeignserviceImpl.class)
public interface Feignservice {
    /**
     * @param id
     * @return RequestParam
     * PathVariable 如果使用这个注解 那么你的路径是  /getUser/{id}
     * 这里的参数有多少个就要打多少个注解
     * ps：我现在增加一个参数 name 那么也需要 @RequestParam("name") name
     * 如果不加注解 则会被忽略
     */
    @RequestMapping("/getUser")
    Map<String, Object> getUser(@RequestParam("id") Integer id);
}
