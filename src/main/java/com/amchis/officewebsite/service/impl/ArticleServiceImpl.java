package com.amchis.officewebsite.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.amchis.officewebsite.base.BaseApiService;
import com.amchis.officewebsite.base.BaseResponse;
import com.amchis.officewebsite.base.request.PageQuery;
import com.amchis.officewebsite.base.response.CommonCode;
import com.amchis.officewebsite.base.response.QueryResponseResult;
import com.amchis.officewebsite.base.response.QueryResult;
import com.amchis.officewebsite.domain.ACDo;
import com.amchis.officewebsite.domain.Article;
import com.amchis.officewebsite.domain.Articlecontent;
import com.amchis.officewebsite.jpa.ArticleRepository;
import com.amchis.officewebsite.jpa.ArticlecontentRepository;
import com.amchis.officewebsite.service.ArticleService;
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
import java.util.Optional;

@Service
@Slf4j
public class ArticleServiceImpl extends BaseApiService implements ArticleService {

    @Autowired
    private ArticleRepository articleRepository;

    @Autowired
    private ArticlecontentRepository articlecontentRepository;

    @Override
    public BaseResponse<JSONObject> add(Article article) {
        articleRepository.save(article);
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
            Integer category = pageQuery.getArticleCategory();
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
            predicate = cb.and(predicate, cb.equal(root.get("articleCategory"), category));
            return predicate;
        };
        Page<Article> all = articleRepository.findAll(specification, pageable);

        QueryResult<Article> queryResult = new QueryResult<>();
        //数据列表
        queryResult.setList(all.getContent());
        //数据总记录数
        queryResult.setTotal(all.getTotalElements());
        return new QueryResponseResult(CommonCode.SUCCESS, queryResult);
    }

    @Override
    public BaseResponse<JSONObject> delete(int id) {
        try {
            articleRepository.deleteById(id);
            return setResultSuccess("删除成功");
        } catch (Exception e) {
            return setResultError("删除失败");
        }
    }

    @Override
    public BaseResponse<JSONObject> detail(int id) {
        Optional<Article> optional = articleRepository.findById(id);
        if (optional.isPresent()) {
            Article article = optional.get();
            Integer id1 = article.getArticleId();
            Optional<Articlecontent> optional1 = articlecontentRepository.findById(id1);
            if (optional1.isPresent()){
                ACDo acDo = new ACDo();
                Articlecontent articlecontent = optional1.get();
                acDo.setArticle(article);
                acDo.setArticlecontent(articlecontent);
                return setResultSuccess(acDo);
            }
            return setResultError("未查询到数据");
        }
        return setResultError("未查询到数据");
    }
}
