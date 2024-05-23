package com.green.greengram.feed.model;

import com.green.greengram.common.Paging;

public class GetFeedReq extends Paging {
    private long modora;

    public GetFeedReq(long page, long length, long startIdx, long x){
        super(page, length);
        this.modora=x;
    }
}
