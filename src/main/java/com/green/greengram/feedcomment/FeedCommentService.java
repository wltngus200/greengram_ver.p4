package com.green.greengram.feedcomment;

import com.green.greengram.feedcomment.model.PostCommentReq;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeedCommentService {
    private final FeedCommentMapper mapper;

    int postComment(PostCommentReq p){
        return mapper.postComment(p);
    }
    int deleteComment(DeleteCommentReq p){
        return mapper.deleteComment(p);
    }
}
