package com.amchis.officewebsite.base.response;

import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class PageResponseResult extends ResponseResult {

     PageInfo pageInfo;

    public PageResponseResult(ResultCode resultCode, PageInfo pageInfo){
        super(resultCode);
       this.pageInfo = pageInfo;
    }

}
