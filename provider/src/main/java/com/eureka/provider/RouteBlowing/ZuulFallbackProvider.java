package com.eureka.provider.RouteBlowing;

import org.springframework.http.client.ClientHttpResponse;

/**
 * Author: lx
 * Date: 2019/8/26 15:40
 * Content:
 */
public interface ZuulFallbackProvider {
    /**
     * The route this fallback will be used for.
     * @return The route the fallback will be used for.
     * 通知Zuul它是负责哪个route定义的熔断。
     */
    public String getRoute();



    /**
     * Provides a fallback response.
     * @return The fallback response.
     * 通知 Zuul 断路出现时，它会提供一个什么返回值来处理请求。
     */
    public ClientHttpResponse fallbackResponse();
}
