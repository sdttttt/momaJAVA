package com.moma.service;

import java.util.Map;

public interface TokenService {

    Map<String,Object> getToken(String code);

    Map<String,Object> checkToken(String token);

}
