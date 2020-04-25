package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.BannerPageQuery;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.domain.dto.BannerDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "banner 图")
public interface BannerService {

    @ApiOperation("保存更新")
    BaseResponse<JSONObject> saveupdate(BannerDto bannerDto);

    @ApiOperation("删除")
    BaseResponse<JSONObject> delete(@RequestParam("id") Integer id);

    @ApiOperation("分页列表")
    QueryResponseResult findPageList(int page, int size, BannerPageQuery bannerPageQuery);

    @ApiOperation("根据一级页面查询最新一条")
    BaseResponse<JSONObject> findByFirstPage(@RequestParam("firstPage") String firstPage);

}
