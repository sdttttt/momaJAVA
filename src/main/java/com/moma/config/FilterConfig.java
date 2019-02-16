package com.moma.config;

import com.moma.filter.OnlyPrimaryCall;
import com.moma.filter.OnlySonCall;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FilterConfig {

    public FilterRegistrationBean onlySonCall(){
        FilterRegistrationBean bean = new FilterRegistrationBean(new OnlySonCall());
        bean.addUrlPatterns("/");
        return bean;
    }

    @Bean
    public FilterRegistrationBean onlyPrimaryCall(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new OnlyPrimaryCall());
        bean.addUrlPatterns("/wallet");
        return bean;
    }
}
