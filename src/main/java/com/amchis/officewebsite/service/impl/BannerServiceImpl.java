package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Banner;
import com.amchis.officewebsite.service.BannerService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BannerServiceImpl extends BaseApiService implements BannerService {

    @Override
    public BaseResponse<JSONObject> saveupdate(Banner banner) {
        return null;
    }

    @Override
    public BaseResponse<JSONObject> delete(Integer id) {
        return null;
    }
}
