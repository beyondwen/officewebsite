package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.PageQuery;
import com.amchis.officewebsite.base.response.CommonCode;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.base.response.QueryResult;
import com.amchis.officewebsite.domain.EnergyDynamics;
import com.amchis.officewebsite.jpa.EnergyDynamicsRepository;
import com.amchis.officewebsite.service.EnergyDynamicsService;
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

@Service
@Slf4j
public class EnergyDynamicsServiceImpl extends BaseApiService implements EnergyDynamicsService {

    @Autowired
    private EnergyDynamicsRepository energyDynamicsRepository;

    @Override
    public BaseResponse<JSONObject> add(EnergyDynamics energyDynamics) {
        energyDynamicsRepository.save(energyDynamics);
        return setResultSuccess();
    }

    @Override
    public QueryResponseResult findPageList(int page, int size, PageQuery pageQuery) {
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
            String title = pageQuery.getTitle();
            String endTime = pageQuery.getEndTime();
            String startTime = pageQuery.getStartTime();
            String source = pageQuery.getSource();
            //起始日期
            if (StringUtils.isNotEmpty(startTime)) {
                predicate.getExpressions().add(cb.greaterThanOrEqualTo(root.get("createTime").as(String.class), startTime));
            }
            //结束日期
            if (StringUtils.isNotEmpty(endTime)) {
                predicate.getExpressions().add(cb.lessThanOrEqualTo(root.get("createTime").as(String.class), endTime));
            }
            if (StringUtils.isNotEmpty(title)) {
                predicate = cb.and(predicate, cb.like(root.get("articleTitle"), "%" + title + "%"));
            }
            if (StringUtils.isNotEmpty(source)) {
                predicate = cb.and(predicate, cb.like(root.get("source"), "%" + source + "%"));
            }
            return predicate;
        };
        Page<EnergyDynamics> all = energyDynamicsRepository.findAll(specification, pageable);
        QueryResult<EnergyDynamics> queryResult = new QueryResult<>();
        //数据列表
        queryResult.setList(all.getContent());
        //数据总记录数
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }
}
