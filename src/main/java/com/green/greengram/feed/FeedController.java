package com.green.greengram.feed;

import com.green.greengram.common.ResultDto;
import com.green.greengram.feed.model.GetFeedRes;
import com.green.greengram.feed.model.UploadFeedReq;
import lombok.RequiredArgsConstructor;
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
    public ResultDto<Integer> deleteFeed(@RequestParam long feedId, @RequestParam long signedUserId){
        //class로 만들어??? 개별로 하는 거랑 뭔 차이야..?

        int result= service.deleteFeed(feedId, signedUserId);
        return ResultDto.<Integer>builder()
                .statusCode(HttpStatus.OK)
                .resultMsg("¯\\_(ツ)_/¯ 모르겠는데?")
                .resultData(result).build();
    }

    @GetMapping
    public ResultDto<List<GetFeedRes>> getFeed(){
        //list
        List<GetFeedRes> list=service.getFeed();

        return ResultDto.<List<GetFeedRes>>builder()
            .statusCode(HttpStatus.OK)
            .resultMsg("_(:з)∠)_ 할 거 너무 많앙")
            .build();

    }
}
