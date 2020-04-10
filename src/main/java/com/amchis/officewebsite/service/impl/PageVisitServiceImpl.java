package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.PageVisit;
import com.amchis.officewebsite.jpa.PageVisitRepository;
import com.amchis.officewebsite.service.PageVisitService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PageVisitServiceImpl extends BaseApiService implements PageVisitService {

    @Autowired
    private PageVisitRepository pageVisitRepository;

    @Override
    public BaseResponse<JSONObject> data() {
        List<PageVisit> all = pageVisitRepository.findAll();
        return setResultSuccess(all);
    }
}
