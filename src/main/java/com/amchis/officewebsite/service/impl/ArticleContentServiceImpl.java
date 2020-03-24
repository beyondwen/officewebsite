package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Articlecontent;
import com.amchis.officewebsite.jpa.ArticlecontentRepository;
import com.amchis.officewebsite.service.ArticleContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleContentServiceImpl extends BaseApiService implements ArticleContentService {

    @Autowired
    private ArticlecontentRepository articlecontentRepository;

    @Override
    public BaseResponse<JSONObject> add(Articlecontent articlecontent) {
        Articlecontent save = articlecontentRepository.save(articlecontent);
        return setResultSuccess(save);
    }
}
