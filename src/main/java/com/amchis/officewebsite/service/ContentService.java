package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Content;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "内容更新")
public interface ContentService {

    @ApiOperation("保存")
    BaseResponse<JSONObject> save(@RequestBody Content content);

    @ApiOperation("删除")
    BaseResponse<JSONObject> delete(@RequestParam("id") Integer id);

    @ApiOperation("列表")
    BaseResponse<JSONObject> list();
}
