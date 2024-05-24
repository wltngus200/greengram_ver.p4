package com.green.greengram.user.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Builder
public class UserSignInRes {
    private long userId;
    private String pic;
    private String nm;

}
