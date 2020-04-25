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
@Table(name = "file")
@Data
@ApiModel
public class TransferFile {


    /**
     * id
     */
    @ApiModelProperty("id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    /**
     * 文件路径
     */
    @ApiModelProperty("文件路径")
    @Column(name = "file_url")
    private String fileUrl;

    /**
     * 排序
     */
    @ApiModelProperty("排序")
    @Column(name = "order_num")
    private Integer orderNum;

    /**
     * type
     */
    @ApiModelProperty("文件类型 1 图片 2 视频")
    @Column(name = "type")
    private Integer type;

    /**
     * link
     */
    @ApiModelProperty("当type为2时 转向链接为空")
    @Column(name = "link")
    private String link;

    /**
     * 缩略图url
     */
    @ApiModelProperty("缩略图url")
    @Column(name = "video_cover_id")
    private Integer videoCoverId;

    /**
     * 缩略图url
     */
    @ApiModelProperty("关联id")
    @Column(name = "related_id")
    private Integer relatedId;

    @ApiModelProperty("创建人")
    @Column(name = "create_username")
    private String createUsername;

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

}