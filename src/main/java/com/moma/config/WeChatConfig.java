package com.moma.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Data
@Component
public class WeChatConfig {

    @Value("${wechat.appid}")
    private String appid;

    @Value("${wechat.login-url}")
    private String loginUrl;

    @Value("${wechat.app-secret}")
    private String appsecret;

    public String getAppid() {
        return appid;
    }

    public void setAppid(String appid) {
        this.appid = appid;
    }

    public void setLoginUrl(String loginUrl) {
        this.loginUrl = loginUrl;
    }

    public String getAppsecret() {
        return appsecret;
    }

    public void setAppsecret(String appsecret) {
        this.appsecret = appsecret;
    }

    public String getLoginUrl() {
        return loginUrl;
    }
}
