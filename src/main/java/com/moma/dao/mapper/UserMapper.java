package com.moma.dao.mapper;

import com.moma.dao.bean.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User userByOpenid(String openid);

    Integer makeUser(User user);
}
