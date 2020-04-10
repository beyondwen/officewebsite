package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author beyond
 * Create at 2020-04-10 11:03
 */
@Entity
@Table(name = "page_visit")
@Data
@ApiModel
public class PageVisit {


    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     *页面类型
     */
    @ApiModelProperty("页面类型")
    @Column(name = "page_type")
    private Integer pageType;

    /**
     * 访问量
     */
    @ApiModelProperty("访问量")
    @Column(name = "page_views")
    private Integer pageViews;

    /**
     * 访问月份
     */
    @ApiModelProperty("访问月份")
    @Column(name = "views_time")
    private String viewsTime;
}