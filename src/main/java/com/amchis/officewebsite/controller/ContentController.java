package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.BannerArry;
import com.amchis.officewebsite.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/content")
public class ContentController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/save")
    public BaseResponse<JSONObject> save(@RequestBody BannerArry bannerArry) {
        return bannerService.save(bannerArry);
    }

    @GetMapping("/delete/{id}")
    public BaseResponse<JSONObject> delete(@PathVariable("id") int id) {
        return bannerService.delete(id);
    }

    @GetMapping("/list")
    public BaseResponse<JSONObject> list(@RequestParam("type") int type) {
        return bannerService.list(type);
    }
}
