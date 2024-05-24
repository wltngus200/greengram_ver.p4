package com.green.greengram.feedcomment;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DeleteCommentReq {
    private long signedUserId;
    private long feedId;
}
