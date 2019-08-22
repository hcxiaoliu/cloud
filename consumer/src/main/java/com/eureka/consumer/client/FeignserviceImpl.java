package com.eureka.consumer.client;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lx
 * Date: 2019/8/22 12:48
 * Content:
 */
@Component
public class FeignserviceImpl implements Feignservice  {
    @Override
    public Map<String, Object> getUser(Integer id) {
        Map<String, Object> data = new HashMap<>();
        data.put("id", id);
        data.put("feign", "callback本地");

        return data;
    }
}
