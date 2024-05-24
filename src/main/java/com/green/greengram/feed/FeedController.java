package com.green.greengram.feed;

import com.green.greengram.common.ResultDto;
import com.green.greengram.feed.model.DeleteFeedReq;
import com.green.greengram.feed.model.GetFeedReq;
import com.green.greengram.feed.model.GetFeedRes;
import com.green.greengram.feed.model.UploadFeedReq;
import lombok.RequiredArgsConstructor;
import org.springdoc.core.annotations.ParameterObject;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequestMapping("api/feed")
@RequiredArgsConstructor
public class FeedController {
    private final FeedService service;

    @PostMapping
    public ResultDto<Integer> postFeed(@RequestPart List<MultipartFile> pics, @RequestPart UploadFeedReq p){
        int result=service.postFeed(pics, p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("(ﾉ◕ヮ◕)ﾉ*:･ﾟ✧ 타란~")
                .resultData(result)
                .build();
    }

    @DeleteMapping
    public ResultDto<Integer> deleteFeed(@ParameterObject @ModelAttribute DeleteFeedReq p){

        int result= service.deleteFeed(p);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("¯\\_(ツ)_/¯ 모르겠는데?")
                .resultData(result).build();
    }

    @GetMapping
    public ResultDto<List<GetFeedRes>> getFeed(@ParameterObject @ModelAttribute GetFeedReq p){
        //list
        List<GetFeedRes> list=service.getFeed(p);

        return ResultDto.<List<GetFeedRes>>builder()
            .statusCode(HttpStatus.OK)
            .resultMsg("_(:з)∠)_ 할 거 너무 많앙")
            .resultData(list)
            .build();

    }
}
