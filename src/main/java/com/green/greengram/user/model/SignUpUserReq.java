package com.green.greengram.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpUserReq {
    @JsonIgnore
    private long userId;

    private String uid;
    private String upw;
    private String nm;

    @JsonIgnore
    private String pic;
}
