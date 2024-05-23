package com.green.greengram.feed.model;

import com.green.greengram.feedcomment.model.GetFeedComments;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class GetFeedRes {
    private long feedId;
    private long writerId;
    private String writerPic;
    private String nm;
    private String contents;
    private String location;
    private String createdAt;

    private List<String> pics;
    private List<GetFeedComments> comments;

    private int isMoreComments;
}
