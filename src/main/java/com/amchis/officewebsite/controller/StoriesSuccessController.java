package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.PageQuery;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.domain.StoriesSuccess;
import com.amchis.officewebsite.service.StoriesSuccessService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/storiessuccess")
public class StoriesSuccessController {

    @Autowired
    private StoriesSuccessService service;

    @PostMapping("/add")
    public BaseResponse<JSONObject> add(@RequestBody StoriesSuccess storiesSuccess) {
        return service.add(storiesSuccess);
    }

    @GetMapping("/findPageList/{page}/{size}")
    public QueryResponseResult findPageList(@PathVariable("page") int page, @PathVariable("size") int size, PageQuery pageQuery) {
        return service.findPageList(page, size, pageQuery);
    }

    @GetMapping("/delete/{id}")
    public BaseResponse<JSONObject> delete(@PathVariable("id") int id) {
        return service.delete(id);
    }

    @GetMapping("/detail/{id}")
    public BaseResponse<JSONObject> detail(@PathVariable("id") int id) {
        return service.detail(id);
    }
}
