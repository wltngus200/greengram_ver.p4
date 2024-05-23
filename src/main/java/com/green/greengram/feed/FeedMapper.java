package com.green.greengram.feed;

import com.green.greengram.feed.model.GetFeedRes;
import com.green.greengram.feed.model.UploadFeedPicsReq;
import com.green.greengram.feed.model.UploadFeedReq;
import com.green.greengram.feedcomment.model.GetFeedComments;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FeedMapper {
    int postFeed(UploadFeedReq p);
    int postFeedPics(UploadFeedPicsReq p); //사진을 올리기 위해선 feedId와 사진 이름만 필요

    int deleteFeed(long feedId, long signedUserId);

    List<GetFeedRes> getFeed();
    List<String> getFeedPics();
    List<GetFeedComments> getFeedComments();
}
