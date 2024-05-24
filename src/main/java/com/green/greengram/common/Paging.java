package com.green.greengram.common;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public abstract class Paging {
    private int page;
    private int length;
    private int startIdx;

    public Paging(Integer page, Integer length){
        this.page=(page!=null?page:GlobalNum.DEFAULT_PAGE);//페이징 처리 어떻게 하더라...
        this.length=(length!=null?length:GlobalNum.DEFAULT_LENGTH);
        this.startIdx=(this.page-1)*length;
    }
}
