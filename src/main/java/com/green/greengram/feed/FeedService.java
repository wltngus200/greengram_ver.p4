package com.green.greengram.feed;

import com.green.greengram.common.CustomFileUtils;
import com.green.greengram.common.GlobalNum;
import com.green.greengram.feed.model.*;
import com.green.greengram.feedcomment.model.GetFeedComments;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;
@Slf4j
@Service
@RequiredArgsConstructor
public class FeedService {
    private final FeedMapper mapper;
    private final CustomFileUtils utils;

    @Transactional
    public int postFeed(List<MultipartFile> pics, UploadFeedReq p){
        int result=mapper.postFeed(p); //내용은 DB에 전송

        //사진 업로드에 필요한 정보 추출
        UploadFeedPicsReq req= UploadFeedPicsReq.builder()
                                .feedId(p.getFeedId())
                                .pics(new ArrayList<>())
                                .build();
        try{
            String path=String.format("feed/%d",p.getFeedId());
            utils.makeFolders(path); //폴더 생성
            for(MultipartFile mf:pics) {
                String randomName=utils.makeRandomName(mf);
                String target=String.format("%s/%s", path, randomName);
                utils.transferTo(mf, target);
                req.getPics().add(randomName);
            }
            log.info("{}",req); // 디폴트 없이 리스트 추가가 가능?
            int picResult=mapper.postFeedPics(req);
        }catch(Exception e){
            e.printStackTrace();
            throw new RuntimeException("☆⌒(*＾-゜)v 처리 완료");
        }
        return result;
    }
    public int deleteFeed(DeleteFeedReq p){
        return mapper.deleteFeed(p);

    }
    public List<GetFeedRes> getFeed(GetFeedReq p){
        log.info("{}", p);
        List<GetFeedRes> list=mapper.getFeed(p);
        for(GetFeedRes res:list){
            //사진
            List<String> pics=mapper.getFeedPics(res.getFeedId());
            res.setPics(pics);

            //코멘트(3개)
            List<GetFeedComments> comments=mapper.getFeedComments(res.getFeedId());
            if(comments.size()== GlobalNum.DEFAULT_SIZE){
                res.setIsMoreComments(1);
                comments.remove(GlobalNum.DEFAULT_SIZE);
            }log.info("{}", p);
        }
        return list;
    }
}
