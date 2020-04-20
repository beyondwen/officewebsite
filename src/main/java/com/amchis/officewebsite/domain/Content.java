package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * 
 * @author beyond
 * Create at 2020-04-13 10:10
 */
@Entity
@Table(name = "content")
@Data
@ApiModel
public class Content {

    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 一级页面
     */
    @Column(name = "first_page")
    private Integer firstPage;

    /**
     * 二级页面
     */
    @Column(name = "second_page")
    private Integer secondPage;

    /**
     * 创建人
     */
    @Column(name = "create_username")
    private String createUsername;

    /**
     * 创建时间
     */
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 正文id
     */
    @Column(name = "article_id")
    private Integer articleId;
}