package com.moma.config;

import com.moma.filter.OnlyPrimaryCall;
import com.moma.filter.OnlySonCall;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Configuration
public class FilterConfig {

    @Bean
    public FilterRegistrationBean onlyPrimaryCall(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new OnlyPrimaryCall());
        bean.addUrlPatterns("/user/wallet");
        return bean;
    }
}
