package com.amchis.officewebsite.domain;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.persistence.*;

/**
 * @author beyond
 * Create at 2020-04-03 10:20
 */
@Entity
@Table(name = "stories_success")
@Data
public class StoriesSuccess {


    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 正文类型
     */
    @ApiModelProperty("id")
    @Column(name = "username")
    private String username;

    /**
     * 状态
     */
    @ApiModelProperty("id")
    @Column(name = "body_status")
    private String bodyStatus;

    /**
     * 置顶排序
     */
    @ApiModelProperty("id")
    @Column(name = "top_order")
    private Integer topOrder;

    /**
     * 创建者名称
     */
    @ApiModelProperty("id")
    @Column(name = "create_username")
    private String createUsername;

    /**
     * 图片上传id
     */
    @ApiModelProperty("id")
    @Column(name = "cover_img")
    private Integer coverImg;

    /**
     * 阅读数量
     */
    @ApiModelProperty("id")
    @Column(name = "read_num")
    private Integer readNum;

    /**
     * 创建时间
     */
    @ApiModelProperty("id")
    @Column(name = "create_time")
    private String createTime;

    /**
     * 更新时间
     */
    @ApiModelProperty("id")
    @Column(name = "update_time")
    private String updateTime;

    /**
     * 文章id
     */
    @ApiModelProperty("id")
    @Column(name = "article_id")
    private Integer articleId;

    /**
     * 20字简述
     */
    @ApiModelProperty("id")
    @Column(name = "article_desc")
    private String articleDesc;

    /**
     * 成功故事
     */
    @ApiModelProperty("id")
    @Column(name = "wear_time")
    private String wearTime;
}