package com.green.greengram.user;

import com.green.greengram.user.model.SignInUserReq;
import com.green.greengram.user.model.SignUpUserReq;
import com.green.greengram.user.model.User;
import com.green.greengram.user.model.UserSignInRes;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {
    int signUpUser(SignUpUserReq p);
    User findUserByUserId(SignInUserReq p);
}
