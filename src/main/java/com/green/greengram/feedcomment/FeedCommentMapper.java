package com.green.greengram.feedcomment;

import com.green.greengram.feedcomment.model.PostCommentReq;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedCommentMapper {
    int postComment(PostCommentReq p);

    int deleteComment(DeleteCommentReq p);
}
