package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.BannerArry;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "轮播图")
public interface BannerService {

    @ApiOperation("保存")
    BaseResponse<JSONObject> save(@RequestBody BannerArry banner);

    @ApiOperation("删除")
    BaseResponse<JSONObject> delete(@RequestParam("id") Integer id);

    @ApiOperation("轮播图")
    BaseResponse<JSONObject> list(@RequestParam("type") Integer type);
}
