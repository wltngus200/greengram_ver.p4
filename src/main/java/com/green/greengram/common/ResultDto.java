package com.green.greengram.common;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Builder
@Getter
@Setter
public class ResultDto <T> {
    private HttpStatus statusCode;
    private String resultMsg;
    private T resultData;
}
