package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Article;
import com.amchis.officewebsite.domain.Articlecontent;
import com.amchis.officewebsite.domain.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "文章信息")
public interface ArticleService {

    @PostMapping("/add")
    @ApiOperation("设置文本信息")
    BaseResponse<JSONObject> add(@RequestBody Article article);
}
