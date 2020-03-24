package com.amchis.officewebsite.service;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Article;
import com.amchis.officewebsite.domain.Articlecontent;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Api(tags = "文章正文")
public interface ArticleContentService {

    @PostMapping("/add")
    @ApiOperation("添加文章")
    BaseResponse<JSONObject> add(@RequestBody Articlecontent articlecontent);
}
