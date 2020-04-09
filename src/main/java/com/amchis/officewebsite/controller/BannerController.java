package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Banner;
import com.amchis.officewebsite.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/save")
    public BaseResponse<JSONObject> save(@RequestBody Banner banner) {
        return bannerService.save(banner);
    }

    @GetMapping("/delete")
    public BaseResponse<JSONObject> delete(@RequestParam("id") Integer id) {
        return bannerService.delete(id);
    }

    @GetMapping("/list")
    public BaseResponse<JSONObject> list(@RequestParam("type") Integer type) {
        return bannerService.list(type);
    }
}
