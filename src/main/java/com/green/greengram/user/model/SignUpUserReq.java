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

    @Schema(description = "USER의 ID")
    private String uid;
    @Schema(description ="USER의 PASSWORD")
    private String upw;
    @Schema(description="USER의 NAME")
    private String nm;

    @Schema(name="USER PIC", description = "사진은 필수가 아님"/*여기 뭘 넣어야되는데*/)
    @JsonIgnore
    private String pic;
}
