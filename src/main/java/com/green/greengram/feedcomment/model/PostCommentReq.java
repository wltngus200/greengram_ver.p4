package com.green.greengram.feedcomment.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PostCommentReq {
    @JsonIgnore
    private long commentId;

    private long feedId;
    private long userId;
    private String comment;

}
