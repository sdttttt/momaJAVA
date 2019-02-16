package com.moma.dao.mapper;

import com.moma.dao.bean.User;
import org.apache.ibatis.annotations.Mapper;

import java.math.BigDecimal;

@Mapper
public interface UserMapper {

    User userByOpenid(String openid);

    Integer makeUser(User user);

    BigDecimal getWalletByOpenid(String openid);
}
