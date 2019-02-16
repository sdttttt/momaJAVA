package com.moma.filter;

import com.moma.power.PowerEnum;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OnlySonCall implements Filter {

    @Resource
    RedisTemplate jsonRedisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("有人进来了，我看看...");
        //转化，不然拿不到token 这个接口是没有实现这个方法的
        HttpServletRequest request = (HttpServletRequest) servletRequest;

        String token = request.getHeader("token");

        //这里 一方通行 ！！
        if(token == null)
            return;

        Map<String,Object> cache = (HashMap<String, Object>) jsonRedisTemplate.opsForValue().get(token);

        if( (Integer)cache.get("power") == PowerEnum.LEVEL_SON.getLevel())
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException { }

    @Override
    public void destroy() { }
}
