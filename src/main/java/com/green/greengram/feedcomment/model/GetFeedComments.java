package com.green.greengram.feedcomment.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class GetFeedComments {
    private long commentId;
    private long feedId;
    private long userId;
    private String pic;
    private String nm;
    private String comment;
    private String createdAt;
}
