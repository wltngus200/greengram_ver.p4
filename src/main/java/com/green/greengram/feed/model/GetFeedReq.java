package com.green.greengram.feed.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.green.greengram.common.Paging;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;
import org.springframework.web.bind.annotation.BindParam;
@Getter
@Setter
public class GetFeedReq extends Paging {
    @Schema(name="signed_user_id")
    private long signedUserId;

    public GetFeedReq(Integer page, Integer length, @BindParam("signed_user_id")Long signedUserId){
        super(page, length);
        this.signedUserId=signedUserId;
    }
}
