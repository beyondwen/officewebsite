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
    @ApiModelProperty("正文类型")
    @Column(name = "username")
    private String username;

    /**
     * 状态
     */
    @ApiModelProperty("状态")
    @Column(name = "body_status")
    private String bodyStatus;

    /**
     * 置顶排序
     */
    @ApiModelProperty("置顶排序")
    @Column(name = "top_order")
    private Integer topOrder;

    /**
     * 创建者名称
     */
    @ApiModelProperty("创建者名称")
    @Column(name = "create_username")
    private String createUsername;

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
     * 创建时间
     */
    @ApiModelProperty("创建时间")
    @Column(name = "create_time")
    private String createTime;

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
     * 20字简述
     */
    @ApiModelProperty("20字简述")
    @Column(name = "article_desc")
    private String articleDesc;

    /**
     * 穿戴时间
     */
    @ApiModelProperty("穿戴时间")
    @Column(name = "wear_time")
    private String wearTime;
}