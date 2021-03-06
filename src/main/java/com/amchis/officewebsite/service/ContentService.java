package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.ContentPageQuery;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.domain.dto.ContentDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "内容更新")
public interface ContentService {

    @ApiOperation("保存")
    BaseResponse<JSONObject> save(@RequestBody ContentDto contentDto);

    @ApiOperation("删除")
    BaseResponse<JSONObject> delete(@RequestParam("id") Integer id);

    @ApiOperation("分页列表")
    QueryResponseResult findPageList(int page, int size, ContentPageQuery pageQuery);

    @ApiOperation("根据一级页面/二级页面查询最新一条")
    BaseResponse<JSONObject> findByFirstPageOrSecondPage(String firstPage,String secondPage);

}
