package com.green.greengram.feed.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

@Getter
@Builder
@ToString
public class UploadFeedPicsReq {
    private long feedId;
    private List<String> pics;
}
