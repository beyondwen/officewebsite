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
@Table(name = "article")
@Data
@ApiModel(value = "文章信息")
public class Article {


    /**
     * id
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @ApiModelProperty("id")
    private Integer id;

    /**
     * 来源
     */
    @Column(name = "source")
    @ApiModelProperty("来源")
    private String source;

    /**
     * 正文类型
     */
    @ApiModelProperty("正文类型")
    @Column(name = "body_type")
    private Integer bodyType;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @Column(name = "body_status")
    private Integer bodyStatus;

    /**
     * 图片上传id
     */
    @ApiModelProperty("图片上传id")
    @Column(name = "cover_img")
    private Integer coverImg;

    /**
     * 阅读数量
     */
    @ApiModelProperty("阅读数量")
    @Column(name = "read_num")
    private Integer readNum;

    /**
     * 文章置顶
     */
    @ApiModelProperty("文章置顶")
    @Column(name = "article_top")
    private Integer articleTop;

    /**
     * 创建者名称
     */
    @ApiModelProperty("创建者名称")
    @Column(name = "create_username")
    private String createUsername;

    /**
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    private String createTime;

    /**
     * 置顶排序
     */
    @ApiModelProperty("置顶排序")
    @Column(name = "top_order")
    private Integer topOrder;

    /**
     * 更新时间
     */
    @ApiModelProperty("更新时间")
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 文章id
     */
    @ApiModelProperty("文章id")
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 文章简述
     */
    @ApiModelProperty("文章简述")
    @Column(name = "article_desc")
    private String articleDesc;

    /**
     * 标题
     */
    @ApiModelProperty("标题")
    @Column(name = "article_title")
    private String articleTitle;

    /**
     * 分类(0正文1能量动态)
     */
    @ApiModelProperty("分类(0正文1能量动态)")
    @Column(name = "article_category")
    private Integer articleCategory;
}