package com.green.greengram.feed.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UploadFeedReq {
    @JsonIgnore
    private long feedId;

    private long writerId;
    private String contents;
    private String location;
}
