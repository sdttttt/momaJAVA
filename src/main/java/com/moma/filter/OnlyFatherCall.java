package com.moma.filter;

import com.moma.power.PowerEnum;
import org.springframework.data.redis.core.RedisTemplate;

import javax.annotation.Resource;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequestWrapper;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class OnlyFatherCall implements Filter {

    @Resource
    RedisTemplate jsonRedisTemplate;

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        HttpServletRequestWrapper wrapper = (HttpServletRequestWrapper) servletRequest;
        String token = wrapper.getHeader("token");
        if(token == null)
            return;
        Map<String,Object> map = (HashMap<String,Object>) jsonRedisTemplate.opsForValue().get(token);
        if((Integer)map.get("power") == PowerEnum.LEVEL_FATHER.getLevel())
            filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void destroy() {

    }
}
