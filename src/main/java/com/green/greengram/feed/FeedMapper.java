package com.green.greengram.feed;

import com.green.greengram.feed.model.*;
import com.green.greengram.feedcomment.model.GetFeedComments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int postFeed(UploadFeedReq p);
    int postFeedPics(UploadFeedPicsReq p); //사진을 올리기 위해선 feedId와 사진 이름만 필요

    int deleteFeed(DeleteFeedReq p);

    List<GetFeedRes> getFeed(GetFeedReq p);
    List<String> getFeedPics(long feedId);
    List<GetFeedComments> getFeedComments(long feedId);
}
