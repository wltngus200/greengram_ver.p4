package com.green.greengram.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Paging {
    private Long page;
    private Long length;
    private Long startIdx;

    public Paging(Long page, Long length){
        this.page=page!=null?page:1;//페이징 처리 어떻게 하더라...
        this.length=length!=null?length:10;
        this.startIdx=(page-1)*length;
    }
}
