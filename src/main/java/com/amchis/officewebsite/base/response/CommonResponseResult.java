package com.amchis.officewebsite.base.response;

import lombok.Data;

@Data
public class CommonResponseResult<T> extends ResponseResult {

    T data;

    public CommonResponseResult(ResultCode resultCode, T data) {
        super(resultCode);
        this.data = data;
    }

    public CommonResponseResult(ResultCode resultCode) {
        super(resultCode);
    }
}
