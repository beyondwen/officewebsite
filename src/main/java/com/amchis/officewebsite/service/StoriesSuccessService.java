package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.PageQuery;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.domain.StoriesSuccess;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "成功故事")
public interface StoriesSuccessService {

    @PostMapping("/add")
    @ApiOperation("设置文本信息")
    BaseResponse<JSONObject> add(@RequestBody StoriesSuccess storiesSuccess);

    @GetMapping("/findPageList")
    @ApiOperation("分页列表")
    QueryResponseResult findPageList(int page, int size, PageQuery pageQuery);

    @GetMapping("/delete")
    @ApiOperation("删除")
    BaseResponse<JSONObject> delete(int id);
}
