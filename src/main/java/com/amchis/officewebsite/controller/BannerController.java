package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.BannerPageQuery;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.domain.dto.BannerDto;
import com.amchis.officewebsite.service.BannerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banner")
public class BannerController {

    @Autowired
    private BannerService bannerService;

    @PostMapping("/saveupdate")
    public BaseResponse<JSONObject> saveupdate(@RequestBody BannerDto bannerDto) {
        return bannerService.saveupdate(bannerDto);
    }

    @GetMapping("/delete/{id}")
    public BaseResponse<JSONObject> delete(@PathVariable("id") int id) {
        return bannerService.delete(id);
    }

    @GetMapping("/findPageList/{page}/{size}")
    public QueryResponseResult findPageList(@PathVariable("page") int page, @PathVariable("size") int size, BannerPageQuery pageQuery) {
        return bannerService.findPageList(page, size, pageQuery);
    }

    @GetMapping("/findByFirstPage")
    public BaseResponse<JSONObject> findByFirstPage(@RequestParam String firstPage) {
        return bannerService.findByFirstPage(firstPage);
    }
}
