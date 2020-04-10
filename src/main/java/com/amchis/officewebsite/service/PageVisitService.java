package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(tags = "后台首页数据获取")
public interface PageVisitService {

    @ApiOperation("data")
    BaseResponse<JSONObject> data();
}
