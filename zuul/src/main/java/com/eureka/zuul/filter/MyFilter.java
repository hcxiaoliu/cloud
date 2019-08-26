package com.eureka.zuul.filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import io.micrometer.core.instrument.util.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;


/**
 * Author: lx
 * Date: 2019/8/26 15:27
 * Content:
 */
public class MyFilter extends ZuulFilter {

    private final Logger logger = LoggerFactory.getLogger(MyFilter.class);

    @Override
    public String filterType() { //定义filter的类型，有pre、route、post、error四种
        return "pre";
    }

    @Override
    public int filterOrder() { //定义filter的顺序，数字越小表示顺序越高，越先执行
        return 10;
    }

    @Override
    public boolean shouldFilter() { //表示是否需要执行该filter，true表示执行，false表示不执行
        return true;
    }

    @Override
    public Object run() throws ZuulException { //filter需要执行的具体操作
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        logger.info("--->>> TokenFilter {},{}", request.getMethod(), request.getRequestURL().toString());

        // 获取请求的参数
        String token = request.getParameter("token");

        if (StringUtils.isNotBlank(token)) {
            //对请求进行路由
            ctx.setSendZuulResponse(true);
            ctx.setResponseStatusCode(200);
            ctx.set("isSuccess", true);
            return null;
        } else {
            //不对其进行路由
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(400);
            ctx.setResponseBody("token is empty");
            ctx.set("isSuccess", false);
            return null;
        }
    }
}
