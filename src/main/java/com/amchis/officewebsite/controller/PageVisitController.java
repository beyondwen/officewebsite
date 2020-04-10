package com.amchis.officewebsite.controller;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.service.PageVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pagevisit")
public class PageVisitController {

    @Autowired
    private PageVisitService pageVisitService;

    @GetMapping("/data")
    public BaseResponse<JSONObject> data() {
        return pageVisitService.data();
    }
}
