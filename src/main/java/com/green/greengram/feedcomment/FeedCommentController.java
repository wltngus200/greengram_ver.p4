package com.green.greengram.feedcomment;

import com.green.greengram.common.ResultDto;
import com.green.greengram.feedcomment.model.PostCommentReq;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/feed/comment")
public class FeedCommentController {
    private final FeedCommentService service;

    public ResultDto<Integer> postComment(PostCommentReq p){
        int result=service.postComment(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultData(result)
                .resultMsg("(oﾟvﾟ)ノ선플 운동")
                .build();
    }

    public ResultDto<Integer> deleteComment(DeleteCommentReq p){
        int result= service.deleteComment(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultData(result)
                .resultMsg("(⊙_(⊙_⊙)_⊙)")
                .build();
    }

}
