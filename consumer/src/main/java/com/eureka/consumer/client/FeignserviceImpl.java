package com.eureka.consumer.client;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: lx
 * Date: 2019/8/22 12:48
 * Content: 如果远程接口调用失败才会调用此方法
 *
 * 这一点与阿里Dubbo中暴露远程服务的方式类似，区别在于Dubbo是基于私有二进制协议几rpc，
 * 而Feign本质上还是个HTTP客户端。也就是restful风格
 * http rpc 的区别
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
