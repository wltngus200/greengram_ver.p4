package com.green.greengram.feed.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteFeedReq {
    private long signedUserId;
    private long feedId;
}
