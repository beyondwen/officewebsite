package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Article;
import com.amchis.officewebsite.jpa.ArticleRepository;
import com.amchis.officewebsite.service.ArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ArticleServiceImpl extends BaseApiService implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Override
    public BaseResponse<JSONObject> add(Article article) {
        articleRepository.save(article);
        return setResultSuccess();
    }
}
