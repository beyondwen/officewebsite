package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Banner;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestParam;

@Api(tags = "banner 图")
public interface BannerService {

    @ApiOperation("保存更新")
    BaseResponse<JSONObject> saveupdate(Banner banner);

    @ApiOperation("删除")
    BaseResponse<JSONObject> delete(@RequestParam("id") Integer id);

}
