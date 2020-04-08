package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.PageQuery;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.domain.Article;
import com.amchis.officewebsite.service.ArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/article")
public class ArticleController {

    @Autowired
    private ArticleService service;

    @PostMapping("/add")
    public BaseResponse<JSONObject> add(@RequestBody Article article) {
        return service.add(article);
    }

    @GetMapping("/findPageList/{page}/{size}")
    public QueryResponseResult findPageList(@PathVariable("page") int page, @PathVariable("size") int size, PageQuery pageQuery) {
        return service.findPageList(page, size, pageQuery);
    }

    @GetMapping("/delete")
    public BaseResponse<JSONObject> delete(@PathVariable("id") Integer id) {
        return service.delete(id);
    }
}
