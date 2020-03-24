package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Articlecontent;
import com.amchis.officewebsite.service.ArticleContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/articlecontent")
public class ArticleContentController {

    @Autowired
    private ArticleContentService articleContentService;

    @PostMapping("/add")
    public BaseResponse<JSONObject> add(@RequestBody Articlecontent articlecontent) {
        return articleContentService.add(articlecontent);
    }
}
