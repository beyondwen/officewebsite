package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.ContentPageQuery;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.domain.dto.ContentDto;
import com.amchis.officewebsite.service.ContentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private ContentService contentService;

    @PostMapping("/save")
    public BaseResponse<JSONObject> save(@RequestBody ContentDto content) {
        return contentService.save(content);
    }

    @GetMapping("/delete/{id}")
    public BaseResponse<JSONObject> delete(@PathVariable("id") int id) {
        return contentService.delete(id);
    }

    @GetMapping("/findPageList/{page}/{size}")
    public QueryResponseResult findPageList(@PathVariable("page") int page, @PathVariable("size") int size, ContentPageQuery pageQuery) {
        return contentService.findPageList(page, size, pageQuery);
    }
}
