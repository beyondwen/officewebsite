package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author beyond
 * Create at 2020-03-23 10:13
 */
@Entity
@Table(name = "articlecontent")
@Data
@ApiModel
public class Articlecontent {


    /**
     *id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    /**
     * 文章标题
     */
    @ApiModelProperty("文章标题")
    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 文章来源
     */
    @ApiModelProperty("文章来源")
    @Column(name = "article_source")
    private String articleSource;

    /**
     * 文章内容
     */
    @ApiModelProperty("文章内容")
    @Column(name = "article_content")
    private String articleContent;

    /**
     * 分类(0正文1能量动态)
     */
    @ApiModelProperty("分类(0正文1能量动态)")
    @Column(name = "article_category")
    private Integer articleCategory;
}