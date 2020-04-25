package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.ContentPageQuery;
import com.amchis.officewebsite.base.response.CommonCode;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.base.response.QueryResult;
import com.amchis.officewebsite.domain.Content;
import com.amchis.officewebsite.domain.dto.ContentDto;
import com.amchis.officewebsite.jpa.ContentRepository;
import com.amchis.officewebsite.service.ContentService;
import com.amchis.officewebsite.utils.MeiteBeanUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import javax.persistence.criteria.Predicate;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
@Slf4j
public class ContentServiceImpl extends BaseApiService implements ContentService {

    @Autowired
    private ContentRepository contentRepository;

    @Override
    public BaseResponse<JSONObject> save(ContentDto contentDto) {
        Content content = MeiteBeanUtils.dtoToDo(contentDto, Content.class);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(new Date());
        content.setCreateTime(format);
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
    public QueryResponseResult findPageList(int page, int size, ContentPageQuery pageQuery) {
        //分页参数
        if (page <= 0) {
            page = 1;
        }
        page = page - 1;
        if (size <= 0) {
            size = 10;
        }
        //排序规则和分页
        Sort sort = Sort.by(Sort.Direction.DESC, "createTime");
        Pageable pageable = PageRequest.of(page, size, sort);
        Specification specification = (Specification) (root, criteriaQuery, cb) -> {
            Predicate predicate = cb.conjunction();
            String type = pageQuery.getType();
            String firstPage = pageQuery.getFirstPage();
            String secondPage = pageQuery.getSecondPage();
           /* //起始日期
            if (StringUtils.isNotEmpty(startTime)) {
                predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("createTime").as(String.class), startTime));
            }
            //结束日期
            if (StringUtils.isNotEmpty(endTime)) {
                predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("createTime").as(String.class), endTime));
            }*/
            if (StringUtils.isNotEmpty(type)) {
                predicate = cb.and(predicate, cb.equal(root.get("type"), type));
            }
            if (StringUtils.isNotEmpty(firstPage)) {
                predicate = cb.and(predicate, cb.like(root.get("firstPage"), "%" + firstPage + "%"));
            }
            if (StringUtils.isNotEmpty(secondPage)) {
                predicate = cb.and(predicate, cb.like(root.get("secondPage"), "%" + secondPage + "%"));
            }
            return predicate;
        };
        Page<Content> all = contentRepository.findAll(specification, pageable);
        QueryResult<Content> queryResult = new QueryResult<>();
        //数据列表
        queryResult.setList(all.getContent());
        //数据总记录数
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public BaseResponse<JSONObject> findByFirstPageOrSecondPage(String firstPage, String secondPage) {
        Content content = new Content();
        if (StringUtils.isNotEmpty(firstPage) && StringUtils.isNotEmpty(secondPage)) {
            content = contentRepository.findTopByFirstPageAndSecondPageOrderByCreateTimeDesc(firstPage, secondPage);
        }
        if (StringUtils.isEmpty(firstPage) && StringUtils.isNotEmpty(secondPage)) {
            content = contentRepository.findTopBySecondPageOrderByCreateTimeDesc(secondPage);
        }
        if (StringUtils.isNotEmpty(firstPage) && StringUtils.isEmpty(secondPage)) {
            content = contentRepository.findTopByFirstPageAndSecondPageIsNullOrderByCreateTimeDesc(firstPage);
        }
        return setResultSuccess(content);
    }
}