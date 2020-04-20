package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.domain.Content;
import com.amchis.officewebsite.jpa.ContentRepository;
import com.amchis.officewebsite.service.ContentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ContentServiceImpl extends BaseApiService implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public BaseResponse<JSONObject> save(Content content) {
        Content save = contentRepository.save(content);
        if (save != null) {
            return setResultSuccess();
        }
        return setResultError("保存失败");
    }

    @Override
    public BaseResponse<JSONObject> delete(Integer id) {
        try {
            contentRepository.deleteById(id);
            return setResultSuccess("删除成功");
        } catch (Exception e) {
            return setResultError("删除失败");
        }
    }

    @Override
    public BaseResponse<JSONObject> list() {
        List<Content> all = contentRepository.findAll();
        return setResultSuccess(all);
    }
}